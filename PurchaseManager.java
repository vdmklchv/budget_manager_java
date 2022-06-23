package budget;

import java.util.List;
import budget.Enums.*;

public class PurchaseManager {
    PurchaseDatabase purchaseDatabase = new PurchaseDatabase();
    BackupManager backupManager = new BackupManager();

    // print purchases
    void printPurchases(Screen screen, int menuChoice) {
        String title = "";
        switch (menuChoice) {
            case 1:
                title = "Food:";
                break;
            case 2:
                title = "Clothes:";
                break;
            case 3:
                title = "Entertainment:";
                break;
            case 4:
                title = "Other:";
                break;
            case 5:
                title = "All:";
                break;
            default:
                System.out.println("Unknown title");
                break;
        }
        PURCHASE_CATEGORIES category = getPurchaseCategory(menuChoice);
        List<Purchase> purchases = purchaseDatabase.getPurchaseListByCategory(category);
        System.out.println(title);
        if (purchases.size() > 0) {
            screen.printPurchases(purchases);
            printTotal(screen, menuChoice);
            System.out.println();
        } else {
            System.out.println("The purchase list is empty!");
            System.out.println();
        }

    }

    private double getTotal(PURCHASE_CATEGORIES category) {
        double total = 0;
        List<Purchase> purchases = purchaseDatabase.getPurchaseListByCategory(category);

        for (Purchase purchase: purchases) {
            total += purchase.getPrice();
        }

        return total;
    }

    Purchase addPurchase(Screen screen, int purchaseCategoryNumber) {
        PurchaseFactory purchaseFactory = new PurchaseFactory();
        String purchaseName = screen.getPurchaseName();
        double purchaseCost = screen.getPurchaseCost();
        PURCHASE_CATEGORIES purchaseCategory = getPurchaseCategory(purchaseCategoryNumber);
        if (purchaseCategory == null) {
            return null;
        }
        Purchase purchase = purchaseFactory.create(purchaseName, purchaseCost, purchaseCategory);
        purchaseDatabase.add(purchase);
        return purchase;
    }

    void printTotal(Screen screen, int purchaseCategoryNumber) {
        PURCHASE_CATEGORIES category = getPurchaseCategory(purchaseCategoryNumber);
        double total = getTotal(category);
        screen.printTotal(total);
        System.out.println();
    }

    PURCHASE_CATEGORIES getPurchaseCategory(int purchaseCategoryNumber) {
        switch (purchaseCategoryNumber) {
            case 1:
                return PURCHASE_CATEGORIES.FOOD;
            case 2:
                return PURCHASE_CATEGORIES.CLOTHES;
            case 3:
                return PURCHASE_CATEGORIES.ENTERTAINMENT;
            case 4:
                return PURCHASE_CATEGORIES.OTHER;
            case 5:
                return PURCHASE_CATEGORIES.ALL;
            default:
                return null;
        }

    }

    void savePurchases(Wallet wallet) {
        backupManager.backup(purchaseDatabase.getPurchases(), wallet);
    }

    void loadPurchases(Wallet wallet) {
        List<Purchase> restoredPurchases = backupManager.restore(wallet);
        purchaseDatabase.setPurchases(restoredPurchases);
    }

    public boolean isEmptyPurchaseList() {
        return purchaseDatabase.getPurchases().size() == 0;
    }
}
