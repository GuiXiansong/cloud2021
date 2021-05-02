package com.othertest.pojo;

import org.openjdk.jol.info.ClassLayout;

public class ThreadTest {
    private static Object object = new Object();

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
            System.out.println("哈哈哈哈哈");
        }
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }

    }
}
