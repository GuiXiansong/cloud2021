package com.atguigu.cloud2021.cloudpayment8001.dao.db2;

import com.atguigu.cloud2021.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 桂贤松
 * @project_name：cloud2020
 * @product_name：IntelliJ IDEA
 * @date：2021/1/6 11:14 周三
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
