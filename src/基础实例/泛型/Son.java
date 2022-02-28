package 基础实例.泛型;

public class Son implements Compare<Son>{
    private String name;
    private int age;
    public Son(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Son son) {
        return this.age-son.age;
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
