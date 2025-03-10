import java.io.Serializable;

/**
 * Клас для зберігання параметрів та результатів обчислень.
 */
class Item2d implements Serializable {
    private int length;
    private int width;
    private int height;
    private int perimeter;
    private int area;
    private int volume;

    private static final long serialVersionUID = 1L;

    public Item2d(int length, int width, int height, int perimeter, int area, int volume) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.perimeter = perimeter;
        this.area = area;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Length: " + length + ", Width: " + width + ", Height: " + height +
               ", Perimeter: " + perimeter + ", Area: " + area + ", Volume: " + volume;
    }
}