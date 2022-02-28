package 基础实例.fileIO流.自定义;

public class person {
    private int age;
    private String name;
    private int ID;
    private char gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    public person(){}
    public person(int age, String name, int ID, char gender) {
        this.age = age;
        this.name = name;
        this.ID = ID;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", ID=" + ID +
                ", gender=" + gender +
                '}';
    }
}
