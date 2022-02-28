package 基础实例.接口.接口优化;

public class JiaFei extends Common{
    @Override
    public void breed() {
        System.out.println("加菲猫");
    }

    @Override
    public void test11() {
        super.test11();//这里如果不重写default方法，就不再写继承default方法。如果要重写就把 super.test11();换成要重写的内容。
    }
}
