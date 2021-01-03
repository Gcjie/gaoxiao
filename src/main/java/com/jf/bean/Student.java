package com.jf.bean;

public class Student {
    private String num;
    private String name;
    private String sex;
    private String major;
    private String stuClass;
    private String password;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Student(){

    }

    public Student(String num, String name, String sex, String major, String stuClass, String password) {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.stuClass = stuClass;
        this.password = password;
    }
}
