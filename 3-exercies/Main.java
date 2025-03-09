import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас для основної логіки програми.
 */
public class Main {
    private List<String> results;

    public Main() {
        results = new ArrayList<>();
    }

    // Метод для додавання результату
    public void addResult(String result) {
        results.add(result);
    }

    public void viewResults() {
        if (results.isEmpty()) {
            System.out.println("No results to show.");
        } else {
            for (String result : results) {
                System.out.println(result);
            }
        }
    }
    public List<String> getResults() {
        return results;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add result");
            System.out.println("2. View results");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter result to add: ");
                    String result = scanner.nextLine();
                    addResult(result);
                    break;
                case "2":
                    viewResults();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (!choice.equals("3"));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu(); // Викликаємо метод меню
    }
}
