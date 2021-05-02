package com.guixiansong.one;

/**
 * @author 桂贤松
 * @date 2021/4/25
 */
public class TestThree {
    public static int num = 1;

    static {
        num = 2;
        number = 20;
    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(num);
        System.out.println(number);
    }
}
