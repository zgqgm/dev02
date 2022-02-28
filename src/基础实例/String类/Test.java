package 基础实例.String类;

/**
 * synchronized 方法和代码块的修饰符 **锁**
 */
public class Test {
    public static void main(String[] args) {
        //所有对字符串进行操作的方法，都不会影响到原有字符串，每次都会创建一个新的对象。因为字符串是个常量，是不可变的。
        System.out.println("abc");//-->字符串abc存放在 堆 的字符串常量池中。
        String st="abc";//变量st（地址）存放在栈中，然后指向 堆 的字符串常量池中的字符串abc.
        System.out.println(st);//st指向 堆 的字符串常量池中的字符串abc。
        //这里创建了一个对象--abc--
        //所以 堆 的字符串常量池中的字符串abc可供多个变量来指向，又所以，（堆 的字符串常量池中的）字符串是不可变的。
        //字符串常量池在堆中【JDK1.8】;JDK1.7的时候字符串常量池在方法区中

        System.out.println("abc");
        System.out.println("abc"+"d"+"e");
        //这里创建了5个对象--（abc、d、e、abcd、abcde）--

        String st1="123456789";
        String st2=st1.substring(1,4);//截取*****************************
        System.out.println(st2);

        String st3=st2.concat(st);//拼接*********************************
        System.out.println(st3);

        String st4=new String();//输出时啥也没有，使用concat时也无法拼接，但不报错。
        String st5=null;//使用concat时报错。
        String st6=new String("abc");//变量st6放到栈中，指向在堆中新建的对象，该对象（存储地址）指向堆中字符串常量池中的abc
        //由此也可看出String类也有构造方法。
        char[] arrays={'拼','接','组','合'};
        String st8=new String(arrays);//将字符数组转化为字符串。
        System.out.println(st8);
        /**
         * StringBuffer和StringBuilder的区别【面试题】
         * StringBuffer更安全，但是速度慢。
         * StringBuilder更快，但是不安全。//尽量使用StringBuilder
         */
        StringBuffer sbr=new StringBuffer("这是Stringbuffer");
        String st7= new String(sbr);
        StringBuilder sbd=new StringBuilder("这是StringBuilder");
        //链式编程
        sbd.append("拼接1").append("拼接2").append("拼接3").replace(0,3,"替换").insert(0,"插入")
                .delete(17,20);//.append（）拼接、.replace（）替换、.insert()插入、.delete()删除；
        System.out.println(sbd);
        System.out.println(sbd.toString().length());//.toString()将sbd从Stringbuilder转化为String类型。.length()获取字符串长度。
        System.out.println(sbd.getClass()+"****"+sbd.toString().getClass().getName());
        //.getClass()获得类型 ；.getClass().getName()也是获得类名 但输出比前者少了个class。

    }
}
