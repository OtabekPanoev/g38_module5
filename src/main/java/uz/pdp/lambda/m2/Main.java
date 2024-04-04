package uz.pdp.lambda.m2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );


        System.out.println(getEmployeesBy(empList, (emp) -> emp.getCountry().equals("UZB")));
        System.out.println(getEmployeesBy(empList, (emp) -> emp.getAge() > 20));
        System.out.println(getEmployeesBy(empList, (emp) -> emp.getAge() > 15));
        System.out.println(getEmployeesBy(empList, (emp) -> emp.getAge() < 20));
        System.out.println(getEmployeesBy(empList, null));


    }


    public static List<Employee> getEmployeesBy(List<Employee> employees, Filter filter) { // close for changing
        ArrayList<Employee> res = new ArrayList<>();
        for (Employee employee : employees) {
            if (filter.test(employee))
                res.add(employee);
        }
        return res;
    }
}

@FunctionalInterface
interface Filter {
    boolean test(Employee employee);
}

@Data // req
@AllArgsConstructor
class Employee {
    private String name;
    private String country;
    private String position;
    private int age;
}
