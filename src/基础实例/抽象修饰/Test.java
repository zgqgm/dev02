package 基础实例.抽象修饰;

import 基础实例.代码块.Block;

public class Test {
    /**
     * 静态成员变量配合final关键字作为常量使用
     *静态常量要求全部大写，中间用下划线分开
     * (态成员变量常和final关键字一起当做静态常量使用；静态成员方法通常用作工具类 eg:Arrays.sort(arrays);)
     * 工具类的好处是可以避免了创建对象带来的麻烦。
     */
    private static final Block BLOCK=new Block();

    public static void main(String[] args){
        Persia persia=new Persia();
        persia.color();
        persia.eat();
        Garfield garfield=new Garfield();
        garfield.color();
        garfield.eat();
        /**
         *通过类名访问就是静态的方式，
         *不需要创建对象也能访问。
         *静态成员变量应该通过类名访问，与对象无关，因为static修饰相当于没有对象（就像super相当于父类对象）。
         *静态不能调用非静态：
         *在静态的方法中，只能调用静态的成员变量。
         *调用非静态成员变量会直接报错。
         *
         * 静态中不能使用this关键字
         */
        System.out.println(Dog.leg);//static修饰的静态必须在静态类中才能调用。
        BiXiang biXiang=new BiXiang("被覆盖赋值");
        ChineseDog chineseDog=new ChineseDog("展示赋值");


    }
}
