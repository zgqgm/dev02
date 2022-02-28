package 基础实例.API;

import java.util.Objects;

public class Demo_1 {
    String name;
    byte age;
    int ID;
    char sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo_1 demo_1 = (Demo_1) o;
        return age == demo_1.age && ID == demo_1.ID && sex == demo_1.sex && name.equals(demo_1.name);
    }


    public Demo_1(String name, byte age, int ID, char sex) {

    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Demo_1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ID=" + ID +
                ", ID=" + sex+
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
