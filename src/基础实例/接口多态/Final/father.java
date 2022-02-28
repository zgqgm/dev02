package 基础实例.接口多态.Final;

public class father {
    public father() {
        this.show();
    }
    public final void show(){//构造方法中调用的方法一定要用final修饰。否则会因为多态导致一些神奇的问题。(eg:在子类中重写后，父类被覆盖)
        System.out.println("这是父辈");
    }
}
