package com.othertest;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void eat1() {
        System.out.println("吃了------------显示");
    }

    private void eat2() {
        System.out.println("吃了------------隐藏");
    }

    public void eat3(String food) {
        System.out.println("吃了" + food);
    }
}
