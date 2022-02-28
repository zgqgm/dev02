package homework;

import java.util.Scanner;
public class m11d14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long in=sc.nextLong();
        long n=0;
        for (long m=1;in/m!=0;m*=10){//判断是否被除尽
             n=n*10+in/m%10;//获取对应位数的反转数
        }
        int i = (int) n == n ? (int) n : 0;//判断是否为32为
        System.out.println(i);
    }
}
