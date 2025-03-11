import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.List;
/**
 * Клас для тестування основної функціональності.
 */
public class MainTest {
    private Calc calc;

    @Before
    public void setUp() {
        calc = new Calc();
    }

    @Test
    public void testInit() {
        calc.init("10", "11", "100"); // 2, 3, 4 in decimal
        List<Item2d> results = calc.getResults();

        Assert.assertEquals(1, results.size());
        Item2d room = results.get(0);

        Assert.assertEquals(2, room.getLength());
        Assert.assertEquals(3, room.getWidth());
        Assert.assertEquals(4, room.getHeight());
        Assert.assertEquals(10, room.getPerimeter());
        Assert.assertEquals(6, room.getArea());
        Assert.assertEquals(24, room.getVolume());
    }

    @Test
    public void testSaveAndRestore() throws IOException, ClassNotFoundException {
        calc.init("101", "110", "111"); // 5, 6, 7 in decimal
        calc.save();

        Calc newCalc = new Calc();
        newCalc.restore();
        List<Item2d> results = newCalc.getResults();

        Assert.assertEquals(1, results.size());
        Item2d room = results.get(0);

        Assert.assertEquals(5, room.getLength());
        Assert.assertEquals(6, room.getWidth());
        Assert.assertEquals(7, room.getHeight());
        Assert.assertEquals(22, room.getPerimeter());
        Assert.assertEquals(30, room.getArea());
        Assert.assertEquals(210, room.getVolume());
    }
}
