import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

interface TestA{
    public void testA();
}

public class ThreadTest_0403_01 {


    @Test
    public void thread2(){
        int a=0;

        TestA tA=new TestA() {
            @Override
            public void testA() {
                System.out.println("aaa" + a);
            }
        };
    }

    @Test
    public void thread1(){
        int i=0;
        int b;
        String gxs="gxs";
        System.out.println(new Date());
        Thread t1=new Thread(new Runnable() {
            String c="哈哈哈哈";
            @Override
            public void run() {
                for (int i=0;i<100;i++){
//                    System.out.println(Thread.currentThread().getName());
                    System.out.println(gxs+Thread.currentThread().getName()+"执行"+i);
                }
            }
        });
        t1.start();
        System.out.println();
        System.out.println(new Date());

        System.out.println(new Date());
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
//                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName()+"执行"+i);
                }
            }
        });
        t2.start();
        System.out.println(new Date());
        System.out.println(++i);

        try {
//            t1.join();
//            t2.join();
            System.out.println("执行完了");
        }catch (Exception e){
            System.out.println("出错了");
        }
    }
    @Test
    public void test4(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i=0;i<10;i++){
            results.add(executorService.submit(new TaskWithResult(i)));
        }

        for (Future<String> future:results){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }

    }

    @Test
    public void test5(){
        int a=4;//  0100
        int b=10;// 1010

        System.out.println(a | b);
        System.out.println(a & b);
        System.out.println(a ^ b);
        System.out.println(a<<2);
        System.out.println(a>>2);
        System.out.println(a<<2);
    }

    @Test
    public void test6(){
        System.out.println(Integer.SIZE - 3);
        System.out.println(Integer.BYTES);
        System.out.println(Long.BYTES);
        System.out.println(Double.BYTES);
    }
}
