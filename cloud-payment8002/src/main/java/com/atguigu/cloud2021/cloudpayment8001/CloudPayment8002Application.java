package com.atguigu.cloud2021.cloudpayment8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudPayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudPayment8002Application.class, args);
    }

}
