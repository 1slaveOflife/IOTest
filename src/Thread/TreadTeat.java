package Thread;

public class TreadTeat extends Thread {

    @Override
    public void run() {
       for (int i=0;i<=10000;i++)
       {
           System.out.println("i:"+i+1);
       }
    }

    public static void main(String[] args) throws InterruptedException {
        TreadTeat thread = new TreadTeat();
        thread.start();
        Thread.sleep(200);
        Thread.interrupted();
    }
}
