package homework;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class m11d17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, Integer> rm = new TreeMap<>();
        rm.put("I",1);
        rm.put("V",5);
        rm.put("X",10);
        rm.put("L",50);
        rm.put("C",100);
        rm.put("D",500);
        rm.put("M",1000);
        String s= sc.next();
        char[] array=s.toCharArray();
        int sum=0;
        for (int i= array.length-1;i>0;i--){//从后向前遍历
            if (rm.get(String.valueOf(array[i]))<=rm.get(String.valueOf(array[i-1]))){//判断当前元素与上一个元素大小关系，已决定加减
                sum+=(rm.get(String.valueOf(array[i]))+rm.get(String.valueOf(array[i-1])));
            }else {
                sum-=(rm.get(String.valueOf(array[i-1]))-rm.get(String.valueOf(array[i])));
            }
            i--;
        }
        if (array.length%2!=0){//判断是否是奇偶数，已决定是否需要加减第一个元素
            if (rm.get(String.valueOf(array[1]))<=rm.get(String.valueOf(array[0]))){
                sum+=rm.get(String.valueOf(array[0]));
            }else{
                sum-=rm.get(String.valueOf(array[0]));
            }
        }
        System.out.println(sum);
    }

}
