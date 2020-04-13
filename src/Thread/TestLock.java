package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static void main(String[] args) {
        Ticket t=new Ticket();
        new Thread(t,"窗口1售票").start();
        new Thread(t,"窗口2售票").start();
        new Thread(t,"窗口3售票").start();
        new Thread(t,"窗口4售票").start();
    }
}
class Ticket implements Runnable
{

    private volatile int  ticket=100;
    private Lock lock=new ReentrantLock();

    @Override
    public void run() {

        while (true)
        {
         lock.lock();
            try{
                if(ticket>0)
                {
                    Thread.sleep(20);
                    System.out.println(Thread.currentThread().getName()+",余票量"+ticket--);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
               lock.unlock();
            }


        }
    }
}
