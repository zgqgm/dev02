package 基础实例.泛型.上下限;

import 基础实例.泛型.多态的进阶.Grade;

public class Test {
    public static void main(String[] args) {
        Home home = new Home();

        //<? extends T> 泛型上限，可以使用T以及T的子类
        home.showExtends(new Grade<Son>(new Son("小王",22)));

        //<? super T> 泛型下限，可以使用T以及T的父类
        home.showSuper(new Grade<GrandPa>());

        // 泛型推断，一定要写<>:能够根据声明的泛型推出来赋值时的类型
        Grade<Father> grade = new Grade<>();
    }
}
