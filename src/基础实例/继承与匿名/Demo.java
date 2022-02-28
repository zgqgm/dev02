package 基础实例.继承与匿名;

public class Demo {
    /**
     * 继承时无参构造（无参构造主要用来创建对象）可以被继承，而有参构造（private、访问修饰符不写时--下看24-27行）不能被继承。
     * 执行子类时，先会执行被继承的父类，再执行子类。
     */
    public static void main(String[] args){
        //继承者可以任意，而被继承者只能有一个。（只继承公共属性与方法，private的不行！）
        Son son = new Son();
        String surname=son.surname;
        System.out.println(surname);//这里Son就继承了Father的属性（方法一样），而Father则继承了Grandfather的属性（方法一样）。所以可以多级继承，但不能多重继承。
        System.out.println(son.experience);//这里直接用对象而不像上面的son.surname赋给了变量surname，就是匿名的方法。
        Grandfather grandfather=new Grandfather();
        System.out.println(new Grandfather());//这里对Grandfather类直接用new调用而不像“Grandfather grandfather=new Grandfather();”一样，也是匿名的方法。
        System.out.println(new Grandfather());
        System.out.println("------------------------------------------------");
        System.out.println(grandfather);
        System.out.println(grandfather);
        //12-16行运行可知，匿名后类是即用即创建，用完就删除。所以12-13的地址不一样，而15-16的地址一样。（其他对象匿名后同理）
    }
}
/**
 * public在同类下、同包不同类、不同包的子类下、不同包都能用。
 * private在同类下下都能用，同包不同类、不同包的子类、不同包都不能用。
 * 访问修饰符不写时在同类下、同包不同类下都能用 ，不同包的子类、不同包都不能用。
 * protected在同类下、同包不同类、不同包的子类下都能用， 不同包不能用。
 */