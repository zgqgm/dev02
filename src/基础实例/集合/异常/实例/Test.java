package 基础实例.集合.异常.实例;

public class Test {
    public static void main(String[] args) throws ArithmeticException {
        try {
            test(10, 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("代码继续执行");
    }

    /**
     * 此方法用于求两个数的商
     * @param num1 第一个数
     * @param num2 第二个数
     * @throws ArithmeticException 如果第二个数为0，会发生算术异常
     * @throws NullPointerException 可能会发生空指针异常
     */
    public static void test(int num1, int num2) throws ArithmeticException, NullPointerException {
        if (num2 == 0) {
            throw new ArithmeticException("除数不能为0");
        }

        int result = num1 / num2;

        System.out.println(result);
    }
}
