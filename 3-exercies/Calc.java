import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Клас для обчислень і логіки програми.
 */
public class Calc {
    private static final String FNAME = "rooms.bin";
    private List<Item2d> results;

    public Calc() {
        results = new ArrayList<>();
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
    }

    public void showResults() {
        if (results.isEmpty()) {
            System.out.println("No rooms saved.");
        } else {
            for (Item2d result : results) {
                System.out.println(result);
            }
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
