package 基础实例;

public class 方法重载 {
    //主函数入口
    public static void main(String []args){
        int x,y;
        x=sum(2,5);//获得将2，5传给sum的返回值
        y=sum(2,3,5);//获得将2，3，5传给sum的返回值
        System.out.println("x="+x+"; y="+y);
        //-------------------------------------------------
        /**
         * 构造方法
         *1. 类名与方法名相同（注意大小写）
         *2.不写返回值类型（有返回值，是对象本身。但还是不要写！！！）
         */
        /*Dog dog = new Dog();//当Dog类里不写同名方法时，该语句会初始化对象属性。
        System.out.println(dog.breed);
        *///可以注释Dog类中的同名方法试一试。如果不注释同名方法，上一条语句会报错。因为自定义后便不再初始化。
        /**
         * 构造重载是方法重载中的一种（可以自己对比一下）
         */
        Dog dog1 = new Dog("二哈");
        System.out.println("1.\n"+dog1.breed+"\n"+dog1.color+"\n"+dog1.age);
        Dog dog2 = new Dog("比熊",3);
        System.out.println("2.\n"+dog2.breed+"\n"+dog2.color+"\n"+dog2.age);
        Dog dog3 = new Dog("金毛","黄色",2);
        System.out.println("3.\n"+dog3.breed+"\n"+dog3.color+"\n"+dog3.age);
    }

    /**
     * 方法重载就是定义两个或两个以上的方法 的 方法名相同
     * 1.方法名相同
     * 2.形参不同（数据类型，数量等）
     * 3.与返回值无关
     */
    public static int sum(int a,int b){
        return (a+b);
    }
    public static int sum(int a,int b,int c){
        return (a+b+c);
    }
}
class Dog{
    String breed;
    String color;
    int age;
    //在构造方法的基础上定义两个或两个以上的同名方法就是  构造重载 ！！！
    public Dog(String breed){
        this.breed=breed;//this指当前对象，这样写是为了区分同名的成员变量与局部变量，提高代码规范性。（也可以不这样写）
        /*//2
            this(breed,null,0);
         */
    }//有形参的是有参构造，反之为无参构造（无参构造没啥意义，不用写）。
    public Dog(String breed,int age){
        this(breed);//用this调用上面的方法可以避免代码冗余
        this.age=age;
        /*//2
            this(breed,null,age);//char的初始值是"\u0000"也对应空格键
         */
    }
    public Dog(String breed,String color,int age){
        this(breed,age);
        this.color=color;
        /*//2
            //避免冗余的第二种方法是上面两种方法都用this调用这个方法（可以将方法一注释掉，运行方法二试试）
            this.breed=breed;
            this.color=color;
            this.age=age;
         */
    }
}