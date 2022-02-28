package 基础实例.集合.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<String, Object> student = new HashMap<>();

        student.put("id", 44);//（键,值）
        student.put("name", "老朱");
        student.put("age", 19);
        student.put("gender", '♀');

        Map<String, Object> info = new HashMap<>();
        info.put("height", 168);
        info.put("weight", 110);
        info.put("QQ", 120);
        info.put("tel", 10086);
        info.put("address", "7-220");

        student.putAll(info);//集合后添加集合

        System.out.println(student);
        System.out.println("******************************************************************");
        HashMap<Student,Object> students=new HashMap<>();//这里向键传入一个自定义类Student
        students.put(new Student("梦歌", 19), "唱歌");
        students.put(new Student("品品", 18), "睡觉");
        students.put(new Student("老张", 18), "学习");
        students.put(new Student("老张", 18), "学习");
        students.put(new Student("老朱", 19), "易烊千玺");

        Set<Entry<Student,Object>> entrySet = students.entrySet();//去除重复部分
        System.out.println(entrySet);
        /*for (Entry<Student,Object> entry : entrySet) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }*/
    }
}
