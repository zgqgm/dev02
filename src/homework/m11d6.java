package homework;

public class m11d6 {
    public static void main(String[] args) {
        for (int a=0;a<21;a++){
            for (int b=0; b<34 ;b++){
                int c=100-a-b;
                 if (5*a+3*b+c/3==100&&c%3==0){
                        System.out.println("翁："+a+"\n母："+b+"\n雏："+c+"\n");
                 }
            }
        }
    }
}
