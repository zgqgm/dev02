package 基础实例.内部类.局部内部类;

public class DemoOut {
    public String lei1="外类公开变量";
    private String lei2="外类私有变量";
    private static String lei3="外类私有静态变量";
    public void method(){//外类方法
        final int num=1;//final写不写都默认带有final修饰。最好写上，便于阅读理解。
        class innerClass{
            public void method(){//内类方法
                System.out.println(lei1+"\n"+lei2+"\n"+lei3+"\n"+num);
            }
        }
        innerClass inner=new innerClass();//创建内类对象
        inner.method();//调用内类方法
    }
}
