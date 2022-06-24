package budget;

public class CategoryFactory {
    Category create(String name, double price) {
        String formattedPrice = MoneyFormatter.format(price);
        return new Category(name, Double.parseDouble(formattedPrice));
    }
}
