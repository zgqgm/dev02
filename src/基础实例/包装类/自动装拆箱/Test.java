package 基础实例.包装类.自动装拆箱;
//JDK1.5以后，简化了定义包装类的方式。
//自动把基本数据类型转成对应的包装类，
//省略new 加上构造方法。
public class Test {
    public static void main(String[] args) {
        // 获取一个Integer类型的对象
        //Integer num = new Integer(100);


        // 自动装箱，自动给int加了一层包装
        // 自动帮我们完成了基本数据类型到包装类的转换
        Integer num = 100;//过程如下：//Integer nu = Integer.valueOf(100);//赋值时将int转为Integer类型。
        num++;//过程如下：//nu = Integer.valueOf(nu.intValue() + 1);//运算时先将Integer转为int类型，运算后的结果再转为Integer类型。
        System.out.println(/*nu*/num);

        //自动拆箱：把包装类的包装给拆掉，将包装类转为基本数据类型（类似于自动装箱）。
        String string="拆箱";

        /**
         * IntegerCache
         *Integer的缓存
         *返回一个Integer对象，表示指定的int值。如果不需要新的Integer实例，通常应该优先使用该方法【valueOf】而不是构造函数Integer(int)，
         *因为通过缓存频繁请求的值，该方法可能会产生明显更好的空间和时间性能。
         *该方法将始终缓存范围为-128到127(包括-128到127)的值。(Byte的存储空间)
         */
        //笔试题：
        Integer num1 = 127;//缓存范围为-128到127，共能存255Integer对象。
        Integer num2 = 127;
        //Integer是引用数据类型，使用双等号比较的地址
        System.out.println(num1 == num2);//这里比较的都是第255个（127-（-128）），下标为127的Integer的对象。（即同一个对象）

        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println(num3 == num4);//这里比较的是Integer的对象的地址值（128超出里存储范围）
    }
}
