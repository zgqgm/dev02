package 基础实例.泛型.泛型多态;

public class Name {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Name(String name, int age) {
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
