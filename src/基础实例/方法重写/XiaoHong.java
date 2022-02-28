package 基础实例.方法重写;

public class XiaoHong extends Home{
    @Override
    public void master(){
        System.out.println("小红家");
    }
    @Override//注解不写没问题，但还是必须写。
    public void storey(){
        System.out.println("2楼");
    }
    @Override
    public void population(){
        System.out.println("4人");
    }
}
