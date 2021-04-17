import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadTest_0402 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec= Executors.newCachedThreadPool();

        final long start=System.currentTimeMillis();
        final Semaphore semaphore=new Semaphore(2);//创建Semaphore信号量，初始化许可大小为2

        for (int i=0;i<100000;i++){
            final int num=i;

            Runnable task=new Runnable() {
                int a=0;
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//请求获得许可，如果有可获得的许可则继续往下执行，许可数减1。否则进入阻塞状态
                        System.out.println(Thread.currentThread().getName()+"-----"+num);
                        for (int j=0;j<1000000;j++){
                            a++;
                        }
                        semaphore.release();//释放许可，许可数加1
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.submit(task);
        }
        exec.shutdown();
        while(true){
            if (exec.isTerminated()){
                System.out.println("--------------END---------------");
                System.out.println("所有的子线程都已关闭了");
                break;
            }
            Thread.sleep(1000);
        }

        final long end=System.currentTimeMillis();
        System.out.println("执行总耗时为（s）："+(end-start)/1000);
    }
}
