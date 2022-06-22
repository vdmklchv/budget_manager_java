package budget;

public class Purchase {
    private final String name;
    private final double price;

    public Purchase(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return this.name + " $" + MoneyFormatter.format(this.price);
    }
}
