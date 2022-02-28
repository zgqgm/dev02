package 基础实例.API;

public class Test {
    public static void main(String[] args){
        String action="奔跑";
        Object num=3*2;System.out.println(num);
        String action1=new String("雷霆半月斩");
        int indexOf = action1.indexOf('月');//查找--字符串下标
        System.out.println(indexOf);
        char[] arrays=new char[]{'洛','洛'};
        String n=String.copyValueOf(arrays);//拼接字符数组

        System.out.println(n+action+action1+"\n"+action.toString());
        Demo_1 demo=new Demo_1("小明",(byte)12,12,'男');
        /*demo.setName("小明");
        demo.setAge((byte) 18);
        demo.setID(2020063801);*/
        System.out.println(demo.toString());

    }
}
