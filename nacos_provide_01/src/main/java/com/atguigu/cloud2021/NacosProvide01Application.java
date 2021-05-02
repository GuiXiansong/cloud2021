package com.atguigu.cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/4 9:48 周四
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvide01Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvide01Application.class, args);
    }
}
