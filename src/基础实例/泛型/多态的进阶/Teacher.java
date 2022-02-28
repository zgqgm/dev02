package 基础实例.泛型.多态的进阶;

public class Teacher {
    private String name;
    private int age;
    @Override
    public String toString() {
        return "Teacher [name=" + name + ", age=" + age + "]";
    }

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
