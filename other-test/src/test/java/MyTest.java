import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {

    @Test
    public void test4() {
        Person person = new Person();
        try {
            Method eat1 = person.getClass().getMethod("eat1");
            eat1.invoke(person);
            System.out.println(eat1);

//            Method eat2 = person.getClass().getMethod("eat2");
//            eat2.setAccessible(true);
//            System.out.println(eat2);

            Method eat3 = person.getClass().getMethod("eat3", String.class);
            Object 粑粑 = eat3.invoke(person, "粑粑");
            System.out.println(eat3);

            Method[] peoples = Class.forName("Person").getMethods();
            for (int i = 0; i < peoples.length; i++) {
                peoples[i].setAccessible(true);
                System.out.println(peoples[i]);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(333);

        Class aClass = person.getClass();

        try {
            Constructor constructor = aClass.getConstructor(String.class, int.class);
            Person person1 = (Person) constructor.newInstance("李四", 333);
            System.out.println(person1);

            Constructor constructor1 = aClass.getConstructor();
            constructor1.setAccessible(true);
            Object o = constructor1.newInstance();
            System.out.println((Person) o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        int a = 0;
        int b = a = 3;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test1() {
        try {
            Class<?> person = Class.forName("Person");
            System.out.println(person.getName());
            System.out.println(person.getFields().length);
            System.out.println(person);

            Class<Person> person2 = Person.class;
            System.out.println(Person.class.getName());

            Class<? extends Person> person3 = new Person().getClass();
            System.out.println(new Person().getClass().getName());

            System.out.println(person == person2);
            System.out.println(person2 == person3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static long COUNT = 1_0000_0000L;

    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    @Test
    public void test5() {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + countDownLatch.getCount());
        });

        Thread thread2 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + countDownLatch.getCount());
        });

        final long start = System.nanoTime();
        thread1.start();
        thread2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.nanoTime() - start / 100_0000);
    }


    public static long COUNT2 = 1_0000_0000L;

    private static class M {
        public long p1, p2, p3, p4, p5, p6, p7;
        public volatile long x = 0L;
        public long p9, p10, p11, p12, p13, p14, p15;
    }

    public void test7() {

    }

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    @Test
    public void test8() {
        final MyTest myTest = new MyTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10; i1++) {
                        myTest.increase();
                        System.out.println(myTest.inc);
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {
            System.out.println("yield");
            Thread.yield();
        }
        System.out.println(myTest.inc);
    }

    private CountDownLatch countDownLatch = new CountDownLatch(3);

    Integer a = 0;
    String b = "";

    @Test
    public void test10() {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + System.nanoTime());
            b = Thread.currentThread().getName();
            System.out.println(b);

           /* for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a++;
                System.out.println(a);
                System.out.println(Thread.currentThread().getName() + "---" + System.nanoTime());
            }
*/
            countDownLatch.countDown();
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            b = Thread.currentThread().getName();
            System.out.println(b);
           /* System.out.println(Thread.currentThread().getName() + "---" + System.nanoTime());
            for (int i = 0; i < 1000; i++) {
                a++;
                System.out.println(a);
                System.out.println(Thread.currentThread().getName() + "---" + System.nanoTime());
            }*/
            countDownLatch.countDown();
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            b = Thread.currentThread().getName();
            System.out.println(b);
           /* System.out.println(Thread.currentThread().getName() + "---" + System.nanoTime());
            for (int i = 0; i < 1000; i++) {
                a++;
                System.out.println(a);
                System.out.println(Thread.currentThread().getName() + "---" + System.nanoTime());
            }*/
            countDownLatch.countDown();
        });
        thread3.start();

        System.out.println("222222222222222222222");
//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("111111111111");
        try {
            if (countDownLatch.getCount() > 0) {
                System.out.println(countDownLatch.getCount());
                countDownLatch.await();
            }
            System.out.println(countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test11() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                i++;
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                i++;
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        });
        thread1.start();

        try {
            thread1.join();
            System.out.println("aaaaa");
            thread.join();
            System.out.println("bbbb");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int result = 1;

    @Test
    public void test12() {
        Thread thread1 = new Thread(() -> {
            result = result * 99 * 22 * 12 * 232 / 234;
            System.out.println(99 * 22 * 12 * 232 / 234);
            System.out.println(Thread.currentThread().getName() + "---" + result);
//           result=result+1000;

        });
        Thread thread2 = new Thread(() -> {
            result = result * 44 * 67 * 12 / 23;
//           System.out.println(44*67*12/23);
            System.out.println(Thread.currentThread().getName() + "---" + result);
//           result=result+20;
        });
        thread2.start();
        thread1.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        System.out.println((99 * 22 * 12 * 232 / 234) * 44 * 67 * 12 / 23);
    }

    volatile boolean running = true;

    @Test
    public void test13() {
        MyTest myTest = new MyTest();
        new Thread(myTest::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myTest.running = false;

    }

    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end!");
    }

    @Test
    public void test14() {
        MyTest myTest = new MyTest();
        new Thread(myTest::n, "t2").start();
        System.out.println("-----" + myTest.running);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myTest.running = false;
        System.out.println("------" + myTest.running);
    }

    public void n() {
        System.out.println("n start");
        while (running) {

        }
        System.out.println("n stop");
    }

    private static MyTest INSTANCE;
    private static Lock lock = new ReentrantLock();

    public MyTest() {
    }

    public static MyTest getInstance() {
        lock.lock();
        if (INSTANCE == null) {
//            synchronized (MyTest.class) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new MyTest();
//            }
        }
        lock.unlock();
        return INSTANCE;
    }

    @Test
    public void test15() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(MyTest.getInstance().hashCode())).start();
        }
    }

    @Test
    public synchronized void test16() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m stop");
    }

    @Test
    public void test17() {
        new SecondTest().test16();
    }

    private static int c = 0;

    @Test
    public void test18() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            test19();
        });

        executorService.execute(() -> test19());
        try {
            executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//线程池就好比锦衣卫，朕直接问它就好了，当break出来时，说明是都干好了。洗洗睡了
        executorService.shutdownNow();
    }

    synchronized void test19() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            c++;
            System.out.println(c);
            while (c == 5) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    int j = c / 0;
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test20() {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->{
///*            while(true){
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                c++;
//                System.out.println(Thread.currentThread().getName()+"--------"+c);
//                if (c==5){
//                    try {
//                        int i = c / 0;
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            }*/
//            test21();
//        });
//
//        executorService.execute(()->{
///*            while (true){
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                c++;
//                System.out.println(Thread.currentThread().getName()+"--------"+c);
//                if (c==15){
//                    int j=c/0;
//                }
//            }*/
//            test21();
//        });
//
//        executorService.shutdownNow();

        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            MyTest.test21();
        });
        Thread t2 = new Thread(() -> {
            MyTest.test21();
        });
        t1.start();
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static synchronized void test21() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                c++;
                System.out.println(Thread.currentThread().getName() + "--------" + c);
                if (c == 5) {

                    int i = c / 0;
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class SecondTest extends MyTest {
    @Override
    public synchronized void test16() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("child m start");
        super.test16();
        System.out.println("child m stop");
    }
}

