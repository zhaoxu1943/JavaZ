package com.practice.spring.IOC;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Person
 * @Description spring 通过配置文件创建beans
 * @Author zhaoxu
 * @Date 2019/10/24 11:00
 * @Version 1.0
 **/
@ComponentScan("com.practice.spring.IOC")
public class SpringIOCTestAnnotation {

    public static void main(String[] args) {
        //创建spring容器, Annotation ways,基于注解来使用
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        System.out.println("ApplicationContext启动成功");



    }

    }


