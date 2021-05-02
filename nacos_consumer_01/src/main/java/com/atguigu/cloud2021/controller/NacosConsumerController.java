package com.atguigu.cloud2021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/4 10:14 周四
 */
@RestController
@RequestMapping("/nacos")
public class NacosConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://nacos-provide/nacos/helloNacos";

    @GetMapping("/test1")
    public String test1() {
        return restTemplate.getForObject(url, String.class);
    }
}
