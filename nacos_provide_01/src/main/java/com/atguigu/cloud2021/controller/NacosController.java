package com.atguigu.cloud2021.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/4 9:51 周四
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @GetMapping("/helloNacos")
    public String helloNacos() {
        return "你好，nacos！";
    }
}
