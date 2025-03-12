import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

/**
 * Клас містить тестові методи для перевірки основної функціональності програми, таких як додавання результатів і їх перегляд.
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

    @Test
    public void testUndo() {
        calc.init("10", "11", "100"); // 2, 3, 4 in decimal
        calc.undo();
        List<Item2d> results = calc.getResults();
        Assert.assertTrue(results.isEmpty());
    }

    @Test
    public void testComputeStatistics() {
        // Додаємо кілька кімнат для тестування статистики
        calc.init("10", "11", "100"); // 2, 3, 4 -> Area = 6
        calc.init("101", "110", "111"); // 5, 6, 7 -> Area = 30
        calc.init("111", "100", "101"); // 7, 4, 5 -> Area = 28

        // Запускаємо підрахунок статистики
        calc.computeStatistics();

        // Отримуємо результати
        List<Item2d> results = calc.getResults();

        int minArea = results.stream().mapToInt(Item2d::getArea).min().orElse(0);
        int maxArea = results.stream().mapToInt(Item2d::getArea).max().orElse(0);
        double avgArea = results.stream().mapToInt(Item2d::getArea).average().orElse(0.0);

        // Перевіряємо правильність підрахунків
        Assert.assertEquals(6, minArea);
        Assert.assertEquals(30, maxArea);
        Assert.assertEquals(21.33, avgArea, 0.01); // Точність до двох знаків
    }

}