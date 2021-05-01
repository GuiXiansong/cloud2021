package com.ip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IpPortApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(IpPortApplication8080.class,args);
    }

    @RequestMapping("/test8080")
    public String test8080(){
        return "test8080";
    }
}
