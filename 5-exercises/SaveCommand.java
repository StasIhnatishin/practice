import java.io.IOException;

/**
 * Команда для збереження поточних кімнат у файл.
 */
public class SaveCommand implements Command {
    @Override
    public void execute() {
        try {
            Calc.getInstance().save();
        } catch (IOException e) {
            System.out.println("Error saving results.");
        }
    }
}
