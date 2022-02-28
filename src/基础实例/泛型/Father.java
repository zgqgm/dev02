package 基础实例.泛型;

public class Father implements Compare<Father>{
    private String name;
    private int age;
    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Father father) {
        return this.age-father.age;
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
