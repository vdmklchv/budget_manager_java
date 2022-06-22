package budget;

import java.util.*;

public class Screen {
    void printPurchases(List<Purchase> purchases) {
        for (Purchase purchase: purchases) {
            System.out.println(purchase.toString());
        }
    }

    Map<String, String> getMapOfPurchases() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> purchaseMap = new LinkedHashMap<>();

        while (sc.hasNextLine()) {
            String entry = sc.nextLine();
            String[] entryAsArray = entry.split(" ");
            String priceAsString = entryAsArray[entryAsArray.length - 1];
            String productName = String.join(" ", Arrays.copyOfRange(entryAsArray, 0, entryAsArray.length - 1));
            if (!"".equals(priceAsString) && !"".equals(productName)) {
                purchaseMap.put(productName, priceAsString);
            }
        }

        return purchaseMap;
    }

    void printTotal(double total) {
        System.out.printf("Total: $%s", MoneyFormatter.format(total));
    }
}
