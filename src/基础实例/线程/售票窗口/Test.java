package 基础实例.线程.售票窗口;

public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SellTicket(), "淘票票");
        Thread thread2 = new Thread(new SellTicket(), "美团");
        Thread thread3 = new Thread(new SellTicket(), "猫眼");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
