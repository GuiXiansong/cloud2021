package com.guixiansong.one.testone;

public class ThreadTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "------" + i);
            if (i == 4) {
                System.out.println(Thread.currentThread().getName() + "线程礼让=======================================");
                Thread.yield();
            }
            System.out.println("当前在运行的线城是：" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread thread = new Thread(threadTest, "one");
        Thread thread1 = new Thread(threadTest, "two");
        thread.start();
        thread1.start();
    }
}
