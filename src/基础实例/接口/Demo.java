package 基础实例.接口;

import 基础实例.接口.Intelface.USB;//不在同包中要用import导入。
import 基础实例.接口.继承.Demo2;
//接口的实现类

/**
 * extends 是继承某个类, 继承之后可以使用父类的方法, 也可以重写父类的方法;
 * implements 是实现多个接口, 接口的方法一般为空的, 必须重写才能使用 。
 * 继承只能继承一个类，
 *但implements可以实现多个接口，用逗号分开就行了 比如 ：class A extends B implements C,D,E 。
 */
public class Demo implements USB,USB3,Demo2{//接口实现类必须创建接口实现类的所有接口的抽象方法（和抽象类的一样：抽象修饰-Persia类）
    @Override
    public void method1() {
        System.out.println("11_A接口的抽象方法"+AGREEMENT+N);
    }

    @Override
    public void method2() {
        System.out.println("11_B接口的抽象方法");
    }

    @Override
    public void method33() {
        System.out.println("usb1.0功能");
    }

    @Override
    public void method22() {
        System.out.println("usb2.0增加功能+usb1.0功能");
    }

    @Override
    public void method11() {
        System.out.println("usb3.0增加功能+usb2.0功能+usb1.0功能");
    }

    @Override
    public void key() {
        System.out.println("Demo2继承的键盘功能");
    }

    @Override
    public void mou() {
        System.out.println("Demo2继承的鼠标功能");
    }
}
