package homework;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class m11d3 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date parse1=sdf.parse("2011-1-1");
        long firstDay=parse1.getTime();

        String year,month,day;
        Scanner sc=new Scanner(System.in);
        System.out.printf("请输入年：");
        year = sc.next();
        System.out.printf("请输入月：");
        month = sc.next();
        System.out.printf("请输入日：");
        day = sc.next();
        String lin=year+"-"+month+"-"+day;
        Date parse=sdf.parse(lin);
        long today=parse.getTime();

        long time=(today-firstDay)/1000/3600/24%5;

        if (time==3||time==4){
            System.out.println("今天晒网");
        }else {
            System.out.println("今天打鱼");
        }
    }
}