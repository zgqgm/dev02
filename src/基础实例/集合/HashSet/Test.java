package 基础实例.集合.HashSet;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Student> haSt=new HashSet<>();//无序不重复。
        haSt.add(new Student("小明",14));
        haSt.add(new Student("小红",12));
        haSt.add(new Student("小明",14));
        haSt.add(new Student("小张",14));
        haSt.add(new Student("小李",19));
        haSt.add(null);//可以有且只有一个null（有null是直接放到第一位）
        for (Student st:haSt){
            System.out.println(st);
        }
    }
}
