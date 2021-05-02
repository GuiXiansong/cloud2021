package com.othertest;

import lombok.Data;

@Data
public class Man {
    private String name;
    private int age;

    public void eat() {
        System.out.println("我是Man方法");
    }

    private void play() {
        System.out.println("play方法,哈哈哈哈");
    }
}
