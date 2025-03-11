import java.util.List;

/**
 * Клас, що представляє фабрику для створення об'єктів для відображення таблиці.
 */
interface ViewableTable {
    void displayResults(List<Item2d> results);
}
