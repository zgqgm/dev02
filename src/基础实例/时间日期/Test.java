package 基础实例.时间日期;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 从 JDK 1.1 开始，应该使用 Calendar 类在日期和时间字段之间进行转换，并且应该使用 DateFormat 类来格式化和解析日期字符串。不推荐使用 Date 中的相应方法。
 * 1. Date和Calendar类中的属性都是可变的。
 * 2.Date和Calendar都是非线程安全的。
 * Java.Time下的类有（详情看jdkAPI内）Instant、LocalDate、LocalDateTime、ZonedDateTime、LocalTime
 *
 * 方法名称前缀有一定的标准化。因为 日期 / 时间 API 中的大多数类都是不可变的，所以该类 API 不包括`set`方法.
 * | 前缀   | 方法类型   | 描述                                                   |
 * | of     | 静态工厂  | 创建一个实例，其中工厂主要验证输入参数，而不是转换它们。          |
 * | from   | 静态工厂  | 将输入参数转换为目标类的实例，这可能涉及丢失输入信息。           |
 * | parse  | 静态工厂  | 解析输入字符串以生成目标类的实例。                           |
 * | format | 实例     | 使用指定的格式化程序来格式化时间对象中的值以生成字符串。          |
 * | get    | 实例     | 返回目标对象状态的一部分。                                  |
 * | is     | 实例     | 查询目标对象的状态。                                       |
 * | with   | 实例     | 返回目标对象元素已更改的副本；等价于 JavaBean 上的`set`        |
 * | plus   | 实例     | 返回目标对象的副本，其中添加了一段时间。                       |
 * | minus  | 实例     | 返回目标对象的副本，其中减去了一段时间。                       |
 * | to     | 实例     | 将此对象转换为另一种类型。                                  |
 * | at     | 实例     | 将此对象与另一个对象组合。                                  |
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        long statr=System.currentTimeMillis();
        //时间戳
        long time=System.currentTimeMillis();
        System.out.println(time/1000/60/60/24/365);

        //日期格式
        /**
         SimpleDateFormat函数语法：          Calendar 静态常量
         G 年代标志符                        ERA 时代，世纪
         y 年                               YEAR 年
         M 月                               MONTH 月
         d 日                              WEEK_OF_YEAR 年里的第几周
         h 时 在上午或下午 (1~12)            WEEK_OF_MONTH 月里的第几周
         H 时 在一天中 (0~23)                DATE 月里的第几天
         m 分                              DAY_OF_MONTH 月里的第几天
         s 秒                              DAY_OF_YEAR 年里的第几天
         S 毫秒                            DAY_OF_WEEK 周里的第几天
         E 星期                             DAY_OF_WEEK_IN_MONTH 当前月份中星期几
         D 一年中的第几天                    AM_PM 上午或下午
         F 一月中第几个星期几                  HOUR 小时
         w 一年中第几个星期                   HOUR_OF_DAY 24小时制
         W 一月中第几个星期                   MINUTE 分钟
         a 上午 / 下午 标记符                SECOND 秒
         k 时 在一天中 (1~24)               MILLISECOND 毫秒
         K 时 在上午或下午 (0~11)            ZONE_OFFSET 时区偏移量
         z 时区
         */
        SimpleDateFormat sty=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        System.out.println(sty.format(time));
        /*Date tt=new Date();
        System.out.println(tt+"\n"+sty.format(tt));*///同上
        long end=System.currentTimeMillis();
        System.out.println(end-statr);
        System.out.println("1-------------------------------------------------------------------------------------------");
        Date times1=new Date();//无参构造创建的Date对象表示一个时间
        System.out.println(times1.toString());
        long times=System.currentTimeMillis()-1000;//减去一秒**创建当前时间的时间戳**
        Date times2=new Date(times);//通过时间戳创建一个Date对象
        System.out.println(times2);
        System.out.println("times1是否在times2之后"+times1.after(times2));//.after()/.before()是布尔类型
        System.out.println("times1是否在times2之前"+times1.before(times2));
        System.out.println("times1是否等于times2(大于：返回正数（1）；相等：返回0；小于：返回负数（-1）)"+times1.compareTo(times2));//.compareTo()是int数据类型
        System.out.println("将date转化为时间戳"+times1.getTime());//.getTime()是long数据类型
        times1.setTime(times+6000);//加六秒
        System.out.println("setTime用于设置一个时间戳"+times1);
        DateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");//父类引用指向子类对象【多态】--格式化器--
        //SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");//--格式化器--
        System.out.println(ssdf.format(times));//对Date类的Times进行格式化
        Date parse =ssdf.parse("2002-07-01 15:40:00");// 字符串转为了Date对象
        System.out.println("Date转字符串"+parse);
        System.out.println("2-------------------------------------------------------------------------------------------");
        DateFormat dF=DateFormat.getTimeInstance();//时间**获取时间格式化器**
        String timeDF= dF.format(times);
        DateFormat dDF=DateFormat.getDateInstance();//日期**获取日期格式化器**
        String dateDF= dDF.format(times);
        DateFormat tDF=DateFormat.getDateTimeInstance();//时间日期**获取时间日期格式化器**
        String tDf=tDF.format(times);
        System.out.println(timeDF+"\n"+dateDF+"\n"+tDf);
        System.out.println("3-------------------------------------------------------------------------------------------");
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("纪年"+calendar.get(0));
        System.out.println("年"+calendar.get(1));//也可以写成System.out.println(calendar.get(Calendar.YEAR));
        System.out.println("月"+calendar.get(2)+1);//0-11System.out.println(calendar.get(Calendar.MONTH));
        System.out.println("年的周"+calendar.get(3));
        System.out.println("月的周"+calendar.get(4));
        System.out.println("月的天"+calendar.get(5));//System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("年的天"+calendar.get(6));
        System.out.println("周的天"+calendar.get(7));
        System.out.println("月里的星期"+calendar.get(8));
        System.out.println("上午下午AM_PM"+calendar.get(9));
        System.out.println("小时"+calendar.get(10));//System.out.println(calendar.get(Calendar.HOUR));
        System.out.println("24进制的小时"+calendar.get(11));
        System.out.println("分钟"+calendar.get(12));//System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println("秒"+calendar.get(13));//System.out.println(calendar.get(Calendar.SECOND));
        System.out.println("毫秒"+calendar.get(14));
        System.out.println("时区偏移量"+calendar.get(15));
        System.out.println("4-------------------------------------------------------------------------------------------");
        calendar.set(2022, 06, 19, 15, 40, 0);//也可以calendar.set(1, 2022);
                                                                                        //		calendar.set(Calendar.MONTH, 06);
        System.out.println(calendar.get(1));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        Date date = calendar.getTime();//将calendar（抽象类）转为Date
        //Date的getTime（）是将Date转为时间戳 eg：long time = date.getTime();
        long timeInMillis = calendar.getTimeInMillis();//将calendar转为时间戳 也可以：long time2 = calendar.getTime().getTime();
        System.out.println("一年中一共多少周：" + calendar.getWeeksInWeekYear());

        System.out.println("5-------------------------------------------------------------------------------------------");
        Date nDate=new Date(2021,6,6);
        nDate.setTime(0);
        System.out.println(nDate);
        
    }
}
