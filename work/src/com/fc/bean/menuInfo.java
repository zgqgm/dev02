package com.fc.bean;

public class menuInfo {
    private int id;
    private String name;
    private String cut;

    public menuInfo() {
    }

    public menuInfo(int id, String cut, String name) {
        this.id = id;
        this.name = name;
        this.cut = cut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    @Override
    public String toString() {
        return "menuInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cut='" + cut + '\'' +
                '}';
    }
}
