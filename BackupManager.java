package budget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import budget.Enums.*;

class BackupManager {
    private final String BACKUP_FILE = "purchases.txt";
    File file = new File(BACKUP_FILE);
    void backup(List<Purchase> purchases, Wallet wallet) {
        double balance = wallet.getBalance();
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(balance + "\n");
            purchases.forEach(purchase -> {
                try {
                    String sb = purchase.getName() + ";" + purchase.getPrice() + ";" +
                            purchase.getCategory().name() + "\n";
                    fw.write(sb);
                } catch (IOException e) {
                    System.out.println("Couldn't write to file.");
                }
            });
            System.out.println("Purchases were saved!");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Couldn't create a file.");
            System.out.println();
        }


    }

    List<Purchase> restore(Wallet wallet) {
        PurchaseFactory purchaseFactory = new PurchaseFactory();
        List<Purchase> purchaseList = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            double balance = Double.parseDouble(sc.nextLine());
            wallet.setBalance(balance);
            while (sc.hasNextLine()) {
                String[] entryArray = sc.nextLine().split(";");
                String name = entryArray[0];
                double price = Double.parseDouble(entryArray[1]);
                Enums.PURCHASE_CATEGORIES purchaseType = PURCHASE_CATEGORIES.valueOf(entryArray[2]);
                purchaseList.add(purchaseFactory.create(name, price, purchaseType));
            }
            System.out.println("Purchases were loaded!");
            System.out.println();
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return purchaseList;
    }
}
