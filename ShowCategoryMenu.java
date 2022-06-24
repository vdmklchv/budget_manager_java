package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShowCategoryMenu extends Menu {

    Map<Integer, String> showCategoryMenu = new LinkedHashMap<>();

    @Override
    public String getName() {
        return "show_purchases";
    }

    public Map<Integer, String> getMenu() {
        return showCategoryMenu;
    }

    @Override
    public void initialize(boolean forSorting) {
        showCategoryMenu.put(1, "Food");
        showCategoryMenu.put(2, "Clothes");
        showCategoryMenu.put(3, "Entertainment");
        showCategoryMenu.put(4, "Other");
        if (!forSorting) {
            showCategoryMenu.put(5, "All");
            showCategoryMenu.put(6, "Back");
        }
    }
}
