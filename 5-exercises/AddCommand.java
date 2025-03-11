import java.util.Scanner;

/**
 * Команда для додавання кімнати.
 */
public class AddCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length (binary): ");
        String lengthBin = scanner.nextLine();
        System.out.print("Enter width (binary): ");
        String widthBin = scanner.nextLine();
        System.out.print("Enter height (binary): ");
        String heightBin = scanner.nextLine();
        
        Calc.getInstance().init(lengthBin, widthBin, heightBin);
        System.out.println("Room added successfully.");
    }
}