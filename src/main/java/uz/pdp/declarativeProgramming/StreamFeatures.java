package uz.pdp.declarativeProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFeatures {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(); // store data
        for (int i = 0; i < 10_00000; i++) {
            integers.add(new Random().nextInt(50, 100));
        }

//        Stream<Integer> stream = integers.stream(); // no storage, pipeline

        Stream<Integer> stream = integers.stream();

        List<Integer> list = stream
                .filter(integer -> integer > 95)
                .limit(100)
                .toList();
        System.out.println(list);

        Predicate<Integer> predicate = (num) -> num > 80;
        Predicate<Integer> predicate1 = (num) -> num < 90;
        Predicate<Integer> and = predicate.and(predicate1);

        Stream<Integer> stream1 = integers.stream();
        List<Integer> list1 = stream1
//                .filter(num -> num > 80 && num < 90)
//                .filter(predicate)
//                .filter(predicate1)
//                .filter(and)
                .filter(predicate.and((num) -> num < 90))
                .toList();
        System.out.println(list1);

    }
}
