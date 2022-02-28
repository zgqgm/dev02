package 基础实例.线程.thread;

public class Mythread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("线程"+i);
        }
    }
}
