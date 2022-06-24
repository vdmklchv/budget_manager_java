package budget;

import java.util.ArrayList;
import java.util.List;

import budget.Enums.*;

public class PurchaseManager {
    PurchaseDatabase purchaseDatabase = new PurchaseDatabase();
    BackupManager backupManager = new BackupManager();

    // print purchases
    void printPurchases(Screen screen, int menuChoice) {
        String title = getTitle(menuChoice);
        PURCHASE_CATEGORIES category = getPurchaseCategory(menuChoice);
        List<Entry> purchases = purchaseDatabase.getPurchaseListByCategory(category);
        System.out.println(title);
        if (purchases.size() > 0) {
            screen.printEntries(purchases);
            double total = getTotal(category);
            screen.printTotal(total);
            System.out.println();
        } else {
            System.out.println("The purchase list is empty!");
            System.out.println();
        }

    }

    String getTitle(int menuChoice) {
        switch (menuChoice) {
            case 1:
                return "Food:";
            case 2:
                return "Clothes:";
            case 3:
                return "Entertainment:";
            case 4:
                return "Other:";
            case 5:
                return "All:";
            default:
                return "Unknown title";
        }
    }
    private double getTotal(PURCHASE_CATEGORIES category) {
        double total = 0;
        List<Entry> purchases = purchaseDatabase.getPurchaseListByCategory(category);

        for (Entry purchase: purchases) {
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

    void sort(Screen screen, int choice) {

        switch (choice) {
            case 1:
                // Get arraylist
                List<Entry> arrayListToSort = purchaseDatabase.getPurchases();
                if (arrayListToSort.size() == 0) {
                    System.out.println("list is empty");
                    return;
                }
                // Get sorted results
                Sorter sorter = new Sorter(new SortAllStrategy(arrayListToSort));
                List<Entry> sortedResults = sorter.getSortedList();
                // Print sorted results
                if (sortedResults != null) {
                    System.out.println("All:");
                    screen.printEntries(sortedResults);
                    double total = getTotal(PURCHASE_CATEGORIES.ALL);
                    screen.printTotal(total);
                    System.out.println();
                    System.out.println();
                }
                break;
            case 2:
                // Create list of categories
                ArrayList<Entry> expensesByTypeList = new ArrayList<>();
                CategoryFactory categoryFactory = new CategoryFactory();
                for (PURCHASE_CATEGORIES category: PURCHASE_CATEGORIES.values()) {
                    if ("ALL".equals(category.name())) {
                        continue;
                    }
                    double totalForCategory = getTotal(category);
                    Entry categoryObject = categoryFactory.create(category.name(), totalForCategory);
                    expensesByTypeList.add(categoryObject);
                }
                // Get sorted results
                Sorter byCategorySorter = new Sorter(new SortByTypeStrategy(expensesByTypeList));
                List<Entry> sortedList = byCategorySorter.getSortedList();
                // Print sorted results
                System.out.println("Types:");
                for (Entry entry: sortedList) {
                    System.out.printf("%s - $%s\n", entry.getName().charAt(0) + entry.getName().substring(1).toLowerCase(),
                            MoneyFormatter.format(entry.getPrice()));
                }
                double total = getTotal(PURCHASE_CATEGORIES.ALL);
                screen.printTotal(total);
                System.out.println();
                System.out.println();
                break;
            case 3:
                Menu showCategoryMenu = new ShowCategoryMenu();
                showCategoryMenu.initialize(true);
                System.out.println("Choose the type of purchase:");
                showCategoryMenu.show(showCategoryMenu.getMenu());
                int menuChoice = screen.obtainInteger();
                System.out.println();
                if (showCategoryMenu.exists(showCategoryMenu.getMenu(), menuChoice)) {
                    // Get sorted results
                    // Send list of purchases
                    PURCHASE_CATEGORIES category = getPurchaseCategory(menuChoice);
                    List<Entry> filteredResults = purchaseDatabase.getPurchaseListByCategory(category);
                    if (filteredResults.size() == 0) {
                        System.out.println("list is empty");
                        return;
                    }
                    Sorter sorterForCertainType = new Sorter(new SortByCertainTypeStrategy(filteredResults));
                    List<Entry> certainTypeSortedList = sorterForCertainType.getSortedList();
                    if (certainTypeSortedList != null) {
                        // Print sorted results
                        System.out.println(getTitle(menuChoice));
                        screen.printEntries(certainTypeSortedList);
                        total = getTotal(category);
                        screen.printTotal(total);
                    } else {
                        System.out.println("There are no purchases!");
                    }
                } else {
                    System.out.println("No such menu entry.");
                }
                System.out.println();
                System.out.println();
                break;
        }
    }

    public boolean isEmptyPurchaseList() {
        return purchaseDatabase.getPurchases().size() == 0;
    }
}
