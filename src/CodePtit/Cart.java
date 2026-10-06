package CodePtit;

import java.util.ArrayList;

public class Cart {

    private String code;
    private ArrayList<CartItem> items;

    public Cart(String code) {
        this.code = code;
        this.items = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addItem(Product p, int qty) {
        if (p == null || qty <= 0) {
            return;
        }
        for (CartItem item : items) {
            if (item.getProduct().equals(p)) {
                item.addQuantity(qty);
                return;
            }
        }
        items.add(new CartItem(p, qty));
    }

    public double total() {
        double sum = 0;
        for (CartItem item : items) {
            sum += item.getAmount();
        }
        return sum;
    }

    public void showCart() {
        System.out.println("Gio hang: " + code);
        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() + " | don gia: " + item.getProduct().getPrice()
                    + " | so luong: " + item.getQuantity() + " | thanh tien: " + item.getAmount());
        }
        System.out.println("Tong cong: " + total());
    }

}
