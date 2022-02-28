package 基础实例.进制转换;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        /**
         * 包装类包下的Integer包下也有进制转化方法。
         */
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt(2);//radix:指定进制--这里指定了二进制--

        System.out.println(num);//十进制输出

        /*//String line=sc.nextLine();//是next（）的优化，只遇到回车停止。(nextLine（）必须放到（next（）/nextInt（）等前），否则只能录入一次。nextLine（）除外)
        String next=sc.next();//遇到空格、回车停止
        System.out.println(line);//sc.close();//-->停止输入流*/
        String[] arrays=new String[10];
        int i=0;
        if(sc.hasNextInt()){//判断录如类型是否与模板相同，若相同则返还true，否则返还false;
            String test=sc.next();
            System.out.println(sc.hasNext());
        }

        /*StringBuffer sb=new StringBuffer();//可变长度的String
        while(!sc.hasNext("#")){//输入# 停止录入
            String result=sc.nextLine();
            //arrays[i++]=result;
            sb.append(result);//字符串拼接
        }
        *//*for (int j=0;j< arrays.length;j++){
            System.out.println(arrays[j]);
        }*//*
        System.out.println(sb);*/

        /**
         * 1. final类，不允许子类继承，防止对类进行非法的扩展从而影响到原有的功能。
         * 2. Closeable接口，提供了可关闭的方法，因为输入流是一个资源，作为资源用过一定要关闭
         * 3. Iterator迭代器(next()等)，迭代的思想，先判断是否还有下一个元素，然后再获取
         * 4. 封装的思想，我们用输入流操作比较麻烦，Scanner对输入流进行了一定程度上的封装，提供了一些数据类型，进制的自动转换的方法，避免了我们操作时的麻烦。
         */
    }
}
