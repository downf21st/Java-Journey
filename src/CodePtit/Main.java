package CodePtit;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("P01", "Ban phim", 350000);
        Product p2 = new Product("P02", "Chuot", 150000);
        Product p3 = new Product("P03", "Tai nghe", 500000);

        Cart cart1 = new Cart("C01");
        cart1.addItem(p1, 1);
        cart1.addItem(p2, 2);
        cart1.addItem(p1, 2);

        System.out.println("=== cart1 ban dau ===");
        cart1.showCart();

        Cart cart2 = cart1;
        cart2.addItem(p3, 1);
        cart2.setCode("C02");

        System.out.println("=== cart1 sau khi sua cart2 ===");
        cart1.showCart();

        System.out.println("cart1 == cart2: " + (cart1 == cart2));
    }
    
}
