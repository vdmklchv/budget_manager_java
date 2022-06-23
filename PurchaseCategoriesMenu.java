package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class PurchaseCategoriesMenu extends Menu {
    private Map<Integer, String> purchaseCategoriesMenu = new LinkedHashMap<>();
    private String name = "purchase";

    @Override
    public String getName() {
        return name;
    }

    public Map<Integer, String> getMenu() {
        return purchaseCategoriesMenu;
    }

    public void initialize() {
        purchaseCategoriesMenu.put(1, "Food");
        purchaseCategoriesMenu.put(2, "Clothes");
        purchaseCategoriesMenu.put(3, "Entertainment");
        purchaseCategoriesMenu.put(4, "Other");
        purchaseCategoriesMenu.put(5, "Back");
    }

}
