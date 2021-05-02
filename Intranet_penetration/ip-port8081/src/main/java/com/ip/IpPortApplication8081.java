package com.ip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IpPortApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(IpPortApplication8081.class, args);
    }

    @RequestMapping("/test8081")
    public String test8081() {
        return "test8081";
    }
}
