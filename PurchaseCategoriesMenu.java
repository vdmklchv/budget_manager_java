package budget;

import java.util.LinkedHashMap;
import java.util.Map;

public class PurchaseCategoriesMenu extends Menu {
    Map<Integer, String> purchaseCategoriesMenu = new LinkedHashMap<>();

    public Map<Integer, String> getPurchaseCategoriesMenu() {
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
