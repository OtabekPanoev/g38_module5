public class A {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            Thread.sleep(100);
        }
    }
}
