package uz.pdp.cfi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CommonFunctionalInterfaces {

}


class ConsumerTest {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );


//        Consumer<Employee> printOnConsole = e -> System.out.println(e);
        Consumer<Employee> storeInDB =  e -> {
            System.out.println(e.toString() + " saving database");
            sendEmailToEmployee(e.getName());
        };
//        Consumer<Employee> priConsumerThenStoreInDB = printOnConsole.andThen(storeInDB);
        forEach(empList, storeInDB);
    }

    private static void sendEmailToEmployee(String name) {
        // email
        System.out.println("Email sent to : " + name);
    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        int nullCount = 0;
        for ( T t : list ) {
            if ( t != null ) {
                consumer.accept(t);
            } else {
                nullCount++;
            }
        }
        System.out.printf("%d null entries count  in the list.\n", nullCount);
    }
}


class TestPredicate {
    public static void main(String[] args) {

        List<Integer> ages = List.of(19, 20, 12, 3, 100, 50, 4);

//        Predicate<Integer> predicate = (age) -> age >= 18;

        countOfValidAges(ages, (age) -> age >= 18);
        countOfValidAges(ages, (age) -> age >= 3 && age < 6);
        countOfValidAges(ages, (age) -> age >= 7 && age < 17);

    }

    public static void countOfValidAges(List<Integer> ages, Predicate<Integer> predicate) {
        int valids = 0;
        for (Integer age : ages) {
            if (predicate.test(age))
                valids++;
        }
        System.out.println(valids);
    }
}

class SupplierTest {
    public static void main(String[] args) {
        /*Supplier<RuntimeException> supplier = () -> new RuntimeException("Exception occur");
        Exception throwable = supplier.get();*/

        String str = null;

        Optional<String> optional = Optional.ofNullable(str);

        optional.orElseThrow(() -> new RuntimeException());
    }
}

class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> charsCount = (str) -> str.length();
        Integer helloPdp = charsCount.apply("Hello PDP");
        System.out.println(helloPdp);
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
