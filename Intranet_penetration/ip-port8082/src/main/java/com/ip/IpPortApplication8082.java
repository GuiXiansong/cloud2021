package com.ip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IpPortApplication8082 {
    public static void main(String[] args) {
        SpringApplication.run(IpPortApplication8082.class, args);
    }

    @RequestMapping("/test8082")
    public String test8082() {
        return "test8082";
    }
}
