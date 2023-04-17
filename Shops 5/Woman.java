import java.util.*;

public class Woman {
    private Map<String, Integer> products; // список продуктів

    private LinkedList<String> canBuy2 = new LinkedList<>();
    private Map<String, Integer> toBuyAgain2 = new HashMap<>();
    private Map<String, Double> productPrice2 = new HashMap<>();
    private boolean isDrink2;
    private int chekMoney2;
    private int husbandMoney;

    public Woman() {
        products = new HashMap<>(); // список товарів для покупки
        addProduct("Bread", 3);
        addProduct("Milk", 2);
        addProduct("Sony", 3);
        addProduct("Banana", 2);
    }

    public boolean getStatusDrink(boolean isDrink) {
        isDrink2 = isDrink;
        return isDrink2;
    }
    public int chekMoney(int money) {
        chekMoney2 = money;
        return chekMoney2;
    }
    public Map getListProducts() {
        return products;
    }
    public Map getToBuyAgain(Map<String, Integer> toBuyAgain) {
        toBuyAgain2 = toBuyAgain;
        return toBuyAgain2;
    }
    public LinkedList getCanBuy(LinkedList<String> canBuy) {
        canBuy2 = canBuy;
        return canBuy2;
    }
    public Map getProductPrice(Map<String, Double> productPrice){
        productPrice2 = productPrice;
        return productPrice2;
    }

    public int getHusbandMoney(int money) {
        husbandMoney = money;
        return husbandMoney;
    }

    protected Map GetCart() {
        return products;
    }

    protected int getCount(String productName) {
        return products.get(productName);
    }
    private void addProduct(String productName, Integer count) {
        products.put(productName, count); // додати продукт
    }

    protected Set<String> getAllProducts() { // отримати усі продукти
        return products.keySet();
    }

    protected void goToFriend() {
        System.out.println();
        System.out.println("* Йдем хвастатись подрузі *");
        if(canBuy2.size() >= products.size() - 1) {
            System.out.println("А ще ти знаєш що мій чоловік сьогодні накупив? Ні? Ну тоді дивись :");
        } else {
            System.out.println("Та мій чоловік лох, диви як мало продуктів купив :");
        }
        for(String i : canBuy2) {
            System.out.println(i + " - " + getCount(i) + " шт - " + productPrice2.get(i) + " грн");
        }
        System.out.println();
        if(isDrink2 == false || husbandMoney == chekMoney2) {
            System.out.println("І навіть не набухався!");
        } else {
            System.out.println("Но набухався падля аж на " + (husbandMoney - chekMoney2)*-1 + " грн");
        }
    }

    protected void goShopAgain(){
        System.out.println("* Йдем знову до магазину *");
        System.out.println("Йди купи усі інші продукти, я оновила список, ось він :");

        toBuyAgain2.put("Samsung", 2);
        toBuyAgain2.put("Apple", 4);
        toBuyAgain2.put("Butter", 3);

        for(String i : toBuyAgain2.keySet()){
            System.out.println(i + " - " + toBuyAgain2.get(i) + " шт");
        }
    }
}
