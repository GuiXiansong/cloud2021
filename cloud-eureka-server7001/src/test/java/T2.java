public class T2 implements Runnable{
    String name="哈哈哈";
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(name);
        }
    }
}
