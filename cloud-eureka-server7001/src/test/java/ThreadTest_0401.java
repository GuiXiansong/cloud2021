import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ThreadTest_0401 extends Thread{

    private int count=10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"----"+count);
    }

    public static void main(String[] args) throws InterruptedException {
//        testT3();
//        testTwo();
//        testT4();
        testT5();
    }

    public static void testT5(){
        ThreadTest_0401 threadTest_0401 = new ThreadTest_0401();
        Thread thread01 = new Thread(threadTest_0401, "=================");
        Thread thread02 = new Thread(threadTest_0401, "KKKKKKKKKKKK");
        Thread thread03 = new Thread(threadTest_0401, "哈哈哈哈哈哈");
        Thread thread04 = new Thread(threadTest_0401, "AAAAAAAAAA");
        Thread thread05 = new Thread(threadTest_0401, "QQQQQQQQQQ");
        Thread thread06 = new Thread(threadTest_0401, "WWWWWWWWWW");
        Thread thread07 = new Thread(threadTest_0401, "RRRRRRRRRR");
        Thread thread08 = new Thread(threadTest_0401, "TTTTTTTTTTT");
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
        thread06.start();
        thread07.start();
        thread08.start();
    }

    public static void testT4(){
        int i=10;
        T4 t4 = new T4(i,"AAA");
        Thread thread1 = new Thread(t4, "1");
        Thread thread2 = new Thread(t4, "2");
        Thread thread3 = new Thread(t4, "3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void testT3(){
        Thread thread1 = new Thread(new T3("88888888888888888", "哈哈"));
        thread1.start();
        new Thread(new T3("哈哈哈哈哈哈哈哈哈哈哈","哈哈")).start();
        new Thread(new T3("HHHHHHHHHHHHHHHHHHH","哈哈")).start();
        new Thread(new T3("-----------------------","哈哈")).start();
        while (thread1.isAlive()){
            System.out.println(thread1.getState()+thread1.getName()+"----"+thread1.getPriority());
        }
    }

    public static void testT(){
        Thread thread1 = new Thread(new T1());
        Thread thread1_2 = new Thread(new T1());
        Thread thread2 = new Thread(new T2());
        thread1.start();
        thread1_2.start();
        thread2.start();
    }

    public static void testTwo() throws InterruptedException {
        Thread threadTest_01 = new Thread(new ThreadTest_0401());
        Thread threadTest_02 = new Thread(new ThreadTest_0401());
        Thread threadTest_03 = new Thread(new ThreadTest_0401());
        threadTest_01.setName("刘备");
        threadTest_02.setName("关羽");
        threadTest_03.setName("张飞");

    }

    public void testOne(){
        Thread liuBei = new Thread("刘备");
        Thread guanYu = new Thread("关羽");
        Thread zhangFei = new Thread("张飞");
        Thread caoCao = new Thread("曹操");
        Thread sunQuan = new Thread("孙权");

        liuBei.start();
        String name = liuBei.getName();
        System.out.println(name);
        guanYu.start();
        zhangFei.start();
        caoCao.start();
        sunQuan.start();
    }

    @Test
    public void test10(){
        int lengthOfYear = LocalDate.now().lengthOfYear();
        int lengthOfMonth = LocalDate.now().lengthOfMonth();
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        System.out.println(lengthOfYear+"-----"+lengthOfMonth+"---"+dayOfWeek);
    }
}
