import java.io.IOException;
import java.util.Scanner;
/**
 * Основний клас програми, відповідає за взаємодію з користувачем.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = new Calc();
        
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Enter new room");
            System.out.println("2. Save current rooms");
            System.out.println("3. Restore rooms");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter length in binary: ");
                    String lengthBin = scanner.nextLine();
                    System.out.print("Enter width in binary: ");
                    String widthBin = scanner.nextLine();
                    System.out.print("Enter height in binary: ");
                    String heightBin = scanner.nextLine();
                    calc.init(lengthBin, widthBin, heightBin);
                    calc.showResults();
                    break;
                case "2":
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Error saving results.");
                    }
                    break;
                case "3":
                    try {
                        calc.restore();
                        calc.showResults();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error restoring results.");
                    }
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
