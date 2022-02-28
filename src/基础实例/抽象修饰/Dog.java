package 基础实例.抽象修饰;

public class Dog extends Animals{
    /**
     *static用来修饰公共共享的资源，和共享单车差不多，
     *static可以用来修饰成员变量、成员方法
     */
    public static String leg;//静态修饰的变量的值是最后一次的赋值，之前的赋值都会被覆盖。

    public Dog(String leg) {
        this.leg=leg;
    }

    @Override
    public void color() {

    }
}
