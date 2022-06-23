package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu extends Menu {
    private final Map<Integer, String> menuEntries = new LinkedHashMap<>();

    public String getName() {
        return "main";
    }

    public Map<Integer, String> getMenu() {
        return menuEntries;
    }

    public void initialize() {
        menuEntries.put(1, "Add income");
        menuEntries.put(2, "Add purchase");
        menuEntries.put(3, "Show list of purchases");
        menuEntries.put(4, "Balance");
        menuEntries.put(5, "Save");
        menuEntries.put(6, "Load");
        menuEntries.put(0, "Exit");
    }

}
