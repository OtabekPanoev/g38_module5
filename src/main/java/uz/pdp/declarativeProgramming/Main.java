package uz.pdp.declarativeProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            integers.add(new Random().nextInt(50, 100));
        }

//        imperativeWay(integers);

        /*Stream<Integer> stream = integers.stream(); //

        System.out.println("On the way");

        Stream<Integer> integerStream = stream.filter((num) -> num > 90); //

        Stream<Integer> limit = integerStream.limit(10); //

        List<Integer> list = limit.toList(); // start streaming

        System.out.println(list);*/

        integers.stream()
                .filter((num) -> num > 90)
                .limit(10)
                .forEach(System.out::print);


    }

    private static void imperativeWay(ArrayList<Integer> integers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>(); // imperative way
        for (Integer integer : integers) {
            if (integer % 2 == 0)
                evenNumbers.add(integer);
        }
        System.out.println("evenNumbers = " + evenNumbers);
    }
}
