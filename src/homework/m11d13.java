package homework;

import java.util.Arrays;
import java.util.Scanner;

public class m11d13 {
    public static void main(String[] args) {
        int sum=0,a=0,b=1;//a，b获取下标
        Scanner sc=new Scanner(System.in);
        System.out.print("nums =");
        String nums =sc.nextLine();
        System.out.print("target =");
        int target=sc.nextInt();
        char[] n=nums.toCharArray();//将string转为字符数组
        for(int i=0;i<n.length;i++){//遍历
            if (Character.isDigit(n[i])){//判断是否是数字
                for (int j=i+1;j<n.length;j++){//遍历
                    if (Character.isDigit(n[j])){//判断是否是数字
                        sum=Integer.parseInt(String.valueOf(n[i]))+Integer.parseInt(String.valueOf(n[j]));//将char转string再转int
                        if (sum==target){
                            System.out.println("["+a+","+b+"]");
                            i=j;
                        }
                        b++;
                    }
                }
                a++;
                b=a+1;
            }
        }
    }
}
