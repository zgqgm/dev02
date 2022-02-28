package 基础实例.集合.linkedList;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> llt=new LinkedList<>();
        llt.add("as");
        llt.addFirst("腐乳");
        llt.addLast("豆汁");
        for (String food : llt) {
            System.out.println(food);
        }
        llt.removeFirst();
        llt.removeLast();
        for (String food : llt) {
            System.out.println(food);
        }
        System.out.println("---------------------------------------------------------");
        LinkedList<Student> st=new LinkedList<>();
        st.add(new Student("刘欣",23));//创建匿名对象（只使用一次，随机地址）
        st.add(new Student("王梦康",21));
        st.add(new Student("王泽鹏",22));
        st.add(new Student("贾晓东",20));
        //st.remove(new Student("王梦康",21));//****************链表remove指定元素删除需要在自定义类中重写equals和hashCode方法*************
        st.remove(1);//***************************链表remove指定下标删除则没有上面的删除麻烦（但各有优点！！）*********************
        for (Student student:st){
            System.out.println(student);
        }

    }
}
