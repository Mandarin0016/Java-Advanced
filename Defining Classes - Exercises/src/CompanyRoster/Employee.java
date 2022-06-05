package CompanyRoster;

public class Employee {
    //Define a class Employee that holds the following information: name, salary, position, department, email, and age.
    // The name, salary, position, and department are mandatory while the rest are optional
    private final String name;
    private final double salary;
    private final String position;
    private final String department;

    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }
    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
        this.age = -1;
    }
    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.email = "n/a";
        this.age = age;
    }

    public void printMe(){
        String output = String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        System.out.println(output);
    }


    //getters and setters:
    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }
}
