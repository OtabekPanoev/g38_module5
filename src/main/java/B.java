public class B {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " : B");
            Thread.sleep(100);
        }
    }
}
