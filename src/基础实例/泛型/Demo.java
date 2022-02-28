package 基础实例.泛型;
//泛型类
//泛型的本质就是Object。声明的时候是T，但是经过编译之后全部都变成了Object。
public class Demo <T>{
    private T t;

    public Demo(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void result(){
        Father father1=new Father("智羊羊",30);
        Father father2=new Father("红魔鬼",34);
        Son son1=new Son("喜羊羊",8);
        Son son2=new Son("麦当",16);
        int num1=father1.compareTo(father2);
        int num2=son1.compareTo(son2);
        if (num1>0){
            System.out.println(father1.getName()+"年龄大");
        }else if (num1<0){
            System.out.println(father2.getName()+"年龄大");
        }else {
            System.out.println(father1.getName()+"和"+father2.getName()+"一样大");
        }
        if (num2>0){
            System.out.println(son1.getName()+"年龄大");
        }else if (num2<0){
            System.out.println(son2.getName()+"年龄大");
        }else {
            System.out.println(son1.getName()+"和"+son2.getName()+"一样大");
        }
    }

    /**
     * 泛型类的类型在创建对象的时候被确定。而静态类被加载的时候才加载静态的内容，这个时候还没有创建对象，所以泛型的类型没有被确定
     * @param t 参数常量
     * @param <T> 静态标识符
     */
    public static <T> void meth(T t){//静态只能调用静态
        T a=t;
    }
}
