public class T3 implements Runnable{
    String name="";
    String content;
    public T3(String name,String content) {
        this.name=name;
        this.content=content;
    }

    @Override
    public synchronized void run() {
        for (int i=0;i<5;i++){
            System.out.println(this.toString());
            System.out.println(name+i);
        }
    }
}