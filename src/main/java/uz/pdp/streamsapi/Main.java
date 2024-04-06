package uz.pdp.streamsapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {

        String string = Files.readString(Path.of("students.json"));
        Type type = new TypeToken<List<Student>>() {
        }.getType();
        Gson gson = new Gson();

        List<Student> students = gson.fromJson(string, type);


        /*List<Student> male = students.stream()
                .filter(student -> student.getGender().equals("MALE"))
                .limit(20)
                .collect(Collectors.toList());
        System.out.println(male);*/


        /*List<Student> male = students.stream()
                .filter(student -> student.getGender().equals("MALE"))
                .skip(5)
                .limit(10)
                .peek(student -> System.out.println(student)) // lazy
                .toList();*/


       /* boolean b = students
                .stream()
//                .anyMatch((student -> student.getAge() == 150));
//                .allMatch((student -> student.getAge() >= 18));
                .noneMatch((student -> student.getAge() == 150));
        System.out.println(b);*/

        /*List<StudentDto> list = students.stream()
                .map(student -> new StudentDto(student.getId(), student.getFull_name()))
                .toList();

        students.stream()
                .mapToInt(student -> student.getAge())
                .forEach(System.out::print);*/


//        IntStream intStream = IntStream.of(2, 5, 10, 9, 8, 20);
//        Stream<Integer> integerStream = Stream.of(2, 5, 10, 9, 8, 20);



        /*Stream<Integer> stream = Stream.of(2, 5, 10, 0, 8, 20); // parallel
        Optional<Integer> any = stream
                .parallel()
                .filter((num) -> num > 5)
                .findAny();

        any.ifPresent((num) -> System.out.println(num));*/


        /*Stream<Integer> stream = Stream.of(2, 5, 10, 0, 8, 20);
        Integer[] array = stream
                .filter((num) -> num > 5)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(array));*/

        int[] ints = {1,5,2,5,7};
        IntStream stream = Arrays.stream(ints);


    }
}

record StudentDto(long id, String fullName) {

}
