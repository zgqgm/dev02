package 基础实例.接口多态.实例;

public class Mouse implements USB{
    @Override
    public void connect() {
        System.out.println("连接鼠标点击");
    }
}
