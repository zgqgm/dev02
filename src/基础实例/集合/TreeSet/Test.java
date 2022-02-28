package 基础实例.集合.TreeSet;

import java.util.TreeSet;
import java.util.Comparator;
public class Test {
    public static void main(String[] args) {
        TreeSet<Student> tst=new TreeSet<>();//有序不可重复。（自定义类要实现Comparable接口）
        tst.add(new Student("王梦康",18));
        tst.add(new Student("王泽鹏",28));
        tst.add(new Student("张龙源",17));
        tst.add(new Student("贾晓东",19));
        tst.add(new Student("刘欣",18));
        for (Student st:tst){
            System.out.println(st);
        }
        //匿名内部类
        /*Comparator<Teacher> ct=new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getAge()- o2.getAge();
            }
        };*///建议用Lambda的方法。
        TreeSet<Teacher> tea=new TreeSet<>(/*ct*/ (o1, o2) -> o1.getAge()- o2.getAge());//Lambda表达式
        tea.add(new Teacher("周某人",40));
        tea.add(new Teacher("马保国",61));
        tea.add(new Teacher("罗翔",39));
        tea.add(new Teacher("郭老师",50));
        for (Teacher te:tea){
            System.out.println(te);
        }

    }
}
