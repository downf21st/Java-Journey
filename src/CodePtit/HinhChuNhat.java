package CodePtit;

import java.util.Scanner;

public class HinhChuNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long chieuDai = sc.nextLong();
        long chieuRong = sc.nextLong();
        long chuVi = (chieuDai + chieuRong) * 2 ;
        long dienTich = chieuDai * chieuRong;

        if ( chieuDai <=0 || chieuRong <=0 ) {
            System.out.printf("0");
        } else {
            System.out.println(chuVi + " " + dienTich);
        }
    sc.close();

    }
}
