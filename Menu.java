package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, String> menuEntries = new LinkedHashMap<>();

    void initialize() {
        menuEntries.put(1, "Add income");
        menuEntries.put(2, "Add purchase");
        menuEntries.put(3, "Show list of purchases");
        menuEntries.put(4, "Balance");
        menuEntries.put(0, "Exit");
    }

    void show() {
        for (Map.Entry<Integer, String> entry: menuEntries.entrySet()) {
            System.out.printf("%d) %s\n", entry.getKey(), entry.getValue());
        }
    }

    boolean exists(int number) {
        return menuEntries.containsKey(number);
    }
}
