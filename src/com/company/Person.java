package com.company;


import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int salary;
    private int age;
    private String sex;
    private String area;
//    private List<Integer> luckyNum = new ArrayList<>();
    private List<Integer> luckyNum;

    public List<Integer> getLuckyNum() {
        return luckyNum;
    }

    public void setLuckyNum(List<Integer> luckyNum) {
        this.luckyNum = luckyNum;
    }

    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void work(String name) {
        System.out.println(name + " work");
    }
}
