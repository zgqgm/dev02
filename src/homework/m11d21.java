package homework;

public class m11d21 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len=removeDuplicates(nums);
        for (int i=0;i<len;i++){
            System.out.print(nums[i]);
        }
        System.out.println("\n"+len);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int inx=0;
        for (int num=0;num<nums.length;num++){
            if (nums[inx]!=nums[num]){
                inx++;
                nums[inx]=nums[num];

            }
        }
        return inx+1;
    }
}
