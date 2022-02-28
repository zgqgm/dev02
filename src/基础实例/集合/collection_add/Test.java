package 基础实例.集合.collection_add;

import java.util.ArrayList;
import java.util.Collection;

/**
 * interface Collection<E>；Collection：集合结构中的根接口，往下延伸出各种功能的不一样的集合
 *      interface List<E>；List：列表，List集合作为Collection接口的子接口，特点：元素的可重复的，有序的
 *          class ArrayList<E>；Vector：线程安全的动态数组，不要用，因为加了锁，速度太慢了，影响效率        ***重***
 *          class LinkedList<E>；ArrayList：作为List接口的实现类，可以创建对象，底层是一个动态数组，可变长数组，数组的长度是可以改变   ***重***
 *          class Vector<E>；LinkedList：link链接，底层是一个双向链表
 *      interface Set<E>；Set：无序列表。特点：元素是无序的，并且不可重复
 *         class HashSet<E>；HashSet：底层数据结构是一个哈希表，哈希表的存储和获取效率都非常高，hashCode是用来提高哈希表的效率。特点：不支持有序性操作，并且失去了元素的插入顺序信息。
 *         class TreeSet<E>；TreeSet：底层是一个红黑树，结构就是一个平衡二叉树，查询效率也很高，但是没有哈希表，支持有序操作，但是需要依赖比较的方式。
 */

public class Test {
    public static void main(String[] args) {
        Collection<String> food=new ArrayList<>();
        food.add("米");
        food.add("面");
        System.out.println(food.toString()+"\n1.*******************************************");
        Collection<String> drink=new ArrayList<>();
        drink.add("凉白开");
        drink.add("红牛");
        drink.add("脉动");
        drink.remove("凉白开");//删除“凉白开”
        food.addAll(drink);
        System.out.println(food.toString());
        System.out.println(food+"\n2.******************************************************");
        Collection<Integer> f1=new ArrayList<>();
        f1.add(1);f1.add(2);f1.add(3);f1.add(4);f1.add(5);
        Collection<Integer> f2=new ArrayList<>();
        f2.add(4);f2.add(5);f2.add(1);f2.add(8);f2.add(9);
        //f1.removeAll(f2);//删除当前于指定集合的交际部分。
        //System.out.println(f1+"\n3.******************************************************");
        /*f1.clear();
        System.out.println(f1);*/
        System.out.println("4.******************************************************\n集合中元素的个数：" +f2.size());
        System.out.println("是否为空：" +f2.isEmpty());
        System.out.println("是否包含：" + f1.contains("烤鱿鱼"));
        Collection<Integer> f3=new ArrayList<>();
        f3.add(1);f3.add(2);f3.add(3);
        System.out.println("是否包含全部的元素：" + f1.containsAll(f3));
        Object[] arrays=f3.toArray();//集合转为Object类型数组
        for (Object i:arrays){//增强For
            System.out.println(i);
        }
        /*//34-37具体化
        String[] string=new String[f2.size()];//*****************这里无法运行
        String[] arrays=f2.toArray(string);//***string与arrays是同一个数组
        for(int i=0;i<arrays.length;i++){
        System.out.println(arrays[i]);
        }*/
    }
}
