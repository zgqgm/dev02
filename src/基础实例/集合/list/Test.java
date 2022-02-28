package 基础实例.集合.list;

import java.util.ArrayList;//ArrayList的底层，内部就是一个数组
import java.util.Arrays;
import java.util.List;//List 接口的大小可变数组的实现。实现了所有可选列表操作，并允许包括null在内的所有元素。
// 除了实现List接口外，此类还提供一些方法来操作内部用来存储列表的数组的大小。（此类大致上等同于Vector类，除了此类是不同步的。）
//特点：增删慢，查询快。
public class Test {
    public static void main(String[] args) {
        List<String> hobby = new ArrayList<>();
        hobby.add("刷抖音");
        hobby.add("睡觉");
        hobby.add("男");
        hobby.add("打游戏");
        hobby.add("羽毛球");
        hobby.add("干饭");
        hobby.add("睡觉");
        // 容器中的第2个位置，插入一个元素
        hobby.add(2, "跳舞");
        // 遍历
        for (String temp : hobby) {
            System.out.println(temp);
        }
        System.out.println("------------");
        //再创建一个列表
        List<String> list = new ArrayList<>();
        list.add("听歌");
        list.add("看书");
        list.add("敲代码");
        //讲参数集合添加到当前集合指定下标位置
        /*hobby.addAll(2, list);
        for (String temp : hobby) {
            System.out.println(temp);
        }*/
        hobby.remove(1);//删除当前集合指定下标对应的元素。
        hobby.set(2,"女");//用指定元素替换当前集合指定下标对应的元素。
        System.out.println("get方法获取到的元素：" + hobby.get(1));
        List<String> subList = hobby.subList(1, 4);//对当前集合截取指定长度。
        System.out.println(subList);
        System.out.println("indexOf，获取第一个下标：" + hobby.indexOf("睡觉"));
        System.out.println("lastIndexOf，获取第一个下标：" + hobby.lastIndexOf("睡觉"));
    }
}
