package budget;

public class BudgetManager {

    PurchaseManager purchaseManager = new PurchaseManager();
    Screen screen = new Screen();
    void start() {
        purchaseManager.addPurchases(screen);
        purchaseManager.printPurchases(screen);
        System.out.println();
        purchaseManager.printTotal(screen);
    }
}
