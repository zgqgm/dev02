package homework;

public class m11d24 {
    public static void main(String[] args) {
        String s = "Hello a lls   ";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        String[] ss=s.split(" ");
        return ss[ss.length-1].length();

        /*char[] ss=s.toCharArray();
        int num=0;
        for (int i=ss.length-1;i>=0;i--){//倒着遍历
            if (ss[i]==' '){
                if (num==0){
                   num--;//如果num为0时，遇到空格则减一
                }else {
                    break;
                }
            }
            num++;//记录循环次数
        }
        return num;*/
    }
}
/*String[] ss=s.split(" ");//根据空格获取数组
        int n=ss[0].length();
        for (int i=1;i< ss.length;i++){//找到最大长度
            if (ss[i].length()>n){
                n=ss[i].length();
            }
        }*/
