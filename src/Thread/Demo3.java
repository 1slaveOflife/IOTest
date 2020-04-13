package Thread;

public class Demo3 {
    public volatile boolean flag=true;

    public synchronized void sub()
    {
        while (!flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i=0;i<2;i++)
        {
            System.out.println("子线程"+(i+1));
        }

        flag=false;
        this.notify();

    }

    public synchronized void man()
    {
        while (flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i=0;i<2;i++)
        {
            System.out.println("主线程-----------"+(i+1));
        }
        flag=true;
        this.notify();
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
new Thread(new Runnable(

) {
    @Override
    public void run() {

        for (int i=0;i<10;i++)
        {
            demo3.sub();
        }
    }
}).start();

for (int i=0;i<10;i++)
{
    demo3.man();
}
    }
}
