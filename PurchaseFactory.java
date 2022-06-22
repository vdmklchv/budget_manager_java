package budget;

public class PurchaseFactory {
    Purchase create(String name, String priceAsString) {
        double price = Double.parseDouble(priceAsString.substring(1));
        String formattedPrice = MoneyFormatter.format(price);
        return new Purchase(name, Double.parseDouble(formattedPrice));
    }
}
