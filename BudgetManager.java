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
            runMenu(mainMenu, "Choose your action:", screen, 0);
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
                runMenu(purchaseCategoriesMenu, "Choose the type of purchase: ", screen, EXIT_PURCHASE_MENU);
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
                runMenu(showCategoryMenu, "Choose the type of purchases:", screen, EXIT_SHOW_MENU);
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

    void runMenu(Menu menu, String menuTitle, Screen screen, int EXIT_MENU) {
        while (true) {
            menu.showMenuTitle(menuTitle);
            menu.show(menu.getMenu());
            int choice = screen.getPurchaseCategoryNumber();
            System.out.println();
            if (choice == EXIT_MENU) {
                if (menu.getName().equals("main")) {
                    action(EXIT_MENU);
                }
                break;
            }
            if (!menu.exists(menu.getMenu(), choice)) {
                System.out.println("No such entry in menu.\n");
                System.out.println();
                return;
            }

            String name = menu.getName();
            switch (name) {
                case "main":
                    System.out.println();
                    action(choice);
                    break;
                case "purchase":
                    Purchase purchase = purchaseManager.addPurchase(screen, choice);
                    if (purchase == null) {
                        return;
                    }
                    wallet.addExpense(purchase.getPrice());
                    break;
                case "show_purchases":
                    purchaseManager.printPurchases(screen, choice);
                    break;
                default:
                    System.out.println("Unknown menu");
                    break;
            }


        }
    }
}
