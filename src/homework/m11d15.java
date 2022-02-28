package homework;

import java.util.ArrayList;
import java.util.Scanner;
public class m11d15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> num=new ArrayList<>();
        System.out.println("请依次输入整数（输入#结束）");
        while(!sc.hasNext("#")){
            String nums=sc.next();
            num.add(nums);
        }
        /*for (int i=0,z=0;i<num.size();i++){//遍历
            if (num.get(i).equals("0")){//判断是否为零
                for (int j=i;j<num.size()-1;j++) {//零后元素前移一位
                    num.set(j, num.get(j + 1));
                }
                num.set(num.size()-1,"0");//最后一位设为零
                i--;
                z++;
            }
            if (i== num.size()-z){//判断当前下标是否等于最后一个下标
                break;
            }
        }*/
         int j=0;
        for (int i=0;i<num.size();i++){
            if (!num.get(i).equals("0")){
                num.set(j++, num.get(i));//非零数依次排位
            }
        }
        for (;j< num.size();j++)//非零数排位之后对剩下的赋值为零
            num.set(j,"0");
        System.out.println(num);
    }
}
