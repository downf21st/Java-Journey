package CodePtit;

public class Employee {
    private String name;
    private int age;
    private int baseSalary;

    public Employee(String name, int age, int baseSalary) {
        this.name = name;
        this.age = age;
        this.baseSalary = baseSalary;
    }

    public String showInfo() {
        return "Name: " + name + ", Age: " + age + ", Base Salary: " + baseSalary;
    }

    public int calculateSalary() {
        return baseSalary;

    }

    
}
