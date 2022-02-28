package homework;

public class m11d27 {
    public static void main(String[] args) {
        int[] digits = {9,9};
        int[] sa=plusOne(digits);
        for (int i:sa){
            System.out.println(i);
        }
    }
    public static int[] plusOne(int[] digits) {
        /*int dig=digits.length-1;
        if (digits[dig]!=9){//如果最后一个元素不等于9则加一返回
            digits[dig]+=1;
            return digits;
        }else if (digits[0]!=9){//如果首元素不等于9，则遇到9变为0，非9加一返回
            for (;dig>=0;dig--){
                if (digits[dig]==9){
                    digits[dig]=0;
                }else {
                    digits[dig]+=1;
                    return digits;
                }
            }
        }else {
            int[] newarr=new int[dig+2];
            for (;dig+1>0;dig--){
                if (digits[dig]==9){
                    digits[dig]=0;//旧数组中间有非九值，则遇到9变为0，非9加一返回
                    newarr[dig+1]=0;//
                }else {//随之存0
                    digits[dig]+=1;
                    return digits;
                }
            }
            newarr[0]=1;//首值赋值1
            return newarr;//返回新数组
        }
        return digits;*/

        //优化后的代码
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;

    }
}
