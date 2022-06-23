package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import budget.Enums.*;

public class PurchaseDatabase {
    private List<Purchase> purchases = new ArrayList<>();

    public List<Purchase> getPurchases() {
        return purchases;
    }

    void add(Purchase purchase) {
        purchases.add(purchase);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    List<Purchase> getPurchaseListByCategory(PURCHASE_CATEGORIES category) {
        if (category == PURCHASE_CATEGORIES.ALL) {
            return this.getPurchases();
        }
        return this.purchases.stream().filter(purchase -> purchase.getCategory() == category).collect(Collectors.toList());
    }

}
