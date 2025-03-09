import java.io.Serializable;

/**
 * Клас для зберігання параметрів та результатів обчислень.
 */
public class Item2d implements Serializable {
    private double x;
    private double y;
    private String functionType;

    private static final long serialVersionUID = 1L;

    public Item2d() {
        this.x = 0.0;
        this.y = 0.0;
        this.functionType = "sin";
    }

    public Item2d(double x, double y, String functionType) {
        this.x = x;
        this.y = y;
        this.functionType = functionType;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", Function = " + functionType;
    }

    public void setFunctionResult(double x, double y, String functionType) {
        this.x = x;
        this.y = y;
        this.functionType = functionType;
    }
}
