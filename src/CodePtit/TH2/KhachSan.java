package CodePtit.TH2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhachSan {
    String ma, ten, phong;
    long soNgay, tong;

    public KhachSan(String ma, String ten, String phong, long soNgay, long tong) {
        this.ma = ma;
        this.ten = ten;
        this.soNgay = soNgay;
        this.tong = tong;
        this.phong = phong;
    }

    private static String nextValidLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty())
                return s;
        }
        return "";

    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + phong + " " + soNgay + " " + tong;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int[] gia = { 25, 34, 50, 80 };

        int n = Integer.parseInt(nextValidLine(sc));
        List<KhachSan> ds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            String ten = nextValidLine(sc).replaceAll("\\s+", " ");
            String phong = nextValidLine(sc);
            LocalDate nhan = LocalDate.parse(nextValidLine(sc), f);
            LocalDate tra = LocalDate.parse(nextValidLine(sc), f);
            long dv = Long.parseLong(nextValidLine(sc));

            long soNgay = ChronoUnit.DAYS.between(nhan, tra) + 1;
            int tang = phong.charAt(0) - '0';
            long tong = gia[tang - 1] * soNgay + dv;

            ds.add(new KhachSan(String.format("KH%02d", i), ten, phong, soNgay, tong));

        }
        ds.sort((a,b) -> Long.compare(b.tong,a.tong));
        for (KhachSan ks:ds){
            System.out.println(ks);
        }
        sc.close();
    }
}
