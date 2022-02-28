package com.fc.bean;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String info;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String gender, String info) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
