package com.thread.demo_1.thread_1;

import javax.sound.midi.Receiver;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/3 15:25 周三
 */
public class Race implements Runnable{

    private static String winner=null;
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
//            如果是兔子，让它跑十步的时候睡一觉
            if (Thread.currentThread().getName().equals("兔子") && i==10){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            判断比赛是否结束
            boolean flag=gameOver(i);
//            如果比赛结束了，就停止程序
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"---->跑了"+i+"步");
        }
    }

//    判断是否完成比赛
    private boolean gameOver(int steps){
        if (winner!=null){
//            已经存在胜利者了
            return true;
        }{
            if (steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is "+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
