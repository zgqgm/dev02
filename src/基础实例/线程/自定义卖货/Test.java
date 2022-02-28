package 基础实例.线程.自定义卖货;

public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.setName("大郎烧饼");
        goods.setPrice(3.0F);
        Thread producer1 = new Thread(new producer(goods), "李佳琦");
        Thread customer1 = new Thread(new Customer(goods), "华强");
        Thread producer2 = new Thread(new producer(goods), "薇娅");
        Thread customer2 = new Thread(new Customer(goods), "花木兰");
        producer1.start();
        customer1.start();
        producer2.start();
        customer2.start();
    }
}
