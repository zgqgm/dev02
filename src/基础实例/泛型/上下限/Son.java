package 基础实例.泛型.上下限;

public class Son extends Father {
    private String name;
    private int age;

    public Son() {
    }

    @Override
    public String toString() {
        return "Son [name=" + name + ", age=" + age + "]";
    }

    public Son(String name, int age) {
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
