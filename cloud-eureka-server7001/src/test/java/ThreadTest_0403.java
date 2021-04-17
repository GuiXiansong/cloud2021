@lombok.extern.java.Log
public class ThreadTest_0403 extends Thread{

    @Override
    public void run() {
        log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("A");
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getStackTrace());
    }

    public static void main(String[] args) {
        new ThreadTest_0403().start();
    }
}
