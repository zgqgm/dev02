package 基础实例;

import java.util.Scanner;

public class 数组传参 {
    public static void main(String[] args){
        int num[]=new int[3];//定义三位数组
        /*
         * 调用求和方法
         * 将数组传入
         */
        sum(num);// 因为num为数组对象，不是基本数据类型。所以不需要在该方法中对sum方法返回值接收，也能得到sum方法中赋给num的值
        System.out.println(num[0]+num[1]+num[2]);
    }
    /**
     * 求和方法
     * @param num
     */
    public static void sum(int num[]){
        /*
         *为数组赋值
         */
        Scanner sc=new Scanner(System.in);
        for (int i=0;i< num.length;i++){
            num[i]= sc.nextInt();
        }
        /*
            int sum=0;
            for (int i=0;i<num.length;i++){
                sum+=num[i];
            }
            System.out.println(sum);//输出sum求和结果
        */
    }
}
