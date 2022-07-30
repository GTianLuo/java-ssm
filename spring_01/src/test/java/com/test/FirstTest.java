package com.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.pojo.HelloWorld;
import com.pojo.Person;
import com.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.SQLException;

public class FirstTest {
    @Test
    public void testHelloWorld(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据Bean的Id获取IOC容器创建的Bean对象
        HelloWorld helloWord = (HelloWorld)ioc.getBean("HelloWord");
        helloWord.sayHello();
    }

    @Test
    public void testNewStudent(){
        //获取IOC容器
        ApplicationContext ioc =new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据Bean的Id获取IOC容器帮助创建的Bean对象
        //IOC底层通过反射的方式调用无参构造实例化对象
        //通过id获取bean对象
        //Student student = (Student) ioc.getBean("student");
        //通过Class获取bean对象
        //Student student = ioc.getBean(Student.class);
        //通过接口来获取bean对象
        Person person = ioc.getBean(Person.class);
        //Student student = ioc.getBean("student", Student.class);
        System.out.println(person);
    }
    @Test
    public void testDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = ioc.getBean("student2", Student.class);
        System.out.println(student1);

        Student student2 = ioc.getBean("student3", Student.class);
        System.out.println(student2);

        Student student3 = ioc.getBean("student4", Student.class);
        System.out.println(student3);
    }

    @Test public void testDI2(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student5 = ioc.getBean("student5", Student.class);
        Student student6 = ioc.getBean("student6", Student.class);
        Student student7 = ioc.getBean("student7", Student.class);

        System.out.println(student5);
        System.out.println(student6);
        System.out.println(student7);
    }

    @Test
    public void TestDI3(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student9 = ioc.getBean("student10", Student.class);
        System.out.println(student9 );
    }

    @Test
    public void testDruidDataSource() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
