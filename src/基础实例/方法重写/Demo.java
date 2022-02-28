package 基础实例.方法重写;

public class Demo {
    public static void main(String[] args){
        XiaoMing ming=new XiaoMing();
        System.out.println("---------------------------------------------------------------");
        ming.master();
        ming.storey();
        ming.population();
        System.out.println("---------------------------------------------------------------");
        XiaoHong hong=new XiaoHong();
        hong.master();
        hong.storey();
        hong.population();
        /**
         * final 声明后的变量只能赋值一次.
         * final是个修饰符，可以用来修饰类和类的成员。
         *有点类似访问修饰符。
         *被final修饰的局部变量只能赋值一次。可以先声明后赋值。
         * final修饰的成员变量 -必须在声明时赋值- ，或者通过构造方法进行初始化赋值。
         *         ！！！！ 被final修饰的方法不能被重写！！！！！！！！！！！
         * 被final修饰的类不能被继承
         * final修饰的引用数据类型的变量地址不可变，不影响对象的使用。（例如String被final后不能被继承）
         * final的应用主要作用就是保证数据的安全性。
         */
        final int n;
        n=1;

    }
}
