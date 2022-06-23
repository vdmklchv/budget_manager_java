package budget;
import budget.Enums.*;

public class BudgetManager {

    APP_STATE appState = APP_STATE.ON;

    PurchaseManager purchaseManager = new PurchaseManager();
    MainMenu mainMenu = new MainMenu();
    Screen screen = new Screen();

    Wallet wallet = new Wallet();


    void start() {
        mainMenu.initialize();
        while (isAppOn()) {
            mainMenu.showMenuTitle("Choose your action:");
            mainMenu.show(mainMenu.getMenuEntries());
            int menuEntryChoice = screen.getMenuEntry();

            if (!mainMenu.exists(mainMenu.getMenuEntries(), menuEntryChoice)) {
                System.out.println("No such entry in menu.\n");
                System.out.println();
                continue;
            }
            System.out.println();
            action(menuEntryChoice);
        }
    }

    void action(int number) {
        switch (number) {
            case 1:
                wallet.addIncome(screen.getIncome());
                break;
            case 2:
                final int EXIT_PURCHASE_MENU = 5;
                PurchaseCategoriesMenu purchaseCategoriesMenu = new PurchaseCategoriesMenu();
                purchaseCategoriesMenu.initialize();
                int purchaseCategoriesMenuChoice;
                while (true) {
                    purchaseCategoriesMenu.showMenuTitle("Choose the type of purchase:");
                    purchaseCategoriesMenu.show(purchaseCategoriesMenu.getPurchaseCategoriesMenu());
                    purchaseCategoriesMenuChoice = screen.getPurchaseCategoryNumber();
                    System.out.println();
                    if (purchaseCategoriesMenuChoice == EXIT_PURCHASE_MENU) {
                        break;
                    }
                    if (!purchaseCategoriesMenu.exists(purchaseCategoriesMenu.getPurchaseCategoriesMenu(), purchaseCategoriesMenuChoice)) {
                        System.out.println("No such entry in menu.\n");
                        System.out.println();
                        return;
                    }
                    Purchase purchase = purchaseManager.addPurchase(screen, purchaseCategoriesMenuChoice);
                    if (purchase == null) {
                        return;
                    }
                    wallet.addExpense(purchase.getPrice());
                }
                break;
            case 3:
                if (purchaseManager.isEmptyPurchaseList()) {
                    System.out.println("The purchase list is empty!");
                    System.out.println();
                    return;
                }
                final int EXIT_SHOW_MENU = 6;
                ShowCategoryMenu showCategoryMenu = new ShowCategoryMenu();
                showCategoryMenu.initialize();
                int showPurchaseCategoriesMenuChoice;
                while (true) {
                    showCategoryMenu.showMenuTitle("Choose the type of purchases:");
                    showCategoryMenu.show(showCategoryMenu.getShowCategoryMenu());
                    showPurchaseCategoriesMenuChoice = screen.getPurchaseCategoryNumber();
                    System.out.println();
                    if (showPurchaseCategoriesMenuChoice == EXIT_SHOW_MENU) {
                        break;
                    }
                    if (!showCategoryMenu.exists(showCategoryMenu.getShowCategoryMenu(), showPurchaseCategoriesMenuChoice)) {
                        System.out.println("No such entry in menu.\n");
                        System.out.println();
                        return;
                    }
                    purchaseManager.printPurchases(screen, showPurchaseCategoriesMenuChoice);
                }
                break;
            case 4:
                screen.showBalance(wallet.getBalance());
                break;
            case 5:
                purchaseManager.savePurchases(wallet);
                break;
            case 6:
                purchaseManager.loadPurchases(wallet);
                break;
            case 0:
                changeAppState();
                System.out.println();
                System.out.println("Bye!");
                break;
        }
    }

    boolean isAppOn() {
        return appState == APP_STATE.ON;
    }

    void changeAppState() {
        appState = appState == APP_STATE.ON ? APP_STATE.OFF : APP_STATE.ON;
    }
}
