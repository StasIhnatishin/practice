import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/** Клас для обчислення*/
public class Calc {
    private static final String FNAME = "Item2d.bin";
    private Item2d result;

    public Calc() {
        result = new Item2d();
    }

    public void setResult(Item2d result) {
        this.result = result;
    }

    public Item2d getResult() {
        return result;
    }

    private double calc(double x) {
        return Math.sin(x * Math.PI / 180);
    }

    public double init(double x) {
        result.setXY(x, calc(x));
        return result.getY();
    }

    public void show() {
        System.out.println(result);
    }

    public void save() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(result);
            os.flush();
        }
    }

    public void restore() throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            result = (Item2d) is.readObject();
        }
    }
}
