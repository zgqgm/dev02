package homework;

import java.util.Scanner;

public class m11d4 {
    public static void main(String[] args) {
        double first,second,third;
        //获取三边
        Scanner sc=new Scanner(System.in);
        System.out.printf("请输入第一条边：");
        first=sc.nextDouble();
        System.out.printf("请输入第二条边：");
        second=sc.nextDouble();
        System.out.printf("请输入第三条边：");
        third=sc.nextDouble();
        //条件判断
        if (first>0&&second>0&&third>0){//判断三边是否为正数。若不是则为非三角形，若是则进一步判断。
            if (second+first>third&&second+third>first&&first+third>second){//判断两边之和是否大于第三边。若不是则为非三角形，若是则进一步判断。
                if (first==second||second==third||first==third){//判断是否有两边相等。
                    if (first==second&&second==third){//判断是否有三边相等。若是则为等边三角形，若不是则进一步判断。
                        System.out.println("三角形为：等边三角形");
                    }else {
                        //判断两边的平方和是否等于第三边的平方。若是则为等腰直角三角形，否则为等腰三角形
                        if (Math.pow(first,2)*2==Math.pow(third,2)||Math.pow(second,2)*2==Math.pow(first,2)||Math.pow(first,2)*2==Math.pow(second,2)){
                            System.out.println("三角形为：等腰直角三角形");
                        }else {
                            System.out.println("三角形为：等腰三角形");
                         }
                       }
                }else//判断两边的平方和是否等于第三边的平方。若是则为直角三角形，否则为普通三角形
                    if (Math.pow(third,2)+Math.pow(second,2)==Math.pow(first,2)||Math.pow(first,2)+Math.pow(second,2)==Math.pow(third,2)||Math.pow(first,2)+Math.pow(third,2)==Math.pow(second,2)){
                    System.out.println("三角形为：直角三角形");
                }else {
                    System.out.println("三角形为：普通三角形");
                 }
                //海伦公式求三角形面积
                double l=(second+first+third)/2;
                double av=Math.sqrt(l*(l-second)*(l-first)*(l-third));
                System.out.println("面积为："+av);
            }else {
                System.out.println("非三角形");
            }

        }else {
            System.out.println("非三角形");
        }
    }
}


