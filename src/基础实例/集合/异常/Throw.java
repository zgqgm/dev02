package 基础实例.集合.异常;

public class Throw {
    public static void main(String[] args) {
        Throwable throwable1 = new Throwable();
        Throwable throwable2 = new Throwable("梦康今天很帅");
        System.out.println(throwable1);
        System.out.println(throwable2);
        System.out.println(throwable1.getMessage());
        System.out.println(throwable2.getMessage());
        throwable2.printStackTrace();
        test1();
    }
    private static void test1() {
        test2();
    }

    private static void test2() {
        new Throwable("今天起床，感觉自己很帅").printStackTrace();
    }
}
