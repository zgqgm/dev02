package 基础实例.反射;

public class Dog {
    private String name;
    public int age;

    public void eat() {
        System.out.println("狗吃狗粮");
    }

    public void run() {
        System.out.println("遛狗");
    }

    public Dog() {
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
        return "Dog [name=" + name + ", age=" + age + "]";
    }
}
