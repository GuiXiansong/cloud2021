package com.lambda.match;

import com.lambda.entity.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestOne {

    @Test
    public void testOne(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("小红",11));
        students.add(new Student("小桂",22));
        students.add(new Student("小刚",33));

        boolean hong = students.stream().allMatch(e -> e.getName().equals("小红"));

        boolean gang = students.stream().anyMatch(e -> e.getName().equals("小刚"));
        System.out.println(hong);
        System.out.println(gang);
    }
}
