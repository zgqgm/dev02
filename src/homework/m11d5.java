package homework;

public class m11d5 {
    public static void main(String[] args) {
        int sum=1,b=1;
        for (int A=2;A<3000;A++){
            for (int j=2;j<A;j++){
                if (A%j==0){
                    sum+=j;
                }
            }
            for (int i=2;i<sum;i++){
                if (sum%i==0){
                    b+=i;
                }
            }
            if (b==A&&A!=sum){
                System.out.println(sum+"和"+A);
                A=sum;
                b=1;
                sum=1;
            }else {
                sum=1;
                b=1;
            }
        }
    }
}
