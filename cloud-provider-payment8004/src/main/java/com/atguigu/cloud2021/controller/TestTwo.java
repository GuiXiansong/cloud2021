package com.atguigu.cloud2021.controller;

public class TestTwo {
    public static void main(String[] args) {
/*        long a=2;
        long b=2;
        Long c=3L;
        Long d=3L;
        System.out.println(a==b);
        System.out.println(c==d);

        Long aa=new Long(22);
        Long bb=new Long(22);
        System.out.println(aa==bb);*/
        final int num=1;
        Converter<Integer,String> s=(param)-> System.out.println(String.valueOf(param+num));
        s.convert(343);

        Converter<String,String> converter=(param)->{
            int a=2;
            int b=3;
            System.out.println(param+num);
        };
    }

    public interface Converter<T1,T2>{
        void convert(int i);
    }
}


