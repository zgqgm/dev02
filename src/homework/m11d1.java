package homework;

public class m11d1 {
    public static void main(String[] args) {
        int x,y,z;
        for (int i=100;i<1000;i++){
            x=i/100;
            y=i/10%10;
            z=i%10;
            if ((Math.pow(x,3)+Math.pow(y,3)+Math.pow(z,3))==i){
                System.out.println("水仙花数："+i);
            }
        }
    }
}
