package 基础实例.线程.死锁;

public class DeadLock implements Runnable{
    private boolean flag;

    public DeadLock() {
    }

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (MyLock.lock1){
                System.out.println(flag+"lock1");
                synchronized (MyLock.lock2){
                    System.out.println(flag+"lock2");
                }
            }
        }else {
            synchronized (MyLock.lock2){
                System.out.println(flag+"lock2");
                synchronized (MyLock.lock1){
                    System.out.println(flag+"lock1");
                }
            }
        }
    }
}
