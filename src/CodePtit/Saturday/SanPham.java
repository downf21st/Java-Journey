package CodePtit.Saturday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LoaiSanPham {
    private String maLoai;
    private String ten;
    private long giaLoai1;
    private long giaLoai2;

    public LoaiSanPham(String maLoai, String ten, long giaLoai1, long giaLoai2) {
        this.maLoai = maLoai;
        this.ten = ten;
        this.giaLoai1 = giaLoai1;
        this.giaLoai2 = giaLoai2;
    }

    public String getTen() {
        return ten;
    }

    public long getGiaLoai1() {
        return giaLoai1;
    }

    public long getGiaLoai2() {
        return giaLoai2;
    }
}

class HoaDon {
    private String maDayDu;
    private String tenSP;
    private long giamGia;
    private long phaiTra;

    public HoaDon(int stt, String maBanDau, long soLuong, LoaiSanPham sp) {
        // Tạo mã hóa đơn bổ sung dấu gạch ngang và số thứ tự (ví dụ: AT1-001)
        this.maDayDu = String.format("%s-%03d", maBanDau, stt);
        this.tenSP = sp.getTen();

        // Xác định đơn giá theo ký tự thứ 3 ('1' hoặc '2')
        char loai = maBanDau.charAt(2); // AT1 --> "1"
        long donGia = (loai == '1') ? sp.getGiaLoai1() : sp.getGiaLoai2();

        long thanhTien = donGia * soLuong;

        // Tính tiền giảm giá theo bậc số lượng
        if (soLuong >= 150) {
            this.giamGia = thanhTien * 50 / 100;
        } else if (soLuong >= 100) {
            this.giamGia = thanhTien * 30 / 100;
        } else if (soLuong >= 50) {
            this.giamGia = thanhTien * 15 / 100;
        } else {
            this.giamGia = 0;
        }

        this.phaiTra = thanhTien - this.giamGia;
    }

    @Override
    public String toString() {
        return maDayDu + " " + tenSP + " " + giamGia + " " + phaiTra;
    }
}

public class SanPham {
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

        String firstLine = nextValidLine(sc);
        if (firstLine.isEmpty())
            return;
        int n = Integer.parseInt(firstLine);

        // Đọc danh sách các loại sản phẩm
        Map<String, LoaiSanPham> danhSachSP = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ma = nextValidLine(sc);
            String ten = nextValidLine(sc);
            long gia1 = Long.parseLong(nextValidLine(sc));
            long gia2 = Long.parseLong(nextValidLine(sc));

            danhSachSP.put(ma, new LoaiSanPham(ma, ten, gia1, gia2));
        }

        // Đọc số lượng hóa đơn
        int m = Integer.parseInt(nextValidLine(sc));
        ArrayList<HoaDon> danhSachHD = new ArrayList<HoaDon>();

        for (int i = 1; i <= m; i++) {
            String line = nextValidLine(sc);
            String[] parts = line.split("\\s+");
            String maBanDau = parts[0];
            long soLuong = Long.parseLong(parts[1]);

            // Lấy mã loại sản phẩm từ 2 ký tự đầu
            String maLoai = maBanDau.substring(0, 2);
            LoaiSanPham sp = danhSachSP.get(maLoai);

            danhSachHD.add(new HoaDon(i, maBanDau, soLuong, sp));
        }

        // Xuất kết quả theo đúng thứ tự nhập
        for (HoaDon hd : danhSachHD) {
            System.out.println(hd);
        }

        sc.close();
    }
}