package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee oldestOne = this.employees.get(0);
        for (Employee currentEmployee : this.employees) {
            if (currentEmployee.getAge() > oldestOne.getAge()) {
                oldestOne = currentEmployee;
            }
        }
        return oldestOne;
    }

    public Employee getEmployee(String name) {
        for (Employee currentEmployee : this.employees) {
            if (currentEmployee.getName().equals(name)) {
                return currentEmployee;
            }
        }
        return null;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Employees working at Bakery %s:", this.name));
        this.employees.forEach(employee -> result.append(System.lineSeparator()).append(employee));
        return result.toString();
    }
}
