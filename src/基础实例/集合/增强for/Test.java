package 基础实例.集合.增强for;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> coll=new ArrayList<>();
        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("d");
        coll.add("e");
        for (String num:coll){//增强for来遍历。
            System.out.println(num);
        }
        coll.add(2,"下标插入");
        String[] array= coll.toArray(new String[0]);
        System.out.println("----------------------------------------------------\n"+array[2]);
        /*for (String num:coll){//增强for来遍历。
            System.out.println(num);
        }*/
        System.out.println("-------------------删除集合中的所有元素-----------------------------------");
        Iterator<String> it= coll.iterator();//获取迭代器
        int i=0;
        while (it.hasNext()){//boolean 判断是否还有下一个元素
            // 获取下一个元素
            String next = it.next();
            System.out.println(next+i);//输出将被删除的元素
            // 移除获取到的元素
            it.remove();
            i++;
        }
        /*for (String num:coll){//增强for来遍历。
            System.out.println(num);
        }*/
        System.out.println("-------------------增强for来遍历自定义类-----------------------------------");
        //Iterable表示支持增强for循环，Iterator表示迭代器。Iterable是JDK1.5的特性；Iterator是JDK1.2的特性。
        /**
         * 必须：（eg：Home类）
         * 1. 必须实现Iterable接口
         * 2. 必须重写iterator()
         * 3. 必须返回一个实现了Iterator接口的实现类对象
         * 4. 必须重写hashNext()、next()
         */
        Home home=new Home();
        for (Person person:home){
            System.out.println(person);
        }
    }
}
