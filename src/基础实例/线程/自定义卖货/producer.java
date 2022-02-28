package 基础实例.线程.自定义卖货;

public class producer implements Runnable{
    private Goods goods;
    public producer() {
    }

    public producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            synchronized (goods){
                if (goods.isProduct()){
                    goods.setName("大朗烧饼");
                    goods.setPrice(3.0F);
                    System.out.println(Thread.currentThread().getName() + "卖了一个价格为：" + goods.getPrice() + "块钱的" + goods.getName() + "，真香");
                    // 商品不需要生产
                    goods.setProduct(false);
                    // 唤醒消费者前来消费
                    goods.notifyAll();
                }else {
                    System.out.println(Thread.currentThread().getName() + "等待卖");
                    try {
                        // 生产者等待生产
                        goods.wait();
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
