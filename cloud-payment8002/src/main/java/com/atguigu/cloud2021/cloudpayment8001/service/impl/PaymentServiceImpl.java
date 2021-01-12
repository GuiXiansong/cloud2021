package com.atguigu.cloud2021.cloudpayment8001.service.impl;

import com.atguigu.cloud2021.cloudpayment8001.dao.PaymentDao;
import com.atguigu.cloud2021.cloudpayment8001.service.PaymentService;
import com.atguigu.cloud2021.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 桂贤松
 * @project_name：cloud2020
 * @product_name：IntelliJ IDEA
 * @date：2021/1/6 16:36 周三
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
