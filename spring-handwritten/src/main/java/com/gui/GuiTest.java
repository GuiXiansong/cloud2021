package com.gui;

import com.gui.config.AppConfig;
import com.gui.service.UserService;
import com.spring.GuiApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuiTest {
    private static Logger logger=LoggerFactory.getLogger(GuiTest.class);
    public static void main(String[] args) {
        GuiApplicationContext guiApplicationContext = new GuiApplicationContext(AppConfig.class);
//        System.out.println(guiApplicationContext.getBean("userService"));
//        logger.info(guiApplicationContext.getBean("userService").toString());
//        logger.info(guiApplicationContext.getBean("userService").toString());
//        logger.info(guiApplicationContext.getBean("userService").toString());
//        logger.error(guiApplicationContext.getBean("userService").toString());
//        logger.trace(guiApplicationContext.getBean("userService").toString());

        UserService userService = (UserService) guiApplicationContext.getBean("userService");
        System.out.println(userService);
        userService.test();
    }
}
