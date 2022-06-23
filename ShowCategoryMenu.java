package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShowCategoryMenu extends Menu {

    Map<Integer, String> showCategoryMenu = new LinkedHashMap<>();
    private String name = "show_purchases";

    @Override
    public String getName() {
        return name;
    }

    public Map<Integer, String> getMenu() {
        return showCategoryMenu;
    }

    @Override
    public void initialize() {
        showCategoryMenu.put(1, "Food");
        showCategoryMenu.put(2, "Clothes");
        showCategoryMenu.put(3, "Entertainment");
        showCategoryMenu.put(4, "Other");
        showCategoryMenu.put(5, "All");
        showCategoryMenu.put(6, "Back");
    }
}
