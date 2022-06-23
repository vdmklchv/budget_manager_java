package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu extends Menu {
    private Map<Integer, String> menuEntries = new LinkedHashMap<>();

    public Map<Integer, String> getMenuEntries() {
        return menuEntries;
    }

    public void initialize() {
        menuEntries.put(1, "Add income");
        menuEntries.put(2, "Add purchase");
        menuEntries.put(3, "Show list of purchases");
        menuEntries.put(4, "Balance");
        menuEntries.put(0, "Exit");
    }

}
