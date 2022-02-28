package 基础实例.泛型;
//泛型能够把一部分的运行期bug提升到编译期。
//dk1.5之前就是通过继承来实现这种泛化的。
//核心就是Object
//参数化类型：把类型当做参数进行传递。
//泛型标识符是：自定义无意义英文大写单字符占位符（其他的任意字符或字符串都行，但不建议使用）
public class Test {
    public static void main(String[] args) {
        //():方法;[]:数组;{}:代码块；<>:泛型;
        getpar(1);
        getpar("根据参数定义类型");
        getpar(false);
        System.out.println("*******************************");
        System.out.println(getpa(1));/**泛型中只能使用包装类，不能使用基本数据类型*/
        System.out.println(getpa("abc1"));
        System.out.println(getpa('c'));

        //泛型类
        /**
         * class 类名<泛型标识符> {}
         */
        Demo emo1=new Demo(125);
        Demo emo2=new Demo("125");
        System.out.println(emo1.getT()+"\n"+emo2.getT());

        //泛型接口：接口比抽象类还抽象，泛型接口是对接口的抽象；
        emo1.result();
    }
    //泛型方法：给方法上定义一个泛型，就是泛型方法。
    //格式：访问修饰符 <泛型标识符> 返回值类型 方法名(泛型标识符 参数名) {}
    //     public <T> void method(T param) {}
    public static <T> void getpar(T data){
        System.out.println(data);
    }//这里的泛型用于解决参数个数相同但数据类型不同的多个方法重写。
    public static <A> A getpa(A data){//这里定义的是泛型A的返回值类型。
        return data;
    }
}
