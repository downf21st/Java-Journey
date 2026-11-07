package CodePtit.TH2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class GiangVien {
    private String maGV;
    private String tenGV;
    private double tongGio;
    private List<String> dsLop = new ArrayList<>();

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGio = 0.0;
    }

    public String getMaGV() {
        return maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public double getTongGio() {
        return tongGio;
    }

    public void themGio(double gio) {
        this.tongGio += gio;
    }

    public void themLop(String tenMon, String gioStr) {
        dsLop.add(tenMon  + " " + gioStr);
        this.tongGio += Double.parseDouble(gioStr);
    }

    @Override
    public String toString() {
       
        StringBuilder sb = new StringBuilder("Giang vien: " + tenGV);
        for (String s : dsLop) sb.append("\n").append(s);
        sb.append("\n").append("Tong: ").append(String.format(Locale.US, "%.2f", tongGio));
        return sb.toString();
    }

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

        // 1. Đọc danh sách môn học
        Map<String, String> mapMonHoc = new HashMap<>();
        String firstLine = nextValidLine(sc);
        if (firstLine.isEmpty()) return;
        int soMon = Integer.parseInt(firstLine);

        for (int i = 0; i < soMon; i++) {
           String maMonHoc = nextValidLine(sc);
           String[] part = maMonHoc.split("\\s+",2);
           String tenMon = part[1];
           mapMonHoc.put(part[0], tenMon);
        }

        // 2. Đọc danh sách giảng viên
        int soGV = Integer.parseInt(nextValidLine(sc));
        List<GiangVien> dsGV = new ArrayList<>();
        Map<String, GiangVien> mapGV = new HashMap<>();

        for (int i = 0; i < soGV; i++) {
            String line = nextValidLine(sc);
            // Mã GV là từ đầu tiên, tên GV là phần còn lại sau khoảng trắng đầu tiên
            int firstSpace = line.indexOf(' ');
            String maGV = line.substring(0, firstSpace).trim();
            String tenGV = line.substring(firstSpace + 1).trim();

            GiangVien gv = new GiangVien(maGV, tenGV);
            dsGV.add(gv);
            mapGV.put(maGV, gv);
        }

        // 3. Đọc danh sách lớp học phần và tính tổng giờ
        int soLop = Integer.parseInt(nextValidLine(sc));
        for (int i = 0; i < soLop; i++) {
            String line = nextValidLine(sc);
            String[] parts = line.split("\\s+");
            String maGV = parts[0];
            // parts[1] là mã môn học
            GiangVien g = mapGV.get(maGV);
            
            if (mapGV.containsKey(maGV)) {
                g.themLop(mapMonHoc.get(parts[1]), parts[2]);
            }
        }
        String maGVCheck = nextValidLine(sc);

        // 4. In kết quả
        GiangVien kq = mapGV.get(maGVCheck);
        if (kq != null) {
            System.out.println(kq.toString());
        }
       
       

        sc.close();
    }
}

// Input : 
// 2
// INT10001 Triet Hoc
// INT10002 Toan roi rac
// 2
// GV01 Nguyen Van An
// GV02 Nguyen Duc Dong
// 3 
// GV01 INT10001 45.5
// GV02 INT10002 30.0
// GV01 INT10002 15.25

// Output :
// Nguyen Van An 60.75
// Nguyen Duc Dong 30.0