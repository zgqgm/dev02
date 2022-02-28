package 基础实例.接口.接口优化;

public abstract class Common implements cat {
    @Override
    public void leg(){
        System.out.println("通过抽象类对公共部分进行封装：4条腿");
    }
}
