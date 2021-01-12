package com.atguigu.cloud2021.cloudpayment8001.dao.db1;

import com.atguigu.cloud2021.cloudpayment8001.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/1/12 16:26 周二
 */
@Mapper
public interface Db1Dao {
    List<Dept> getDepts();
}
