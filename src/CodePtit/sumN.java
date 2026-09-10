package CodePtit;

import java.util.Scanner;

public class sumN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        while (testCount-- > 0){
            long num = sc.nextLong();
            long ans = (( num + 1 ) * num ) /2 ;
            System.out.println(ans);

        }
    sc.close();

    }
}
