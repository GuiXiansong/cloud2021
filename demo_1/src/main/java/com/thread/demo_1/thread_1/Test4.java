package com.thread.demo_1.thread_1;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/3 17:29 周三
 */
public class Test4 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动线程
        Test4 test4 = new Test4();
        Thread thread = new Thread(test4);
        thread.start();

        //主线程
        for (int i = 0; i < 400; i++) {
            if (i==200){
                thread.join();//插队
            }
            System.out.println("main"+i);
        }
    }
}
