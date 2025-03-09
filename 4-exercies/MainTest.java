import org.junit.Assert;
import org.junit.Test;

/**
 * Клас для тестування основної функціональності.
 */
public class MainTest {

    @Test
    public void testAddResult() {
        Main main = new Main();
        main.menu();
        Assert.assertTrue("Results list should have at least one result", main.getResults().size() > 0);
    }

    @Test
    public void testViewResults() {
        Main main = new Main();
        main.menu();
        main.viewResults();
    }
}
