package 基础实例.抽象修饰;

/**
 * 1. abstract可以用来修饰方法和类。
 * 2. 抽象类中不一定有抽象方法，但是抽象方法一定在抽象类中。
 * 3. 抽象方法不能有方法体。
 * 4. 抽象类不能实例化对象【不能创建对象】，因为抽象类中可能会有未实现的抽象方法。
 * 5. 抽象类的子类：
 *    1. 也是一个抽象类，可以选择性得实现某一些抽象方法，也可以不实现。
 *    2. 是一个具体的类，必须重写所有的抽象方法，可以创建对象。
 */
public abstract class Animals {
    public void eat(){
        System.out.println("吃");
    }
    public abstract void color();//abstract修饰的方法因为是抽象方法，所以不能有方法体。
}
