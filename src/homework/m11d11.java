package homework;
import java.util.Scanner;
public class m11d11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入行数(若键入偶数将加1)：");
        int height=sc.nextInt();
        int n,m;
        n=height/2+1;
        height=height+1;
        m=n;
        if (height>0){//判断键入值有效
            for (int i=0,l=n;i<height;i++){//控制行数
                if (i<m){//控制空格输出
                    l--;
                }else{
                    l++;
                }
                for (int j=0;j<n;j++){//控制列数
                    if (j<l){
                        System.out.print(" ");
                    }else {
                        System.out.print("*");
                    }
                }
                System.out.println("");//控制换行
                if (i<m-1){//控制“*”输出
                    n++;
                }else {
                    n--;
                }

            }
        }
    }
}
