import java.util.List;
import java.util.Scanner;

/**
 * Клас для основної логіки програми.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private ViewableTable viewableTable = new ViewableTable();
    public void menu() {
        // Збираємо дані
        System.out.print("Enter number of results to show: ");
        int numResults = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numResults; i++) {
            System.out.print("Enter x value for result " + (i + 1) + ": ");
            double x = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter function type for result " + (i + 1) + ": ");
            String functionType = scanner.nextLine();
            Item2d result = new Item2d(x, Math.sin(x), functionType);
            viewableTable.addResult(result);
        }
        viewableTable.displayResults();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public List<Item2d> getResults() {
        return viewableTable.getResults();
    }

    public void viewResults() {
        viewableTable.displayResults();
    }
}
