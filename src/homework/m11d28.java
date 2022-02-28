package homework;

public class m11d28 {
    public static void main(String[] args) {
        int x=2147483647;
        System.out.println(mySqrt(x));
    }
    public static int mySqrt(int x) {
        int num=x,n=46340;
        if (x==0||x==1)
            return x;
        if(x>=n*n)//提前返回最大次幂之后的可能
            return n;
        for (int i=0;i<x;i++){
            num/=2;
            if (num<n&&num*num<x){//当折半后数的平方小于x时，作为循环的初始值
                for (;;num++){
                    if (num*num>x){
                        return num-1;
                    }
                }
            }
        }
        return x;
    }
}
