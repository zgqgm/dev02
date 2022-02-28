package homework;
import java.util.Scanner;
public class m11d8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入月份数：");
        int month= sc.nextInt();//获取月份
        int n,adult=0,child=1;//兔子初始数量情况
        for (int i=1;i<month;i++){
            n=adult;//获取上个月的成年兔数量
            adult=child+adult;//成年兔等于上个月的幼兔加成年兔
            child=n;//本月新生幼兔等于上个月成年兔数量
        }
        int cp=child+adult;
        System.out.println("输出："+cp);
    }
}
