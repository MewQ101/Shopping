public class Bar extends Shop {
    @Override
    protected double buyProduct(int quantity, double originalPrice) {
        Discount(2, 10.0);
        double price3 = 0;
        if (quantity > minimumQuantity) {
            int quantity2 = quantity - minimumQuantity;
            double priceMon = originalPrice/100*discount;
            double discountAmount = ((quantity - quantity2) * originalPrice) + (quantity2 * (originalPrice - priceMon));
            price3 = discountAmount;
        } else {
            price3 = originalPrice * quantity;
        }
        return price3;
    }

    public Bar() {
        addProduct("Beer", 20);
        addProduct("Vodka", 10);
        addProduct("Wine", 50);
    }
}
