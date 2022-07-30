package com.test;

import com.pojo.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class autoTest {
    @Test
    public void testByType(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController controller = ioc.getBean(UserController.class);
        controller.saveUser();
    }
}
