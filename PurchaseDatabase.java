package budget;

import java.util.ArrayList;
import java.util.List;

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

}
