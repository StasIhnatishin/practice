import java.util.List;

/**
 * Команда для перегляду списку кімнат.
 */
public class ViewCommand implements Command {
    private ViewableTable view = new ViewTable();
    
    @Override
    public void execute() {
        List<Item2d> results = Calc.getInstance().getResults();
        if (results.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            view.displayResults(results);
        }
    }
}