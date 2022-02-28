package 基础实例.拷贝.克隆;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        long statr=System.currentTimeMillis();
        System.out.println("********************************************************");
        /**
         * 克隆
         */
        Car copy=new Car("比亚迪","白色");
        person pen=new person("小明",copy);
        Object trys=pen.clone();
        person pp=(person)trys;
        System.out.println(pp.getName());
        System.out.println(pen.getName());
        System.out.println("********************************************************");

        //数组复制
        //1:
        int array1[]={1,2,3,4,5,6};
        int array2[]=new int[6];
        System.arraycopy(array1,1,array2,3,3);
        for (int i=0;i<array2.length;i++){
            //System.out.println(array2[i]);
        }
        //2:
        int array3[]= Arrays.copyOf(array1,array1.length*2);//对数组扩容
        for (int i=0;i<array3.length;i++){
           // System.out.println(array3[i]);
        }

        //时间戳
        long time=System.currentTimeMillis();
        System.out.println(time/1000/60/60/24/365);

        //日期格式
        /**
        SimpleDateFormat函数语法：
        G 年代标志符
        y 年
        M 月
        d 日
        h 时 在上午或下午 (1~12)
        H 时 在一天中 (0~23)
        m 分
        s 秒
        S 毫秒
        E 星期
        D 一年中的第几天
        F 一月中第几个星期几
        w 一年中第几个星期
        W 一月中第几个星期
        a 上午 / 下午 标记符
        k 时 在一天中 (1~24)
        K 时 在上午或下午 (0~11)
        z 时区
        */
        SimpleDateFormat sty=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        System.out.println(sty.format(time));
        /*Date tt=new Date();
        System.out.println(tt+"\n"+sty.format(tt));*///同上
        long end=System.currentTimeMillis();
        System.out.println(end-statr);

        /**
         * System.gc();//调用垃圾回收器。**不要用**
         * finl
         */
    }
}
