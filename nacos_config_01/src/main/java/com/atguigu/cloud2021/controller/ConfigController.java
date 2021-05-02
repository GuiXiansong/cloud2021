package com.atguigu.cloud2021.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/4 13:17 周四
 */
@RefreshScope
@RestController
public class ConfigController {
/*    @Value("${nacos.config}")
    private String config;

    @RequestMapping("/getValue")
    public String getValue(){
        return config;
    }*/
}
