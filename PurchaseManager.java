package budget;

import java.util.List;

public class PurchaseManager {
    PurchaseDatabase purchaseDatabase = new PurchaseDatabase();

    // print purchases
    void printPurchases(Screen screen) {
        List<Purchase> purchases = purchaseDatabase.getPurchases();
        if (purchases.size() > 0) {
            screen.printPurchases(purchases);
            System.out.println();
        } else {
            System.out.println("The purchase list is empty");
            System.out.println();
        }

    }

    private double getTotal() {
        double total = 0;
        List<Purchase> purchases = purchaseDatabase.getPurchases();

        for (Purchase purchase: purchases) {
            total += purchase.getPrice();
        }

        return total;
    }

    Purchase addPurchase(Screen screen) {
        PurchaseFactory purchaseFactory = new PurchaseFactory();
        String purchaseName = screen.getPurchaseName();
        double purchaseCost = screen.getPurchaseCost();
        Purchase purchase = purchaseFactory.create(purchaseName, purchaseCost);
        purchaseDatabase.add(purchase);
        return purchase;
    }

    void printTotal(Screen screen) {
        double total = getTotal();
        screen.printTotal(total);
        System.out.println();
    }

}
