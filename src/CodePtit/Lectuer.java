package CodePtit;

public class Lectuer extends Employee {
    private int soTiet;

    public Lectuer(String name, int age, int baseSalary, int soTiet) {
        super(name, age, baseSalary);
        this.soTiet = soTiet;
    }

    @Override
    public int calculateSalary() {
        return super.calculateSalary() + soTiet * 45;
    }
}
