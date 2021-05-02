package com.atguigu.cloud2021.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/4 11:09 周四
 */
@RefreshScope
@RestController
@RequestMapping("/sample")
@Log
public class SampleController {
/*    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    @GetMapping("/getUserName")
    public String getUserName(){
        log.info("--------------"+userName);
        return userName;
    }*/
}
