package com.atguigu.cloud2021.cloudpayment8001.service;

import com.atguigu.cloud2021.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 桂贤松
 * @project_name：cloud2020
 * @product_name：IntelliJ IDEA
 * @date：2021/1/6 16:35 周三
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
