package 基础实例.内部类.匿名内部类.抽象类;

public class Test {
    public static void main(String[] args) {
        Demo.demonei dd= new Demo().new demonei() {
            @Override
            public void methon() {
                System.out.println("抽象内部类");
            }
        };
        dd.methon();
    }
}
