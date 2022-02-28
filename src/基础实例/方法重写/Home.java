package 基础实例.方法重写;

/**
 * 概念：如果子类中方法的方法声明和父类完全一致，就会覆盖父类中的方法。这就是方法的重写。使用方法的重写可以在不修改父类代码的情况下实现对父类的扩展。
 * 在子类中对继承自父类的方法进行方法重写就能实现对父类的扩展。
 *
 * 1. @Override表示注解。
 * 2. 它的作用是用来检查重写的方法是否和父类的方法声明完全一致。如果不一致会报错。
 * 3. 只能声明在子类重写的方法上。
 *
 *方法重写的要求：
 *1. 要求子类方法声明的返回值类型，方法名，形参列表与父类完全一致。
 *2. 必须使用@Override注解来进行标识。
 *3. 重写方法的访问修饰符权限不能低于父类（大于等于）。
 * 访问修饰符权重： public > protected > 默认不写 > private
 * 重写用于继承中和接口【接口先不说，后面再说】
 *
 * ide快捷键：
 *方法重写：Alt + shift + S：倒数第八个
 *Override/Implement Methods
 */
public /*final*/ class Home {//final修饰后不能被继承！！！！！！！！！！！！
    public final String test;
    public Home() {
        this.test="final构造方法赋值";
        System.out.println("非同包无参构造继承");
    }
    int n;

    public Home( String test) {
        this.test = test;// 通过构造方法对final修饰的成员变量进行赋值
        System.out.println("super有参构造。");
    }

    public /*final*/ void master(){//被final修饰的方法不能被重写
        System.out.println("房子主人");
    }
    public void storey(){
        System.out.println("楼层");
    }
    public void population(){
        System.out.println("人口");
    }
}
