package 基础实例.内部类.成员内部类;

public class Test {
    public static void main(String[] args){
        //内部类对象创建方式
        //-1-借助外部类对象创建
       /* Demo out=new Demo();
        Demo.inner inneR=out.new inner();//外部类类名.内部类类名 内部类对象名= 外部类对象名.new 内部类类名（）；
        System.out.println(inneR.name);
        inneR.inneR();*/
        //-2-直接使用外部类的匿名对象创建
        Demo.inner inneR=new Demo().new inner();
        System.out.println(inneR.name);
        inneR.inneR();
    }
}
