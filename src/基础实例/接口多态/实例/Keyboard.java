package 基础实例.接口多态.实例;

public class Keyboard implements USB{
    @Override
    public void connect() {
        System.out.println("连接键盘敲击");
    }
}
