import java.util.*;
public abstract class Shop {
    private Map<String, Integer> products; // словарь продуктів ( Назва - ціна )
    protected int price = 0;
    private double price3 = 0;
    protected Shop() {
        products = new HashMap<>();
    }
    protected static int minimumQuantity;
    protected static double discount;
    protected void Discount(int minimumQuantity, double discount) {
        this.minimumQuantity = minimumQuantity;
        this.discount = discount;
    }
    protected double buyProduct(int quantity, double originalPrice) {
        return quantity * originalPrice;
    }
    protected void addProduct(String productName, int price) { // додати продукт в наявність магазину
        products.put(productName, price);
    }

    protected int getPrice(String productName) { // отримати ціну продукта
        if (products.containsKey(productName)) {
            return products.get(productName);
        }
        return 0;
    }
    protected boolean containsProduct(String productName) { // отримати назву продукта
        return products.containsKey(productName);
    }

    protected Set<String> getAllProducts() { // отримати всі назві продуктів
        return products.keySet();
    }
}
