package com.atguigu.cloud2021.cloudconsumerorder80.controller;

import com.atguigu.cloud2021.entities.CommonResult;
import com.atguigu.cloud2021.entities.Payment;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 桂贤松
 * @project_name：cloud-consumer-order80
 * @product_name：IntelliJ IDEA
 * @date：2021/1/7 15:04 周四
 */
@RestController
@Log
public class OrderController {
//    public static final String PAYMENT_URL="http://127.0.0.1:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_CREATE_URL="/payment/create";
    public static final String PAYMENT_GETPAYMENTBYID_URL="/payment/getPaymentById/";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("----------------------------------------------------------------");
        return restTemplate.postForObject(PAYMENT_URL+PAYMENT_CREATE_URL,payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info("__________________________");
        return restTemplate.getForObject(PAYMENT_URL+PAYMENT_GETPAYMENTBYID_URL+id,CommonResult.class);
    }
}
