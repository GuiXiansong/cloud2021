package com.guixiansong.one.testone;

public class A {
    public static int A = 1;

    static {
        A = 2;
    }

    static class Son extends A {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
    }
}


