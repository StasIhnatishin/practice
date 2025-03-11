import java.util.List;

/**
 * Клас для відображення результатів у вигляді таблиці.
 */
class ViewTable implements ViewableTable {
    @Override
    public void displayResults(List<Item2d> results) {
        System.out.printf("|%-10s |%-10s |%-10s |%-12s |%-10s |%-10s%n", "Length", "Width", "Height", "Perimeter", "Area", "Volume");
        System.out.println("----------------------------------------------------------------");
        for (Item2d result : results) {
            System.out.printf("|%-10d |%-10d |%-10d |%-12d |%-10d |%-10d%n",
                result.getLength(), result.getWidth(), result.getHeight(),
                result.getPerimeter(), result.getArea(), result.getVolume());
        }
    }
}
