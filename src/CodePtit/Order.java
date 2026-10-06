package CodePtit;

public class Order {
    private static int countOrder = 0;


    public Order() {
        countOrder++;
        this.countOrder = countOrder;
    }

    public static int getCounter() {
        return countOrder;
    }

    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        System.out.println("Order ID of order1: " + order1.countOrder); // Output: 1
        System.out.println(Order.getCounter()); // Output: 3

        
    }
 }
