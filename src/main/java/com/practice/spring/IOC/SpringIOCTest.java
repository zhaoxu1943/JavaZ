package com.practice.spring.IOC;

import com.practice.spring.IOC.MyBeans.POJO.MySpringBean;
import com.practice.spring.IOC.MyBeans.myComponent.Impl.MessageServiceImpl;
import com.practice.spring.IOC.MyBeans.myComponent.MessageService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashMap;

/**
 * @ClassName Person
 * @Description spring 通过配置文件创建beans
 * @Author zhaoxu
 * @Date 2019/10/24 11:00
 * @Version 1.0
 **/
public class SpringIOCTest {




    public static void main(String[] args) {
        //创建spring容器,xml方式
        //在classpath中寻找xml,根据xml来构建ApplicationContext
        //Application启动过程中,会负责创建实例Bean,往各个Bean中注入依赖等
        ApplicationContext applicationContext = new     ClassPathXmlApplicationContext("beans.xml");




        //这个filesystemXmlApplication需要一个xml配置文件在系统中的路径,其他的和ClassPathXmlapplication基本上一样
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:beans.xml");


        //BeanFactory,生产bean的工厂,负责生产和管理各个Bean实例
        //ApplicationContext继承了ListableBeanFactory,可以说ApplicationContext其实就是一个BeanFactory

        //MessageService messageService = applicationContext.getBean(MessageService.class);
        //System.out.println(messageService.getMessage());


//        //get Bean Factory
//        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
//
//        //创建spring容器, Annotation ways
//        //ApplicationContext context1 = new AnnotationConfigApplicationContext();
//        HashMap hashMap =new HashMap(15);
//        System.out.println("ApplicationContext启动成功");
//
        //测试xml方式 bean 的注入
        MySpringBean mySpringBean = (MySpringBean) applicationContext.getBean("myspringbeancd");
        mySpringBean.getStr();

        MessageServiceImpl messageService = (MessageServiceImpl)applicationContext.getBean("messageService");
        messageService.setMyspringbeancd(mySpringBean);

       messageService.getMyspringbeancd().getStr();
//
//        // getBean():requiredType type the bean must match; can be an interface or superclass
//
//

    }

    }


