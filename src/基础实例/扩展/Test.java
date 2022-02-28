package 基础实例.扩展;
//Lambda->扩展又称闭包。可读性差。

/**
 * 1. Lambda必须是接口，匿名内部类可以是抽象类或者接口
 * 2. Lambda要求只能有一个抽象方法，匿名内部类没有限制
 * 3. 匿名内部类会生成一个.class字节码文件，Lambda不会，因为是动态生成的【反射】
 *
 * 使用Lambda表达式可以简化匿名内部类的使用，让代码更加得简洁和紧凑。（Lambda 把所有声明的内容全部都去掉了）
 */
public class Test {
    public static void main(String[] args){
        //(参数列表)->{方法体}
        int Num1=2,Num2=5;
        Demo_1 demo1=()->System.out.println("1Lambda接口");//如果只有一个语句，大括号是可选【建议加上】
        demo1.method1();

        Demo_3 demo2=(num1,num2)->{
            if (num1>num2){
                return 1;
            }else if(num2>num1){
                return -1;
            }else {
                return 0;
            }
        };
        int num=demo2.method4(Num1,Num2);
        System.out.println(num);

        Demo_4 demo4=name -> {
            return name;
        };
        String NAME=demo4.method4("小明");
        System.out.println(NAME);
        /*         ||  24-26简化*/
        /*       \ || /        */
        /*         \/          */
        Demo_4 demo5=name->name;//如果只有一个参数，小括号可以不写【建议加上】
        String NAME1=demo4.method4("小红");
        System.out.println(NAME1);
    }
}
