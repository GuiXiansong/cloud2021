package com.thread.demo_1.thread_1;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/3 17:08 周三
 */
public class Test3 {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "花花").start();
        new Thread(myYield, "草草").start();


    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }

            System.out.println(Thread.currentThread().getName() + "线程礼让");
        }
    }
}