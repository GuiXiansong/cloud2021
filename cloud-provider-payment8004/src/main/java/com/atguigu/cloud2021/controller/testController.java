package com.atguigu.cloud2021.controller;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/1/15 10:03 周五
 */
@RestController
@Log
@RequestMapping("/test")
public class testController {

    @Value("server.port")
    private String serverPort;

    @GetMapping("/getZookeeperInfo")
    public String getZookeeperInfo(){
        return "sprigncloud with zookeeper "+serverPort+ UUID.randomUUID().toString();
    }

    @GetMapping("/get")
    public void get(){
        log.info("---------------------------------------get-------------------------------------------");
    }
}
