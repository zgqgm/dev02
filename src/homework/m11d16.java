package homework;

import java.util.Scanner;

public class m11d16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=0;
        boolean p=false;
        int num=sc.nextInt();
        if (num>100){
            for (int n=1;num/n!=0;n*=10){
                i=i*10+num/n%10;
            }
            if (i==num){
                p=true;
            }
        }
        System.out.println(p);
    }
}
