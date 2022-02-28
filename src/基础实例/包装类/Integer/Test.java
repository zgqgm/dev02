package 基础实例.包装类.Integer;
/*
`Integer` 类（Integer的底层就是一个int值，并且是被final修饰。即Integer其实就是一个int放到了类中。）在对象中包装了一个基本类型 `int` 的值。`Integer`  类型的对象包含一个 `int` 类型的字段。
该类提供了多个方法，能在 `int` 类型和 `String` 类型之间互相转换，还提供了处理  `int` 类型时非常有用的其他一些常量和方法。
 */

/**
 *  基本数据类型    包装类
 *  byte          Byte
 *  short         Short
 *  int           Integer
 *  long          Long
 *  float         Float
 *  double        Double
 *  char         Character【字符、性格、特点、特征、人物、品质】
 *  boolean       Boolean
 *  1. 泛型中只能使用包装类
 *  2. 有时候我们要求成员变量不能有默认值
 *  3.方法参数是允许定义空值的
 */
public class Test {
    public static void main(String[] args) {
        Integer num = new Integer(100);

        System.out.println("将Integer转化为byte:" + num.byteValue());
        System.out.println("将Integer转化为short:" + num.shortValue());
        System.out.println("将Integer转化为int:" + num.intValue());
        System.out.println("将Integer转化为long:" + num.longValue());
        System.out.println("将Integer转化为double:" + num.doubleValue());

        System.out.println("转二进制：" + Integer.toBinaryString(100));
        System.out.println("转八进制：" + Integer.toOctalString(100));
        System.out.println("转十六进制：" + Integer.toHexString(100));

        System.out.println("最大值：" + Integer.MAX_VALUE);//int的最大值2^31-1
        System.out.println("最小值：" + Integer.MIN_VALUE);//int的最小值-2^31
        Integer num1 = new Integer(100);//这里虽然报错，但是可以运行。**将int转为Integer类型。**
        Integer num2 = new Integer("100");//这里虽然报错，但是可以运行。**将String转为Integer类型。**
        System.out.println(num1.getClass());
        System.out.println(num2.getClass());
        int num3 = num1.intValue();//将Integer转化为int类型。
        int num4 = Integer.parseInt("100");//将String转为int类型。
        Integer valueOf = Integer.valueOf(num4);//将int转化为Integer。
        Integer valueOf1= Integer.valueOf("100");//将String转化为Integer。
    }
}
