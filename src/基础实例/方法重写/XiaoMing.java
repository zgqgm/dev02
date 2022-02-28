package 基础实例.方法重写;

public class XiaoMing extends Home{
    public XiaoMing() {
        super("final传参");//super有参构造。
        this.master();
        /**
         * super（超类、父类）用来调用父类的属性与方法。
         * super主要用来区分父类与子类。
         */
        super.master();
    }
    public XiaoMing(int age) {
        /*super()无参构造法。*/
        super();//super()与this（）不能同时存在，因为都要写在第一行。

    }

    @Override
    public void master(){
        System.out.println("小明家");

    }
    @Override//注解不写没问题，但还是必须写。
    public void storey(){
        System.out.println("1楼");
    }
    @Override
    public void population(){
        System.out.println("3人");
    }
}
