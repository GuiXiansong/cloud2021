package com.atguigu.cloud2021;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/2/4 14:35 周四
 */
public class SampleClient {
    public static void main(String[] args) throws NacosException {
        //nacos地址
        String serverAddr = "127.0.0.1:8848";
        //Data ID
        String dataId = "nacos-config-example.properties";
        //Group
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
    }

}
