package CodePtit.Saturday;

import java.util.*;

class ThongTinSinhVien {
    private String maSV;
    private String hoTen;
    private String soDienThoai;
    private int nhom;

    public ThongTinSinhVien(String maSV, String hoTen, String soDienThoai, int nhom) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.nhom = nhom;
    }

    public int getNhom() {
        return nhom;
    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + soDienThoai;
    }
}

public class SinhVien {
    // Hàm đọc dòng an toàn bỏ qua các dòng trống / ký tự thừa giữa các test
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

        // 1. Đọc số sinh viên N và số nhóm M
        String firstLine = nextValidLine(sc);
        if (firstLine.isEmpty())
            return;
        String[] nm = firstLine.split("\\s+");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // Khởi tạo danh sách sinh viên cho từng nhóm (chỉ số 1 -> M)
        List<List<ThongTinSinhVien>> dsNhom = new ArrayList<>(m + 1);
        dsNhom.add(new ArrayList<>());
        for (int i = 1; i <= m; i++) {
            dsNhom.add(new ArrayList<>());
        }

        // 2. Nhập thông tin N sinh viên (mỗi sinh viên 4 dòng)
        for (int i = 0; i < n; i++) {
            String maSV = nextValidLine(sc);
            String hoTen = nextValidLine(sc);
            String sdt = nextValidLine(sc);
            int nhom = Integer.parseInt(nextValidLine(sc));

            ThongTinSinhVien sv = new ThongTinSinhVien(maSV, hoTen, sdt, nhom);
            dsNhom.get(nhom).add(sv);
        }

        // 3. Nhập tên đề tài của M nhóm
        String[] tenBaiTap = new String[m + 1];
        for (int i = 1; i <= m; i++) {
            tenBaiTap[i] = nextValidLine(sc);
        }

        // 4. Nhập Q truy vấn và in kết quả
        int q = Integer.parseInt(nextValidLine(sc));
        for (int i = 0; i < q; i++) {
            int k = Integer.parseInt(nextValidLine(sc));

            System.out.println("DANH SACH NHOM " + k + ":");
            for (ThongTinSinhVien sv : dsNhom.get(k)) {
                System.out.println(sv);
            }
            System.out.println("Bai tap dang ky: " + tenBaiTap[k]);
        }

        sc.close();
    }
}
