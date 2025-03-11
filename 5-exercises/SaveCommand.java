import java.io.IOException;

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
