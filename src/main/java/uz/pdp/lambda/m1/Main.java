package uz.pdp.lambda.m1;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {

//        test1();

        test2();

    }

    private static void test2() throws Exception {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("A");
                return 10;
            }
        };

        Callable<Integer> callable1 = () -> {
            System.out.println("A");
            return 10;
        };

        System.out.println(callable.call());
    }

    private static void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Runnable runnable1 = new MyRunnable();

        Runnable runnable2 = () -> System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
