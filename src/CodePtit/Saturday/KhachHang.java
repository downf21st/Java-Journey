package CodePtit.Saturday;
import java.util.*;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;

    public KhachHang(String maKH, String tenKH, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public static void main(String[] args) {
        Main.main(args);
    }
}

 class MatHang {
    private String maMH;
    private String tenMH;
    private String donViTinh;
    private long giaMua;
    private long giaBan;

    public MatHang(String maMH, String tenMH, String donViTinh, long giaMua, long giaBan) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public long getGiaBan() {
        return giaBan;
    }
}
 class HoaDon {
    private String maHD;
    private KhachHang khachHang;
    private MatHang matHang;
    private long soLuong;
    private long thanhTien;

    public HoaDon(String maHD, KhachHang khachHang, MatHang matHang, long soLuong) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
        this.thanhTien = soLuong * matHang.getGiaBan();
    }

    @Override
    public String toString() {
        return maHD + " " + 
               khachHang.getTenKH() + " " + 
               khachHang.getDiaChi() + " " + 
               matHang.getTenMH() + " " + 
               matHang.getDonViTinh() + " " + 
               matHang.getGiaMua() + " " + 
               matHang.getGiaBan() + " " + 
               soLuong + " " + 
               thanhTien;
    }
}

class Main {
    // Hàm đọc dòng an toàn bỏ qua các dòng trống thừa trong bộ test
    private static String nextValidLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập danh sách khách hàng
        String firstLine = nextValidLine(sc);
        if (firstLine.isEmpty()) return;
        int n = Integer.parseInt(firstLine);

        Map<String, KhachHang> mapKH = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String tenKH = nextValidLine(sc);
            String gioiTinh = nextValidLine(sc);
            String ngaySinh = nextValidLine(sc);
            String diaChi = nextValidLine(sc);

            String maKH = String.format("KH%03d", i);
            mapKH.put(maKH, new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, diaChi));
        }

        // 2. Nhập danh sách mặt hàng
        int m = Integer.parseInt(nextValidLine(sc));
        Map<String, MatHang> mapMH = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            String tenMH = nextValidLine(sc);
            String donViTinh = nextValidLine(sc);
            long giaMua = Long.parseLong(nextValidLine(sc));
            long giaBan = Long.parseLong(nextValidLine(sc));

            String maMH = String.format("MH%03d", i);
            mapMH.put(maMH, new MatHang(maMH, tenMH, donViTinh, giaMua, giaBan));
        }

        // 3. Nhập danh sách hóa đơn
        int k = Integer.parseInt(nextValidLine(sc));
        List<HoaDon> dsHD = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            String line = nextValidLine(sc);
            String[] parts = line.split("\\s+");
            String maKH = parts[0];
            String maMH = parts[1];
            long soLuong = Long.parseLong(parts[2]);

            String maHD = String.format("HD%03d", i);
            dsHD.add(new HoaDon(maHD, mapKH.get(maKH), mapMH.get(maMH), soLuong));
        }

        // 4. In kết quả theo đúng thứ tự nhập
        for (HoaDon hd : dsHD) {
            System.out.println(hd);
        }

        sc.close();
    }
}