package com.atguigu.cloud2021.cloudpayment8001.controller;

import com.atguigu.cloud2021.cloudpayment8001.service.PaymentService;
import com.atguigu.cloud2021.entities.CommonResult;
import com.atguigu.cloud2021.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 桂贤松
 * @project_name：cloud2020
 * @product_name：IntelliJ IDEA
 * @date：2021/1/6 16:39 周三
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String portValue;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功,port:"+portValue,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("**************************************************************");
        log.info("______________________________________________________________________");
        log.info("---------------------------------------------------------------------");
        log.info("查到的记录为："+payment);
        if (null != payment){
            return new CommonResult(200,"查询成功,port:"+portValue,payment);
        }else {
            return new CommonResult(444,"无查询记录,ID为"+id,null);
        }
    }
}
