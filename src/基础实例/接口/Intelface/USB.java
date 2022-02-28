package 基础实例.接口.Intelface;

public interface USB /*接口命名规则：大驼峰法*/ {
    //静态常量
    final int N = 1;//完整格式:public static final 数据类型 常量名=值；（不用写完整，系统会默认）
    String AGREEMENT = "协议";//常量命名规则：全大写；

    //接口方法（接口的抽象方法）
    public abstract void method1();         //abstract在抽象修饰-Animals类里有说明。

    void method2();//public abstract 可以不写，系统会默认。
}