import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Calc {
    private static final String FNAME = "Item2d.bin";
    private List<Item2d> results;

    public Calc() {
        results = new ArrayList<>();
    }

    public List<Item2d> getResults() {
        return results;
    }

    private double calc(double x) {
        return Math.sin(x * Math.PI / 180);
    }

    public void init(double x, String functionType) {
        double y = calc(x);
        Item2d result = new Item2d(x, y, functionType);
        addResult(result);
    }

    public void addResult(Item2d result) {
        results.add(result);
    }

    public void showResults() {
        for (Item2d result : results) {
            System.out.println(result);
        }
    }

    public void save() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(results);
        }
    }

    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            results = (List<Item2d>) is.readObject();
        }
    }
}
