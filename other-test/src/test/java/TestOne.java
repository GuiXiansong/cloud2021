import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestOne {
    private boolean flag;

    public void isFlag() {
        flag = true;
        if (String.valueOf(flag).equals(String.valueOf(false))) {
            System.out.println("在TestOne中");
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    private static int m = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void test1() {

        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);

        Object o = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
//                synchronized (o){
                for (int i1 = 0; i1 < 10000; i1++) {
                    m++;
                    atomicInteger.incrementAndGet();
                }
                countDownLatch.countDown();
//                    }
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m);
        System.out.println(atomicInteger.get());
    }

    @Test
    public void test22() {
        JSONObject jsonObject = new JSONObject();
        TransForm transForm = new TransForm(222L, "哈哈哈", "hh");

        String s = jsonObject.toJSONString(transForm);
        System.out.println(s);
    }

    private static MyTest INSTANCE;

    private MyTest getINSTANCE() {
        return INSTANCE;
    }

    public MyTest test23() {
        if (INSTANCE == null) {
            return new MyTest();
        }
        return INSTANCE;
    }

    @Test
    public void test24() {
        TestOne testOne = new TestOne();
        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(testOne.test23().hashCode());
            });
            Thread thread2 = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(testOne.test23().hashCode());
            });
            Thread thread3 = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(testOne.test23().hashCode());
            });
            thread1.start();
            thread2.start();
            thread3.start();
            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    AtomicInteger count = new AtomicInteger(0);

    void x() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    @Test
    public void test25() {
        TestOne testOne = new TestOne();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(testOne::x, "thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(testOne.count);
    }

}

class TestTwo {
    public static void main(String[] args) {
        TestOne testOne = new TestOne();


        if (testOne.getFlag()) {
            System.out.println("testTwo");
        }
    }
}

