package homework;

import java.util.Arrays;

public class m11d30 {
    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0},  nums2 = {1,2,3,5,6};
        int m = 1, n = 5;
        merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            /*int b=0;
            for (int i=0;i<nums1.length;i++){//遍历nums1
                if (n!=0&&nums1[i]>nums2[b]){//当前位后的数后移一位
                    for (int j=m;j>i;j--)
                    nums1[j]=nums1[j-1];
                    nums1[i]=nums2[b];//nums2对应数给nums1
                    m++;
                    b++;
                }
            }
            for (int i=m;b<n;i++,b++){//nums2补全nums1的空位
                nums1[i]=nums2[b];
            }*/
        int i = m,j = 0;
        while(i < m + n){
            nums1[i++] = nums2[j++];
        }
        Arrays.sort(nums1);
        for (int v:nums1){
            System.out.print(v);
        }
    }
}
