package 基础实例.内部类.匿名内部类.实例;

/**
 * 所有内部类优点：
 * 1.可以独立继承或实现一个接口，外部类不受内部类的影响。
 * 2.增加封闭性（内部类可以使用private修饰；对内隐藏实现，对外提供接口）
 * 3.对单一用途的类进行逻辑分类，让类与类之间存在非继承关系。
 * 4.提高代码的可读性和维护性。
 * 特点：
 * 1. 非静态内部类可以访问外部类的其他成员，包括私有化的成员。
 * 2. 静态内部类不能访问外部类的非静态成员，非静态需要创建对象。
 * 3. 内部类可以有自己的成员，可以被访问修饰符修饰。
 */

public class Test {
    public static void main(String[] args){
        innerClass inner=new innerClass(){//对接口直接重写：匿名内部类  优点：免去了类的创建。
            @Override
            public void method() {
                System.out.println("匿名内部类");
            }
        };
        inner.method();//调用接口方法
        /*     ||  相当于通过类间接创建   */
        /*   \ || /                   */
        /*     \/                     */
        /*innerClass inner=new Demo();//多态：接口指向类。
         *inner.method();
         */

        new innerClass(){

            @Override
            public void method() {//匿名对象.
                System.out.println("1-匿名内部类");
            }
        }.method();

        innerClass inna=()->System.out.println("指针");
        inna.method();
    }
}
