import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє фабрику для створення об'єктів для відображення таблиці.
 */
public class ViewableTable {

    private List<Item2d> results = new ArrayList<>();

    public void addResult(Item2d result) {
        results.add(result);
    }

    public List<Item2d> getResults() {
        return results;
    }

    public void displayResults() {
        ViewTable viewTable = new ViewTable();
        viewTable.displayTableWithHeader(results);
    }
}
