package homework;

public class m11d2 {
    public static void main(String[] args) {
        int n=1;
        for (int i=9;i>=1;i--){
            n=2*(n+1);
        }
        System.out.println("猴子第一天摘的桃子数："+yesterday(1)+"  "+n);
    }
    public static int yesterday(int day){
        int n;
        if(day==10){
            n=1;
        }else{
            n=2*(yesterday(day+1)+1);
        }
        return n;
    }
}
