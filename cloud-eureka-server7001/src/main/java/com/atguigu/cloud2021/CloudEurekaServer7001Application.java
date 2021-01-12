package com.atguigu.cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/1/8 10:41 周五
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer7001Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7001Application.class,args);
    }
}
