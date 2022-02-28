package homework;

import java.util.ArrayList;
import java.util.List;

public class m12d2 {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outlist = new ArrayList<>();
        for (int i = 0;i < numRows;i++){//根据numRows控制外层个数；
            List<Integer> innlist= new ArrayList<>();
            if (i>0){//如果不是第一行
                innlist.add(1);//第一个设置为1
                for (int j = 0;j < i-1;j++){
                    //获取上一层对应下标的元素与下一元素的之和；
                    int num = outlist.get(i-1).get(j)+outlist.get(i-1).get(j+1);
                    innlist.add(num);
                }
                innlist.add(1);//最后一个设置为1；
            }else {
                innlist.add(1);
            }
            outlist.add(innlist);
        }
        return outlist;
    }
}