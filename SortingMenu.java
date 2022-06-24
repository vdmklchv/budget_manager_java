package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class SortingMenu extends Menu {

    Map<Integer, String> menu = new LinkedHashMap<>();
    @Override
    void initialize(boolean forSorting) {
        menu.put(1, "Sort all purchases");
        menu.put(2, "Sort by type");
        menu.put(3, "Sort certain type");
        menu.put(4, "Back");
    }

    @Override
    Map<Integer, String> getMenu() {
        return menu;
    }

    @Override
    String getName() {
        return "sorting_menu";
    }
}
