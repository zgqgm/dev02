package 基础实例.内部类.静态内部类;

public class StaticOut {
    public int num1=1;
    private int num2=2;
    public void out1(){
        System.out.println("外类公开方法");
    }
    private void out2(){
        System.out.println("外类私有方法");
    }

    public static int num3=3;
    private static int num4=4;
    public static void out3(){
        System.out.println("外类静态公开方法");
        staticinner.inner3();
        staticinner.inner4();
        System.out.println(staticinner.n3+" "+staticinner.n4);
        staticinner inn=new staticinner();
        inn.inner1();
        inn.inner2();
        System.out.println(inn.n1+" "+inn.n2);
    }
    private static void out4(){
        System.out.println("外类静态私有方法");
    }
    static class staticinner{
        public int n1=11;
        private int n2=22;
        public void inner1(){
            System.out.println("内类公开方法");
        }
        private void inner2(){
            System.out.println("内类私有方法");
        }

        public static int n3=33;
        private static int n4=44;
        public static void inner3(){
            System.out.println("内类静态公开方法");
            //out3();这里如果在调用的话就死循环了。
            out4();
            System.out.println(num3+" "+num4);
            StaticOut out=new StaticOut();//通过创建外类对象调用非静态的变量和方法。
            out.out1();
            out.out2();
            System.out.println(out.num1+" "+out.num2);
        }
        private static void inner4(){
            System.out.println("内类静态私有方法");
        }

    }
}
