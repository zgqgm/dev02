package 基础实例.包装类.Math;

public class Test {
    public static void main(String[] args) {
        System.out.println("绝对值：" + Math.abs(-1));
        System.out.println("向上取值：" + Math.ceil(12.34));
        System.out.println("向下取值：" + Math.floor(12.56));
        System.out.println("获取最大值：" + Math.max(16, 19));
        System.out.println("max：" + Math.max(Math.max(16, 15), Math.max(19, 20)));
        System.out.println("获取最小值：" + Math.min(Math.min(16, 15), Math.min(19, 20)));
        System.out.println("获取次幂：" + Math.pow(2, 10));//2^10

        // randBetwwen(1, 44)
        System.out.println("随机获取一个1~44的数:" + (int) (Math.random() * 44 + 1));
        System.out.println("四舍五入：" + Math.round(12.56));
        System.out.println("平方根：" + Math.sqrt(9));
    }
}
