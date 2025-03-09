/**
 * Клас для текстового відображення результатів обчислень.
 */
public class ViewResult implements View {

    @Override
    public void displayResult(Item2d result) {
        System.out.println("Result: " + result);
    }
}
