package com.gui.service;

import com.spring.GuiBeanPostProcessor;
import com.spring.GuiComponent;

@GuiComponent
public class GuiXiansongBeanPostProcessor implements GuiBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println(this.getClass().getName()+":::::::"+"初始化前");
        if (beanName.equals("userService")) {
            ((UserService)bean).setBeanName("屁屁桂太帅了");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后");
        return bean;
    }
}
