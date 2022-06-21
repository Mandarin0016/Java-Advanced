package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (this.employees.size() < this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        for (Employee currentEmployee : this.employees) {
            if (currentEmployee.getName().equals(name)){
                this.employees.remove(currentEmployee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee oldestOne = this.employees.get(0);
        for (Employee currentEmployee : this.employees) {
            if (currentEmployee.getAge() > oldestOne.getAge()){
                oldestOne = currentEmployee;
            }
        }
        return oldestOne;
    }
    public Employee getEmployee(String name){
        Employee employeeForReturn = null;
        for (Employee currentEmployee : this.employees) {
            if (currentEmployee.getName().equals(name)){
                employeeForReturn = currentEmployee;
                break;
            }
        }
        return employeeForReturn;
    }
    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Employees working at Cafe %s:", this.name));
        this.employees.forEach(employee -> result.append(System.lineSeparator()).append(employee));
        return result.toString();
    }
}
