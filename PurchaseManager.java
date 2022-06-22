package budget;

import java.util.List;
import java.util.Map;

public class PurchaseManager {
    PurchaseDatabase purchaseDatabase = new PurchaseDatabase();

    // print purchases
    void printPurchases(Screen screen) {
        List<Purchase> purchases = purchaseDatabase.getPurchases();
        screen.printPurchases(purchases);
    }

    private double getTotal() {
        double total = 0;
        List<Purchase> purchases = purchaseDatabase.getPurchases();

        for (Purchase purchase: purchases) {
            total += purchase.getPrice();
        }

        return total;
    }

    void addPurchases(Screen screen) {
        PurchaseFactory purchaseFactory = new PurchaseFactory();
        Map<String, String> purchases = screen.getMapOfPurchases();
        for (Map.Entry<String, String> entry: purchases.entrySet()) {
            String purchaseName = entry.getKey();
            String priceAsString = entry.getValue();
            Purchase purchase = purchaseFactory.create(purchaseName, priceAsString);
            purchaseDatabase.add(purchase);
        }
    }

    void printTotal(Screen screen) {
        double total = getTotal();
        screen.printTotal(total);
    }

}
