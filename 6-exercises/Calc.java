import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
* Клас для обчислень і логіки програми.
*/
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

public void computeStatistics() {
    if (results.isEmpty()) {
        System.out.println("No data available for statistics.");
        return;
    }

    ExecutorService executor = Executors.newFixedThreadPool(3);
    Future<Integer> minFuture = executor.submit(() -> {
        System.out.println("Calculating minimum area... (Progress: 33%)");
        int minArea = results.stream().mapToInt(Item2d::getArea).min().orElse(0);
        System.out.println("Minimum area calculated.");
        return minArea;
    });

    Future<Integer> maxFuture = executor.submit(() -> {
        System.out.println("Calculating maximum area... (Progress: 66%)");
        int maxArea = results.stream().mapToInt(Item2d::getArea).max().orElse(0);
        System.out.println("Maximum area calculated.");
        return maxArea;
    });

    Future<Double> avgFuture = executor.submit(() -> {
        System.out.println("Calculating average area... (Progress: 99%)");
        double avgArea = results.stream().mapToInt(Item2d::getArea).average().orElse(0.0);
        System.out.println("Average area calculated.");
        return avgArea;
    });

    try {
        int minArea = minFuture.get();
        int maxArea = maxFuture.get();
        double avgArea = avgFuture.get();

        System.out.println("All calculations completed. (Progress: 100%)");
        System.out.println("Statistics:");
        System.out.println("Min Area: " + minArea);
        System.out.println("Max Area: " + maxArea);
        System.out.println("Average Area: " + avgArea);
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    } finally {
        executor.shutdown();
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
    
    public void shutdown() {
        results.clear();
        history.clear();
        System.out.println("Calculator shut down.");
    }
}