package com.atguigu.cloud2021.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 桂贤松
 * @project_name：cloud2020
 * @product_name：IntelliJ IDEA
 * @date：2021/1/6 10:31 周三
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
