package com.concentration;

import com.concentration.entity.UserInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EnableCaching
@SpringBootApplication
//如果删掉@SpringBootApplication,会报错
//Unable to start ServletWebServerApplicationContext
// due to missing ServletWebServerFactory bean.
//即因为没有 ServletWebServerFactory，而导致无法启动IOC容器。
//所以被传入的类要被 @SpringBootApplication 标注。

//这时一个组合注解
//包含
//他可以指定包扫描的根路径,解开注释会报冗余声明

////启动器启动时，扫描本目录以及子目录带有的webservlet注解的
@MapperScan("com.concentration.dao")
@ServletComponentScan
public class ConcentrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConcentrationApplication.class, args);
    }
}
