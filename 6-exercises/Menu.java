import java.util.HashMap;
import java.util.Map;

/**
 * Клас для зберігання та виконання команд меню.
 */
public class Menu {
    private Map<String, Command> commands = new HashMap<>();

    public void add(String key, Command command) {
        commands.put(key, command);
    }

    public void execute(String key) {
        if (commands.containsKey(key)) {
            commands.get(key).execute();
        } else {
            System.out.println("Invalid command.");
        }
    }
}
