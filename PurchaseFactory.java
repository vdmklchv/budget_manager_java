package budget;

import budget.Enums.*;

public class PurchaseFactory {
    Purchase create(String name, double price, PURCHASE_CATEGORIES category) {
        String formattedPrice = MoneyFormatter.format(price);
        return new Purchase(name, Double.parseDouble(formattedPrice), category);
    }
}
