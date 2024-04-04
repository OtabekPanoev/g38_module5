package uz.pdp.lambda;

import java.util.concurrent.Callable;

public class ConstraintsLambda {
    public static void main(String[] args) throws Exception {

        /*new String("");// anonim object
        Runnable runnable = () -> System.out.println("Pdp");
        MySupplier mySupplier = () -> "Pdp";
        Callable<String > callable = () -> "Pdp";

//        runnable.run();
        String supply = mySupplier.supply();
        System.out.println(supply);


        Runnable runnable2 = () -> System.out.println("Pdp");*/

        /*MySupplier<String> supplier = () -> "Pdp";
        MySupplier<String> supplier1 = () -> {
            System.out.println("consolling");
            return "Pdp";
        };

        MyConsumer<String> consumer = str -> System.out.println("Result: " + str);
        consumer.consume("Pdp");

        MyBiConsumer<String, Integer> biConsumer = (str, num) -> {
        };*/

        /*Runnable runnable          = () -> "Hello PDP !".length();
        Callable<Integer> callable = () -> "Hello PDP !".length();

        runnable.run();
        callable.call();*/

        /*final int a = 10;  // final
        int b = 20; // effectively final

        Runnable runnable = () -> {
            System.out.println(a + 10);
            System.out.println(b + 10);
//            b = 10;
            System.out.println(b);
        };

//        b = b + 1;

        System.out.println(a);
        runnable.run();*/

        MySupplier<String> supplier = () -> {
            return "Pdp";
        };

        String supply = supplier.supply();

    }

    public static void  m1() {
//        "Hello PDP !".length();
        System.out.println("fjghs");
    }


}

@FunctionalInterface
interface MySupplier<E> {
    E supply();

    static void  m1() {

    }

    default void m2() {

    }
}

@FunctionalInterface
interface MyConsumer<E> {
    void consume(E e);
}

@FunctionalInterface
interface MyBiConsumer<E, V> {
    void consume(E e, V v);
}
