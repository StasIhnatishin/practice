import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Команда для збереження поточних кімнат у файл.
 */
public class SaveCommand implements Command {
    @Override
    public void execute() {
        try {
            Calc.getInstance().save();
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
