import java.util.Scanner;

/**
 * Клас, що реалізує логіку роботи меню.
 */
public class Application {
    private static Application instance = new Application();
    private Menu menu = new Menu();

    private Application() {
        menu.add("undo", new UndoCommand());
        menu.add("save", new SaveCommand());
        menu.add("restore", new RestoreCommand());
        menu.add("add", new AddCommand());
        menu.add("view", new ViewCommand());
        menu.add("stats", new StatisticsCommand());
    }

    public static Application getInstance() {
        return instance;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add new room");
            System.out.println("2. Restore rooms");
            System.out.println("3. Undo last operation");
            System.out.println("4. Save rooms");
            System.out.println("5. Show statistics");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    menu.execute("add");
                    menu.execute("view");
                    break;
                case "2":
                    menu.execute("restore");
                    menu.execute("view");
                    break;
                case "3":
                    menu.execute("undo");
                    menu.execute("view");
                    break;
                case "4":
                    menu.execute("save");
                    break;
                case "5":
                    menu.execute("stats");
                    break;
                case "6":
                    System.out.println("Shutting down worker threads...");
                    Calc.getInstance().shutdown();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
