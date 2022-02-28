package com.fc.bean;

public class PUserInfo {
    private int id;
    private String nickname;
    private String face;
    private String gender;
    private String birthday;
    private String signature;

    public PUserInfo() {
    }

    public PUserInfo(int id, String nickname, String face, String gender, String birthday, String signature) {
        this.id = id;
        this.nickname = nickname;
        this.face = face;
        this.gender = gender;
        this.birthday = birthday;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "PUserInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", face='" + face + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
