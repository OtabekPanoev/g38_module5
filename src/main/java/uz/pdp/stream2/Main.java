package uz.pdp.stream2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.streamsapi.Student;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        /*Function<Integer, Integer> function = (num) -> Math.abs(num);
        Function<Integer, Integer> function2 = Math::abs;

        List<Integer> collect = Stream.of(-2, 5, -10, 0, 8, -20)
                .sorted(Comparator.comparing(function))
                .collect(Collectors.toList());

        System.out.println(collect);*/

        /*Stream<String> stringStream =
                Stream.of("water-melon", "milk", "berry", "pineapple", "grapes", "apple");

        List<String> list = stringStream
//                .sorted((str1, str2) -> str1.length() - str2.length())
                .sorted(Comparator.comparing(str -> str.length()))
                .toList();

        System.out.println(list);*/

        String jsonStr = Files.readString(Path.of("students.json"));

        Gson gson = new Gson();

        Type type = new TypeToken<List<Student>>(){}.getType();
        List<Student> students = gson.fromJson(jsonStr, type);

//        Function<Student, Integer> function = student -> student.getAge();
//        Function<Student, Integer> function2 = Student::getAge;

//        students.stream()
//                .sorted(
//                        Comparator.comparing(Student::getAge)
//                                .thenComparing(Student::getCountry)
//                                .thenComparing(Student::getFull_name)
//                )
//                .forEach(student -> System.out.println(student));


        /*List<Student> collect = students.stream().collect(Collectors.toList());
        Set<Student> set = students.stream().collect(Collectors.toSet());
        */


       /* Map<Integer, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));

        collect.forEach((k, v) -> {
            System.out.println("Key: " + k);
            for (Student student : v) {
                System.out.println("\t\t\t" + student);
            }
        });*/

//        String collect = students.stream()
//                .map(Student::toString)
//                .collect(Collectors.joining(",\n", "[", "]" ));

//        System.out.println(collect);


        /*Map<Boolean, List<Student>> collect = students.stream()
                .collect(Collectors.partitioningBy(student -> student.getAge() > 25));

        collect.forEach((k, v) -> {
            System.out.println("Key: " + k);
            for (Student student : v) {
                System.out.println("\t\t\t" + student);
            }
        });*/

        Stream<String> stream = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy");
        Optional<String> collect = stream.reduce((str1, str2) -> str1 + " , " + str2);

        collect.ifPresent(str -> System.out.println(str));

    }
}
