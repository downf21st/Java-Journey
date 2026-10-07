package CodePtit.OOPHieu;

public class main {
    public static void main(String[] args) {
        Classroom lop = new Classroom("D21CQCN01");

        Student a = new Student("Nguyen Van A", 9, 8, 9);
        Student b = new Student("Tran Thi B", 7, 6, 7);
        Student c = new Student("Le Van C", 5, 5, 5);

        lop.addStudent(a);
        lop.addStudent(b);
        lop.addStudent(c);

        try {
            lop.addStudent(a);   
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        lop.inBangDiem();        
    }
}