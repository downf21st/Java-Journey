package CodePtit.TH2;

import java.util.Scanner;

public class ThiSinh {
    private static String nextValidLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty())
                return s;
        }
        return "";

    }

    private static int toTenths(String s) {
        return (int) Math.round(Double.parseDouble(s) * 10);

    }

    private static String fmt(int t) {
        return t % 10 == 0 ? String.valueOf(t / 10) : (t / 10) + "." + (t % 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ma = nextValidLine(sc);
        String hoTen = nextValidLine(sc);
        int toan = toTenths(nextValidLine(sc));
        int ly = toTenths(nextValidLine(sc));
        int hoa = toTenths(nextValidLine(sc));

        int tong = toan * 2 + ly + hoa;

        String kv = ma.substring(0, 3);
        int uuTien = kv.equals("KV1") ? 5 : kv.equals("KV2") ? 10 : 25;
        String kq = (tong + uuTien >= 240) ? "TRUNG TUYEN" : "TRUOT";
        System.out.println(ma + " " + hoTen + " " + fmt(uuTien) + " " + fmt(tong) + " " + kq);
        sc.close();

    }

}
