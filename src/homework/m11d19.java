package homework;

import java.util.Scanner;
public class m11d19 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] strs=new String[200];
        int i=0;
        while (!sc.hasNext("#")){
            strs[i]=sc.next();
            i++;
        }
        if (i==1){//如果只录入一个字符串则直接输出
            System.out.println(strs[0]);
        }else {
            int min=200;
            for (int j=0;j<i;j++){//找出字符串数组中最短字符串的长度
                if (strs[j].length()<min){
                    min=strs[j].length();
                }
            }
            boolean tf=false;
            int l=min;
            int j=0;
            for (;l>=0;l--){
                j=0;
                for (;j<i-1;j++){//根据min的迭代进行截取
                    //判断截取的字符串的相邻两组是否相等
                    tf=strs[j].substring(0,l).equals(strs[j+1].substring(0,l));
                    if (!tf){//只要有false就结束本轮循环
                        break;
                    }
                }
                if (tf){//只要遇到ture就停止循环
                    break;
                }
            }
            //结果输出
            if (!tf){
                System.out.println("\"\"");
            }else {
                System.out.println("\""+strs[j].substring(0, l)+"\"");
            }
        }
    }
}
