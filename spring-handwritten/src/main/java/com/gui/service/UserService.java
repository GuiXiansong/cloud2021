package com.gui.service;

import com.spring.GuiAutowired;
import com.spring.GuiBeanNameAware;
import com.spring.GuiComponent;
import com.spring.GuiInitializingBean;

@GuiComponent("userService")
//@GuiScope("prototype")
public class UserService implements GuiBeanNameAware, GuiInitializingBean {
    @GuiAutowired
    private OrderService orderService;

    private String beanName;
    
    public void test(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber()+",orderService:"+orderService);
        System.out.println(beanName);
    }

    @Override
    public void setBeanName(String name) {
        beanName=name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化：：：：：：");
    }
}
