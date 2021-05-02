package com.ip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IpPortApplication8083 {
    public static void main(String[] args) {
        SpringApplication.run(IpPortApplication8083.class, args);
    }

    @RequestMapping("/test8083")
    public String test8083() {
        return "test8083";
    }
}
