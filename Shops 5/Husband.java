import java.util.*;

public class Husband {
    private static int money = 0;  // Усі гроші
    private int price = 0;  // Загальна ціна
    private int price2;


    private Map<String, Double> productPrice = new HashMap<>();
    private Map<String, Integer> toBuyAgain = new HashMap<>();
    private Map<String, Integer> products = new HashMap<>();
    private LinkedList<String> canBuy = new LinkedList<>();
    private boolean isDrink = false;
    private int checkMoney;


    public void goDrink() {
        int money2 = getMoney();
        Shop bar = new Bar();
        System.out.println();
        System.out.println("Йдемо бухати !!!");
        System.out.println("Виберіть напій :");
        for (String product : bar.getAllProducts()) {
            System.out.println(product + " - " + bar.getPrice(product) + " грн");
        }
        Scanner scan = new Scanner(System.in);
        String productName = scan.nextLine();
        if (bar.getPrice(productName) < money2) {
            money2 -= bar.getPrice(productName);
            isDrink = true;
        } else {
            System.out.println("бідні не бухають");
        }
        System.out.println();
        setMoney(money2);
    }

    public Map toBuyAgain() {
        return toBuyAgain;
    }

    public LinkedList canBuy() {
        return canBuy;
    }

    public Map productPrice() {
        return productPrice;
    }

    public boolean getStatusDrink() {
        return isDrink;
    }

    ArrayList<String> noVal;  // список усіх продуктів яких нема в наявності


    protected void toBuy() {
        System.out.println("Треба купити :"); // Вивід списку для купівлі
        for (String productName : products.keySet()) {
            System.out.println(productName + " - " + products.get(productName) + " шт");
        }
    }

    public static int getMoney() {
        return money;
    }

    public int chekMoney() {
        return checkMoney;
    }

    public static void setMoney(int money2) {
        money = money2;
    }

    public Map setListProducts(Map<String, Integer> product) {
        products = product;
        return products;
    }

    private void allPrice() {
        System.out.println("У вас на рахунку залишилось : " + money + "грн");
        System.out.println("Загальна ціна покупки : " + price);

    }

    private Street openMap() {
        Street allShops = new Street();
        return allShops;
    }

    public void goShopping() {
        System.out.println("* Йдем до магазину *");
        System.out.println("Весь список товарів :");
        for (Shop i : openMap().allShops) { // для усіх магазинів. пройтись по магазинам і вивести усі продукти
            for (String productName : i.getAllProducts()) {
                System.out.println(productName + " - " + i.getPrice(productName) + " грн");
            }
        }
        System.out.println();
        int count = 0;
        for (String productName : products.keySet()) { // додаємо ціну за товар в кошику
            count = 0;
            for (Shop i : openMap().allShops) {
                if (i.containsProduct(productName)) {
                    price2 = 0;
                    price2 += i.buyProduct(products.get(productName), i.getPrice(productName));
                    productPrice.put(productName, i.buyProduct(products.get(productName), i.getPrice(productName)));
                    if (price2 > money) {
                        price += i.buyProduct(products.get(productName), i.getPrice(productName));
                        System.out.println("Не достатньо грошей для покупки : " + productName);
                        toBuyAgain.put(productName, products.get(productName));
                        break;
                    }
                    price += price2;
                    money -= price2;
                    checkMoney = money;
                    canBuy.add(productName);
                } else
                    count++;
            }
            if (count == openMap().allShops.size()) {
                System.out.println("Товара нема в наявності : " + productName);
                toBuyAgain.put(productName, products.get(productName));
            }
        }
        System.out.println();
        toBuy();
        System.out.println();
        allPrice();
        System.out.println();
    }
}
