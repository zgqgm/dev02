package homework;

import java.util.Arrays;

public class m12d1 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,4,2};
       // System.out.println(singleNumber(nums));
        int n=10;
        int m= 3;
        /*m=n^m;    n=m+n;   m和n换值的方法（第一个是异或法）两个原理相似
        n=n^m;      m=n-m;
        m=n^m;      n=n-m;*/
        System.out.println(n+" "+m);
    }
    public static int singleNumber(int[] nums) {

        Arrays.sort(nums);//升序排列
        for (int i = 0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){//相同跳过下一个，否则返回
                i++;
            }else {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
