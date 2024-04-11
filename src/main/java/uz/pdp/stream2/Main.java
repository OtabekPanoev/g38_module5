package uz.pdp.stream2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.streamsapi.Student;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
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

        Comparator<Student> comparing = Comparator.comparing(student -> student.getAge());
        Comparator<Student> studentComparator = comparing.thenComparing(student -> student.getGender());
        students.stream()
                .sorted(
                        Comparator.comparing(Student::getAge, Comparator.reverseOrder())
                                .thenComparing(Student::getGender)
                ).forEach(student -> System.out.println(student));


    }
}
