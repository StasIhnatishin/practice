import java.io.*;
import java.util.*;

public class Calc {
    private static final String FNAME = "rooms.bin";
    private List<Item2d> results;
    private Stack<Runnable> history;

    private static Calc instance;

    Calc() {
        results = new ArrayList<>();
        history = new Stack<>();
    }

    public static Calc getInstance() {
        if (instance == null) {
            instance = new Calc();
        }
        return instance;
    }

    public List<Item2d> getResults() {
        return results;
    }

    private int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public void init(String lengthBin, String widthBin, String heightBin) {
        int length = binaryToDecimal(lengthBin);
        int width = binaryToDecimal(widthBin);
        int height = binaryToDecimal(heightBin);
        
        int perimeter = 2 * (length + width);
        int area = length * width;
        int volume = length * width * height;
        
        Item2d result = new Item2d(length, width, height, perimeter, area, volume);
        addResult(result);
    }

    public void addResult(Item2d result) {
        results.add(result);
        history.push(() -> results.remove(results.size() - 1));
    }

    public void undo() {
        if (!history.isEmpty()) {
            history.pop().run();
            System.out.println("Last operation undone.");
        } else {
            System.out.println("No operations to undo.");
        }
    }

    public void save() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(results);
            System.out.println("Rooms saved successfully.");
        }
    }

    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            results = (List<Item2d>) is.readObject();
            System.out.println("Rooms restored successfully.");
        }
    }
}