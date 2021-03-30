package com.atguigu.cloud2021.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dingding")
public class DingdingTest {
    @RequestMapping("/dingdingTest")
    public String dingdingTest(){
        return "dingdingTest";
    }
}
