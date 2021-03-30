package com.atguigu.cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/1/15 9:49 周五
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8004Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004Application.class,args);
    }
}
