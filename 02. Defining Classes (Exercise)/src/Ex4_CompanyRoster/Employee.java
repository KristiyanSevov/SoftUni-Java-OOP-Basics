package Ex4_CompanyRoster;

public class Employee {
    public static final int DEFAULT_AGE = -1;
    public static final String DEFAULT_EMAIL = "n/a";

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, DEFAULT_EMAIL, DEFAULT_AGE);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, DEFAULT_AGE);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, DEFAULT_EMAIL, age);
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %s", this.name, this.salary, this.email, this.age);
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

}
