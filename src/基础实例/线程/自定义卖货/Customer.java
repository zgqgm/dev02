package 基础实例.线程.自定义卖货;

public class Customer implements Runnable{
    private Goods goods;

    public Customer() {
    }

    public Customer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            synchronized (goods){
                if (!goods.isProduct()){//是否需要生产
                    // 消费
                    System.out.println(Thread.currentThread().getName() + "买了一个" + goods.getName() + "，真香");
                    // 商品需要被生产
                    goods.setProduct(true);
                    //唤醒所有线程（生产者开始生产）
                    goods.notify();
                }else{
                    System.out.println(Thread.currentThread().getName() + "等着买");
                    try{
                        goods.wait();// 消费者等待消费(产品生产但未卖出则进入等待不在争抢资源，直到被唤醒)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
