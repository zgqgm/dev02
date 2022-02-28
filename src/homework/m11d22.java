package homework;

public class m11d22 {
    public static void main(String[] args) {
      String haystack = "heasloll", needle = "l";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        char[] ha=haystack.toCharArray();
        char[] ne=needle.toCharArray();
        int n=0;
        //遍历要查找的字符数组ha
        for (int i=0,num=-1;i<ha.length;i++){
            num++;//记录执行次数
            if (ha[i]==ne[0]){//判断当前的ha值是否等于ne的第一个值
                for (int j=0;j<ne.length;j++){//遍历被查找的字符数组ne
                    //判断当前的ha值是否等于当前的ne的值
                    if (j+num<ha.length&&ha[j+num]==ne[j]){
                        n=i;
                    }else {
                        n=-1;
                        break;
                    }
                }
            }
            if (n>0){
                return i;
            }
        }
        return -1;
    }
}
