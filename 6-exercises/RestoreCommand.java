import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Команда для відновлення збережених кімнат.
 */
public class RestoreCommand implements Command {
    @Override
    public void execute() {
        try {
            Calc.getInstance().restore();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RestoreCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
