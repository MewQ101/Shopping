public class Main {
    public static void main(String[] args) {
        Husband husband = new Husband();
        Woman wife = new Woman();

        husband.setListProducts(wife.getListProducts());
        wife.getToBuyAgain(husband.toBuyAgain());
        wife.getCanBuy(husband.canBuy());
        wife.getProductPrice(husband.productPrice());

        Husband.setMoney(2000);
        husband.goShopping();
        husband.goDrink();
        wife.chekMoney(husband.chekMoney());
        wife.getHusbandMoney(husband.getMoney());
        wife.getStatusDrink(husband.getStatusDrink());
        wife.goToFriend();
        wife.goShopAgain();
    }
}