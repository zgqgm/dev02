package homework;

public class m11d25 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));
    }
    public static int removeElement(int[] nums, int val) {
        int num=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[num++]=nums[i];
            }
        }
        return num;
    }
}
