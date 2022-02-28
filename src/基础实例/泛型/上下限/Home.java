package 基础实例.泛型.上下限;

import 基础实例.泛型.多态的进阶.Grade;

public class Home {
    // 泛型上限，使用的时候要求必须传递一个Father或者Father的子类型
    public void showExtends(Grade<? extends Father>grade){
        System.out.println(grade);
    }
    // 泛型下限，使用时可以传递一个Father或者它的父类
    public void showSuper(Grade<? super Father> grade) {
        System.out.println(grade);
    }
}
