package CodePtit;

import java.util.Scanner;

public class ptBacNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        if ((a == 0 && b != 0)) {
            System.out.println("VN");
        } else if (a == 0 && b == 0) {
            System.out.println("VSN");
        } else {
            double x = (double) -b/a;
            System.out.printf("%.2f",x);
        }
    sc.close();
    }
}
