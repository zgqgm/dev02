package 基础实例.泛型.多态的进阶;

public class Test {
    public static void main(String[] args) {
        School school=new School();
        school.showclass(new Grade<Student>(new Student("小明",21)));
        school.showclass(new Grade<Teacher>(new Teacher("小红",20)));
    }
}
