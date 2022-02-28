package 基础实例.抽象修饰;

public class Persia extends Cat{
    /**
     * 抽象类的子类必须创建抽象类的所有抽象方法
     */
    @Override
    public void color() {
        System.out.println("灰色波斯猫");
    }
}
