package com.atguigu.cloud2021.cloudconsumerorder80.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 桂贤松
 * @project_name：cloud-consumer-order80
 * @product_name：IntelliJ IDEA
 * @date：2021/1/7 15:01 周四
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
