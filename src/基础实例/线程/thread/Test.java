package 基础实例.线程.thread;
//抢占线程发生在任意时刻
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Mythread mt=new Mythread();
       // mt.start();

        //主线程
        /*for (int i=0;i<10;i++){
            System.out.println("主线程"+i);
        }*/

        Thread the1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println("匿名内部类"+i);
                    /*try{//睡眠1秒
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    if (i == 5) {
                        Thread.yield();//线程礼让，即当i=5时，即使抢到执行资源也会让给其他线程
                    }
                }
                Thread.currentThread().interrupt();// 中断当前线程
                System.out.println("the1是否被中断：" + Thread.interrupted());//判断是否被中断
            }
        },"线程名1");
        //the1.start();

        /*new Thread(()-> {
            for (int i=0;i<10;i++){
                System.out.println("lambda"+i);
            }
        }).start();*/

        /*System.out.println(mt.getPriority());//默认优先级都是5
        System.out.println(the1.getPriority());
        mt.setPriority(1);//设置优先级
        the1.setPriority(10);*/

        //mt.start();
        //mt.join();//"加入"即只有mt线程执行才能执行其他的线程
        //the1.start();
        mt.setDaemon(true);//设置为守护线程
        System.out.println("是否是守护线程：" +mt.isDaemon());//判断是否为守护线程
        System.out.println("是否是守护线程：" +the1.isDaemon());

        mt.setName("线程名2");//设置线程名
        System.out.println(mt.getId()+"\n"+mt.getName());//获得线程id，和线程名
        the1.start();
        System.out.println("是否存在：" + the1.isAlive());//是否在运行
        System.out.println("是否中断：" + the1.isInterrupted());

        //主线程
        Thread currentThread = Thread.currentThread();
        System.out.println("currentThread:" + currentThread.getId());
        System.out.println("currentThread:" + currentThread.getName());
    }
}
