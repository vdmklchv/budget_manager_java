package budget;

public class PurchaseFactory {
    Purchase create(String name, double price) {
        String formattedPrice = MoneyFormatter.format(price);
        return new Purchase(name, Double.parseDouble(formattedPrice));
    }
}
