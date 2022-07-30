package com.test;

import com.pojo.Student;
import com.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    @Test
    public void testOne(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("LifeCycleContext.xml");
        User user1 = ioc.getBean("user1", User.class);
        User user2 = ioc.getBean("user1", User.class);
        System.out.println("多例:" + "对象一：" + user1 + "对象二：" + user2);

        User user3 = ioc.getBean("user2", User.class);
        User user4 = ioc.getBean("user2", User.class);
        System.out.println("单例:" + "对象一：" + user3 + "对象二：" + user4);
    }

    @Test
    public void testTwo(){
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("LifeCycleContext.xml");
        ioc.getBean("user3",User.class);
        ioc.close();
    }


    @Test
    public void testFactory(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factorybean.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
