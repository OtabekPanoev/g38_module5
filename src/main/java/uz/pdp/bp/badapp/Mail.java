package uz.pdp.bp.badapp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Mail {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );

        System.out.println(getEmployeesByCountry(empList, "UZB"));
        System.out.println(getEmployeesByCountry(empList, "US"));
        System.out.println(getEmployeesByAge(empList));

    }

    public static List<Employee> getEmployeesByCountry(List<Employee> employees, String country) {
        ArrayList<Employee> res = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getCountry().equals(country))
                res.add(employee);
        }
        return res;
    }

    public static List<Employee> getEmployeesByAge(List<Employee> employees) {
        ArrayList<Employee> res = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > 20)
                res.add(employee);
        }
        return res;
    }
}

@Data // req
@AllArgsConstructor
class Employee {
    private String name;
    private String country;
    private String position;
    private int age;
}
