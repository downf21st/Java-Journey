package CodePtit.TH2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiangVienCNTT {
    private String ma, hoTen, boMon;

    public GiangVienCNTT(String ma, String hoTen, String boMon) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.boMon = boMon;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        String[] w = hoTen.split("\\s+");
        return w[w.length - 1];
    }

    private String vietTat() {
        StringBuilder sb = new StringBuilder();
        for (String w : boMon.split("\\s+")) {
            sb.append(Character.toUpperCase(w.charAt(0)));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + vietTat();
    }

    private static String nextValidLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty())
                return s;
        }
        return "";

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<GiangVienCNTT> ds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String hoTen = nextValidLine(sc);
            String boMon = nextValidLine(sc);
            ds.add(new GiangVienCNTT(String.format("GV%02d", i), hoTen, boMon));

        }
        ds.sort((a, b) -> {
            int c = a.getTen().compareToIgnoreCase(b.getTen());
            return c != 0 ? c : a.getMa().compareTo(b.getTen());
        });
        for (GiangVienCNTT gv : ds) {
            System.out.println(gv);
        }
        sc.close();
    }

}
