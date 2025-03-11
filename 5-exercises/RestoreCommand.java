import java.io.IOException;

public class RestoreCommand implements Command {
    @Override
    public void execute() {
        try {
            Calc.getInstance().restore();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error restoring results.");
        }
    }
}
