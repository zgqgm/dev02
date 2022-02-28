package 基础实例.拷贝.哈希码;

import java.util.Objects;

public class Students {
    private int age;
    private String name;
    private char sex;
    private int id;

    public Students(int age, String name, char sex, int id) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return age == students.age && sex == students.sex && id == students.id && Objects.equals(name, students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, sex, id);
    }
}
