package 基础实例.线程.死锁;

public class Test {
    public static void main(String[] args) {
        Thread dk1= new Thread(new DeadLock(false));
        Thread dk2= new Thread(new DeadLock(true));
        dk1.start();
        dk2.start();
        /**
         * 在多线程场景下，记住，一定是多线程场景,互相把对方锁死
         * 死锁在运行时无法发现，因为没报错，只是在相互等待对方的锁释放，然后处理自己的事情，结果陷入了无限等待
         */
    }
}
