package com.lambda.sort;

import com.lambda.entity.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortOne {

    @Test
    public void testOne(){
        List<String> list = Arrays.asList("abc", "bbb", "ccc", "ddd");
        list.stream().sorted().forEach(e-> System.out.println(e));
    }

    @Test
    public void testTwo(){
        Student studentOne = new Student("刘备",22);
        Student studentTwo = new Student("关羽", 33);
        Student studentThree = new Student("张飞", 44);
        Student studentFive = new Student("利亚", 44);
        Student studentSix = new Student("卡鲁卡", 44);
        Student studentFour = new Student("曹操", 45);

        ArrayList<Student> students = new ArrayList<>();
        students.add(studentOne);
        students.add(studentTwo);
        students.add(studentThree);
        students.add(studentFour);
        students.add(studentFive);
        students.add(studentSix);

        students.stream().sorted((e1,e2)->{
//            return String.valueOf(e2.getAge()).compareTo(String.valueOf(e1.getAge()));
            return -3;
        }).forEach(e-> System.out.println(e));

        System.out.println("--------------------------------------------------------------------");

        students.stream().filter(e->e.getAge()==44).limit(2).forEach(e-> System.out.println(e));

        String[] strings = {"pipigui", "pip", "gxs", "gggg", "uuu","gxs","gxs"};
        Stream<String> strs = Arrays.stream(strings);
        long count = strs.count();
        System.out.println(count);
//        Stream<String> distinct = strs.distinct();
//        System.out.println(distinct.count());
    }
}
