package 基础实例.集合.Comparator;
import java.util.Comparator;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        // 自定义的年龄比较器
        Comparator<Student> ageComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Comparator<Student> idComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        };

        // 既要比较id又要比较年龄
        Comparator<Student> idAndAgeComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getId() == o2.getId()) {
                    return o1.getAge() - o2.getAge();
                }

                return o1.getId() - o2.getId();
            }
        };

        TreeSet<Student> students = new TreeSet<>(idAndAgeComparator);

        students.add(new Student(4, "美琪", 12));
        students.add(new Student(1, "阿衰", 19));
        students.add(new Student(2, "美雪", 11));
        students.add(new Student(1, "阿衰", 20));
        students.add(new Student(5, "小龙", 13));
        students.add(new Student(1, "阿衰", 18));
        students.add(new Student(3, "大脸妹", 17));

        for (Student student : students) {
            System.out.println(student);
        }
    }

}
