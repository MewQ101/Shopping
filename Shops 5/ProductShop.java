class ProductShop extends Shop {
    @Override
    protected double buyProduct(int quantity, double originalPrice) {
        Discount(5, 20.0);
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
    public ProductShop() { // магазин продуктів
        addProduct("Apple", 300); // добавляємо продукти
        addProduct("Bread", 110);
        addProduct("Sausage", 80);
        addProduct("Butter", 70);
        addProduct("Milk", 300);
        addProduct("Potato", 40);
    }
}
