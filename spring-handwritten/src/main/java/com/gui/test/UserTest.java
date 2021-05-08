package com.gui.test;

import java.lang.reflect.Field;

public class UserTest {
    public static void main(String[] args) throws IllegalAccessException {
        Class<User> clazz = User.class;
        User user = new User("皮皮龟", "哈哈哈哈");
        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println(declaredField.getName());
            //将private属性的字段设置为可见
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(user));
        }
    }
}
