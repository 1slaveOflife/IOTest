package Thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo4 {

    private static class Mywork{
        private volatile boolean flag=true;
        private Lock lock=new ReentrantLock();
        private Condition condition=lock.newCondition();

        public void sub() {
            try {
                lock.lock();
                while (!flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("子线程");
                flag = false;
                condition.signal();
            }finally {
                lock.unlock();
            }
        }

        public void man()
        {
            try
            {
                lock.lock();

            while(flag)
            {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程");

            flag=true;
            condition.signal();
            }finally {
                lock.unlock();
            }
        }


    }

    public static void main(String[] args) {
        Mywork mywork = new Mywork();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    mywork.sub();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    mywork.man();
                }
            }
        }).start();
    }

}
