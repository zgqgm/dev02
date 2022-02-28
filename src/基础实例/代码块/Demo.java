package 基础实例.代码块;
/**     运行认真看执行顺序 ！（也可以Debug）    */
public class Demo extends Father {
    static Demo doem1=new Demo();//在运行类中创建该类对象不加--static--会导致无限循环调用该类。
    static Demo demo2=new Demo();
    {
        System.out.println("D-4子类构造代码块");
    }
    public static void main(String[] args){
        Block block=new Block();
        System.out.println("main方法");
        new Demo();
    }
    static {
        System.out.println("4与main同类的子类静态代码块");
    }
    /**
     * 执行级：与main同类的静态代码块 > (静态代码块 >构造代码块 >构造方法)
     */

    public Demo(){
        System.out.println("D-4子类构造方法");
    }
}
