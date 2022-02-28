package homework;
import java.util.ArrayList;
import java.util.Scanner;
public class m11d18 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        while(s.contains("()") || s.contains("{}") || s.contains("[]")){
                s = s.replace("()","");
                s = s.replace("{}","");
                s = s.replace("[]","");
        }
        if (s.isEmpty()){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

}
