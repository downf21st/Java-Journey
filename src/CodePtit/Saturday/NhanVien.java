package CodePtit.Saturday;

import java.util.Scanner;
import java.util.ArrayList;

public class NhanVien {
    private String maNV;
    private String hoTen;
    private String chucVu;
    private long phuCap;
    private long luongChinh;
    private long tamUng;
    private long conLai;

    public NhanVien(int maNV, String hoTen, String chucVu, long luongCoBan, long soNgayCong) {
        this.maNV = String.format("NV%02d", maNV);
        this.hoTen = hoTen;
        this.chucVu = chucVu;

        switch (chucVu) {
            case "GD":
                this.phuCap = 500;
                break;
            case "PGD":
                this.phuCap = 400;
                break;
            case "TP":
                this.phuCap = 300;
                break;
            case "KT":
                this.phuCap = 250;
                break;
            case "NV":
                this.phuCap = 150;
                break;
            default:
                this.phuCap = 100;
                break;
        }

        this.luongChinh = (luongCoBan * soNgayCong);

        double x = (this.phuCap + this.luongChinh) * 2.0 / 3.0;
        if (x < 25000) {
            this.tamUng = Math.round(x / 1000.0) * 1000;
        } else {
            this.tamUng = 25000;
        }

        this.conLai = this.luongChinh + this.phuCap - this.tamUng;

    }

    public String getChucVu() {
        return chucVu;
    }

    @Override
    public String toString() {
        return maNV + ' ' + hoTen + " " + phuCap + " " + luongChinh + " " + tamUng + " " + conLai;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<NhanVien> ds = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String hoTen = sc.nextLine();
            String chucVu = sc.nextLine();
            long luongCoBan = Long.parseLong(sc.nextLine());
            long soNgayCong = Long.parseLong(sc.nextLine());

            ds.add(new NhanVien(i, hoTen, chucVu, luongCoBan, soNgayCong));

        }
        String tuKhoa = sc.nextLine().trim();
        for (NhanVien nv : ds) {
            if (nv.getChucVu().equals(tuKhoa)) {
                System.out.println(nv);
            }
        }
        sc.close();
    }

}
