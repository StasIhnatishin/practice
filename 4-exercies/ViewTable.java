import java.util.List;

/**
 * Клас для відображення результатів у вигляді таблиці.
 */
public class ViewTable {

    public void displayTableWithHeader(List<Item2d> results) {
        System.out.println("|------------|------------|----------------------|");
        System.out.println("|     x      |     y      |     Function         |");
        System.out.println("|------------|------------|----------------------|");

        for (Item2d result : results) {
            displayResult(result);
        }
        System.out.println("|------------|------------|----------------------|");
    }
    public void displayResult(Item2d result) {
        System.out.printf("| %-10s | %-10s | %-20s |\n", result.getX(), result.getY(), result.getFunctionType());
    }
}
