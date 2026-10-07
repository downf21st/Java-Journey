package CodePtit.OOPHieu;

import java.util.ArrayList;

public class Classroom {
    private String tenLop;
    private ArrayList<Student> danhSach = new ArrayList<>();

    public Classroom(String tenLop) {
        this.tenLop = tenLop;
    }

    public void addStudent(Student s) {
        for (Student x : danhSach) {
            if (x.getMssv().equals(s.getMssv())) {
                throw new IllegalArgumentException("MSSV da ton tai: " + s.getMssv());
            }
        }
        danhSach.add(s);
    }

    public String xepLoai(Student s) {
        double dtb = s.diemTrungBinh();
        if (dtb >= 8) return "Gioi";
        if (dtb >= 6.5) return "Kha";
        if (dtb >= 5) return "Trung Binh";
        return "Yeu";
    }

    public void inBangDiem() {
        System.out.println("Lop: " + tenLop);
        for (Student s : danhSach) {
            System.out.printf("%s - %s - DTB: %.2f - %s%n",
                    s.getMssv(), s.getName(), s.diemTrungBinh(), xepLoai(s));
        }
        System.out.println("Si so: " + danhSach.size());
    }
}