import javafx.concurrent.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Log
public class Student {
    @Test
    public void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future submit = executorService.submit(new ThreadTest0302("皮皮龟", "赢"));
        try {
            ThreadTest0302 threadTest0302 = (ThreadTest0302) submit.get();
            System.out.println(threadTest0302);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info(String.valueOf(executorService.isShutdown()));
        log.info("还在main里面");
        executorService.shutdown();
    }

    @Test
    public void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    @Test
    public void test3() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2),
                Executors.defaultThreadFactory());

        for (int i = 0; i < 9; i++) {
            System.out.println(i);
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    @Test
    public void test4() {
        List list = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> hhhh = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "哈哈哈";
            }
        });
        try {
            String aaa = (String) hhhh.get();
            System.out.println(aaa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

@Data
@AllArgsConstructor
@Log
class ThreadTest0302 implements Callable {
    String name;
    String grade;

    @Override
    public Object call() throws Exception {
        log.info("到了这里面");
        return this;
    }
}

@Data
class MyTask extends Task {
    List list;

    @Override
    protected Object call() throws Exception {
        return new ArrayList<String>().add("Pipigui");
    }
}

@Data
@AllArgsConstructor
class Test5 implements Callable<Boolean> {

    String url;
    String name;

    @Override
    public Boolean call() throws Exception {
        System.out.println("原始的call");
        return true;
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5("hh", "hh") {
//            @Override
//            public Boolean call() throws Exception {
//                System.out.println("hhhh哈哈哈");
//                return false;
//            }
        };
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Future<Boolean> submit = exec.submit(test5);

        try {
            Boolean aBoolean = submit.get();
            System.out.println(aBoolean);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        exec.shutdownNow();
        System.out.println(exec.isTerminated());
    }
}


class Test6 {
    private static Integer num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (Test6.class) {
                        while (num < 1000)
                            System.out.println(Thread.currentThread().getName() + num++);
                    }
                }
            }).start();
        }
    }
}


class Test7 {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        test1();
        test9();
    }

    public static void test1() {
        Object object = new Object();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName());
                }
            });
            thread.start();
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test8() {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            lock.tryLock();
            lock.lock();
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            });
            thread.start();
        }
    }

    public static void test9() {
            new Thread(()->{
                out();
            }).start();

            new Thread(()->{
                out();
            }).start();

            new Thread(()->{
                out();
            }).start();

            new Thread(()->{
                out();
            }).start();
    }

    public static void out() {
        if (lock.tryLock()) {
            try {
//                lock.lock();
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "解锁了");
                lock.unlock();
            }
        }
        System.out.println(Thread.currentThread().getName()+"外面");
    }
}