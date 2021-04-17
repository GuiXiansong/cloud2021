public class T1 implements Runnable{
    String name="+++++++++++++++";
    @Override
    public void run() {

        for (int i=0;i<100;i++){
            System.out.println(name);
        }
    }
}
