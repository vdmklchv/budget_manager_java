package budget;

public class Entry {
    private final String name;
    private final double price;

    private final Enums.PURCHASE_CATEGORIES category;

    public Enums.PURCHASE_CATEGORIES getCategory() {
        return category;
    }

    public Entry(String name, double price) {
        this(name, price, null);
    }

    public Entry(String name, double price, Enums.PURCHASE_CATEGORIES category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return this.name + " $" + MoneyFormatter.format(this.price);
    }
}
