package CodePtit.OOPHieu;

public class Student {
    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;
    private String email;
    private String sdt;

    public Student(String name, double diemCC, double diemGK, double diemCK) {
        counter++;
        this.mssv = String.format("B21DCCCN%03d", counter);
        this.name = name;
        this.diemCC = diemCC;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }

    public static int counter = 0;

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double getDiemCC() {
        if(diemCC < 0 || diemCC > 10) {
            return -1;
        }
        return diemCC;
    }

    public double getDiemGK() {
        if(diemGK < 0 || diemGK > 10) {
            return -1;
        }
        return diemGK;
    }

    public double getDiemCK() {
        if(diemCK < 0 || diemCK > 10) {
            return -1;
        }
        return diemCK;
    }

    public double diemTrungBinh() {
        double cc = getDiemCC();
        double gk = getDiemGK();
        double ck = getDiemCK();

        if(cc == -1 || gk == -1 || ck == -1) {
            return -1;
        }

        return (cc * 0.1 + gk * 0.3 + ck * 0.6);
    }

    public Student capNhatEmail(String email) {
        this.email = email;
        return this;
    }

    public Student capNhatSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public static int getTotalStudents() {
        return counter;
    }
}
