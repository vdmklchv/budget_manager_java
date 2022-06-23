package budget;

import budget.Enums.*;

public class Purchase {
    private final String name;
    private final double price;

    private final PURCHASE_CATEGORIES category;

    public Purchase(String name, double price, PURCHASE_CATEGORIES category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public PURCHASE_CATEGORIES getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return this.name + " $" + MoneyFormatter.format(this.price);
    }
}
