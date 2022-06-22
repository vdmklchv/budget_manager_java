package budget;
import budget.Enums.*;

public class BudgetManager {

    APP_STATE appState = APP_STATE.ON;

    PurchaseManager purchaseManager = new PurchaseManager();
    Menu menu = new Menu();
    Screen screen = new Screen();

    Wallet wallet = new Wallet();

    void start() {
        menu.initialize();
        while (isAppOn()) {
            menu.show();
            int menuEntryChoice = screen.getMenuEntry();

            if (!menu.exists(menuEntryChoice)) {
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
                Purchase purchase = purchaseManager.addPurchase(screen);
                wallet.addExpense(purchase.getPrice());
                break;
            case 3:
                purchaseManager.printPurchases(screen);
                purchaseManager.printTotal(screen);
                break;
            case 4:
                screen.showBalance(wallet.getBalance());
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
