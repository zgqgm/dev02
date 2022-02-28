package 基础实例.代码块;

public class Father {
    public Father(){
        System.out.println("父类构造方法");
    }
    {
        System.out.println("父类构造代码块");
    }
    static {
        System.out.println("父类静态代码块");
    }
}
