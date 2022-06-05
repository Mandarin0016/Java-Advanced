package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> companyData = new LinkedHashMap<>();
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            Employee currentEmployee;
            if (data.length == 6){
                //create complete employee profile
                currentEmployee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4], Integer.parseInt(data[5]));
            }else if (data.length == 4){
                //create employee profile without email and age
                currentEmployee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3]);
            }else {
                char lastElementFirstSymbol = data[4].charAt(0);
                if (Character.isDigit(lastElementFirstSymbol)){
                    //create employee profile with age only and email missing
                    currentEmployee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], Integer.parseInt(data[4]));
                }else {
                    //create employee profile with email only and age missing
                    currentEmployee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4]);
                }
            }
            Department department = new Department(currentEmployee.getDepartment(), currentEmployee.getSalary());
            if (!companyData.containsKey(department.getDepartmentName())){
                companyData.put(department.getDepartmentName(), new ArrayList<>());
                companyData.get(department.getDepartmentName()).add(currentEmployee);
                departments.add(department);
                Department.incrementDepartmentCount();
            }else {
                for (Department dep : departments) {
                    if (dep.getDepartmentName().equals(department.getDepartmentName())){
                        departments.get(departments.indexOf(dep)).addToDepartmentSalary(currentEmployee.getSalary());
                    }
                }
                companyData.get(department.getDepartmentName()).add(currentEmployee);
            }
        }
        departments.sort(Comparator.comparing(Department::getAverageDepartmentSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", departments.get(0).getDepartmentName());
        companyData.get(departments.get(0).getDepartmentName()).stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(Employee::printMe);
    }
}
