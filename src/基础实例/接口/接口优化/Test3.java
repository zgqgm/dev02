package 基础实例.接口.接口优化;

public class Test3 {
    public static void main(String[] args){
        JiaFei jiaFei = new JiaFei();
        jiaFei.breed();
        jiaFei.leg();
        YingDuan yingDuan = new YingDuan();
        yingDuan.breed();
        yingDuan.leg();
        yingDuan.test11();//default方法。
        cat.test22();//接口名.方法名 直接调用static方法。
    }
}
