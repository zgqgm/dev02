package 基础实例.线程.售票窗口;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//自定义售票窗口
public class SellTicket implements Runnable{
    private static int ticket=100;//定义100张票
    /**  3  */
    // 准备一把锁，锁可以是任意对象，但一定要是同一个对象
    private static final Lock LOCK=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            LOCK.lock();
            try {
                if (ticket>0){
                    //Thread.currentThread()返回被执行线程的信息
                    System.out.println(Thread.currentThread().getName()+"卖了一张票，当前还剩下" + ticket-- + "张票");
                    try{//卖一张休息0.1秒
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + "的电影票已经售罄");
                    //停止卖票
                    break;
                }
            }finally {
                LOCK.unlock();
            }
        }
    }

    /**  2  */
    // 自定义的卖票方法
    // 返回值代表是否还有余票
    /*private static synchronized boolean sell(){
        if (ticket>0){
            //Thread.currentThread()返回被执行线程的信息
            System.out.println(Thread.currentThread().getName()+"卖了一张票，当前还剩下" + ticket-- + "张票");
            try{//卖一张休息0.1秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }else{
            System.out.println(Thread.currentThread().getName() + "的电影票已经售罄");
            //停止卖票
            return false;
        }
    }

    @Override
    public void run() {
        // 同步代码块，把可能出现问题的代码给锁定
        while (true) {
            if (!sell()) {//如果卖完则执行
                break;
            }
        }
    }*/
    /**  1  */
    // 准备一把锁，锁可以是任意对象，但一定要是同一个对象
    //private static final Object lock= new Object();
    //卖票的逻辑代码
    /*@Override
    public void run() {
        // 同步代码块，把可能出现问题的代码给锁定
        while (true){
            synchronized (lock){
                if (ticket>0){
                    //Thread.currentThread()返回被执行线程的信息
                    System.out.println(Thread.currentThread().getName()+"卖了一张票，当前还剩下" + ticket-- + "张票");
                    try{//卖一张休息0.1秒
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + "的电影票已经售罄");
                    //停止卖票
                    break;
                }
            }
        }
    }*/
}
