package 基础实例.集合.异常;

public class TryCatch {
    public static void main(String[] args) {
        int num = 0;
        int[] array = null;
        try {//尝试代码
            num = 1 / 0;//遇到异常便停止执行代码
            array[0]=1;
        } catch (ArithmeticException e) {//可能出现的异常(算术异常)
            System.out.println("除数不能为0");
        } catch (NullPointerException e) {//（空指针异常）
            e.printStackTrace();
        }
        //上面两个catch可以合并为：
        /*
        * catch (ArithmeticException | NullPointerException e) {
			e.printStackTrace();
		}*/
        System.out.println("result:" + num);

        try {
            test();
        } catch (CloneNotSupportedException e) {//无法克隆父类异常
            e.printStackTrace();
        }
    }
    public static void test() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
