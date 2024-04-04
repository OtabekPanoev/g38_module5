package uz.pdp.bp;

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

        System.out.println(getEmployeesBy(empList, new FilterByCountry("UZB")));
        System.out.println(getEmployeesBy(empList, new FilterByAge(20)));


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

interface Filter {
    boolean test(Employee employee);
}

@AllArgsConstructor
class FilterByCountry implements Filter{

    private String country;
    @Override
    public boolean test(Employee employee) {
        return employee.getCountry().equals(country);
    }
}

@AllArgsConstructor
class FilterByAge implements Filter{

    private int age;
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > age;
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
