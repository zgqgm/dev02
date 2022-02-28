package 基础实例.接口;

import 基础实例.接口.Intelface.USB;

public class test2 {
    public static void main(String[] args){
        //chu创建接口实现类的对象并调用重写后的方法。
        Demo deom=new Demo();
        deom.method1();
        deom.method2();
        deom.method11();
        deom.method22();
        deom.method33();
        deom.key();
        deom.mou();
        /*
        如果接口的实现类（或者是父类的子类）只需要使用唯一的一次，
        那么这种情况下就可以省略掉该类的定义，而改为使用【匿名内部类】。

        匿名内部类的定义格式：
        接口名称 对象名 = new 接口名称() {
        // 覆盖重写所有抽象方法
        };

        对格式“new 接口名称() {...}”进行解析：
        1. new代表创建对象的动作
        2. 接口名称就是匿名内部类需要实现哪个接口
        3. {...}这才是匿名内部类的内容

        另外还要注意几点问题：
        1. 匿名内部类，在【创建对象】的时候，只能使用唯一一次。
        如果希望多次创建对象，而且类的内容一样的话，那么就需要使用单独定义的实现类了。
        2. 匿名对象，在【调用方法】的时候，只能调用唯一一次。
        如果希望同一个对象，调用多次方法，那么必须给对象起个名字。
        3. 匿名内部类是省略了【实现类/子类名称】，但是匿名对象是省略了【对象名称】
        强调：匿名内部类和匿名对象不是一回事！！！
        */

        //接口的多态，左父右子，编译看左边，运行看右边创建实现类对象进行调用。
        USB usb2=new Demo();//38-40行也能调用Demo对象的方法。所以运行后可以看到有重复步骤。因为Demo
        //usb2.method1();
        //usb2.method2();
        new USB(){
            @Override
            public void method1() {
                System.out.println("接口匿名内部类的实现33_A接口的抽象方法");
                //匿名内部类好处：省去了接口的实现类创建，接口可以被直接覆盖重写（创建接口后可以直接根据接口重写方法）
            }

            @Override
            public void method2() {
                System.out.println("接口匿名内部类的实现33_B接口的抽象方法");//这个不会输出，因为64行只调用了method1接口的抽象方法.
            }
        }.method1();//new一次只能调用一个方法。
        new USB(){
            @Override
            public void method1() {
                System.out.println("接口匿名内部类的实现44_A接口的抽象方法");//这个不会输出，因为64行只调用了method2接口的抽象方法.
            }

            @Override
            public void method2() {
                System.out.println("接口匿名内部类的实现44_B接口的抽象方法");
            }
        }.method2();
    }
}
