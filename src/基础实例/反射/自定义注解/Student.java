package 基础实例.反射.自定义注解;

public class Student {
    @Nickname(name = "高山流水")
    private String name;
    public int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void eat() {
        System.out.println("吃、喝、睡、玩");
    }

    public void run() {
        System.out.println("刷跑");
    }

    public Student() {
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

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
