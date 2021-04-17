public class T4 implements Runnable{
    int i;
    String name;

    public T4(int i,String name) {
        this.i = i;
        this.name=name;
    }

    @Override
    public synchronized void run() {
        while(i>0) {
            System.out.println(i--+name);
        }
    }
}
