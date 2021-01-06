package com.concentration.controller;


import com.concentration.config.UserInfoConfiguration;
import com.concentration.entity.CustomInfo;
import com.concentration.entity.UserInfo;
import com.sun.xml.bind.v2.TODO;
import org.apache.catalina.core.ApplicationContext;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @ClassName ConfigController
 * @Description 读Springboot配置文件
 * @Author zhaoxu
 * @Date 2019/10/14 10:35
 * @Version 1.0
 **/
@RestController
public class ConfigController {

    //读取配置文件中的内容第一种
    // @Value 接生效的配置文件字段
    // 冒号 : 后面的是默认值 防止配置文件中没有时报错
    @Value("${spring.application.name:defaultName}")
    private String springApplicationName;

    @Value("${server.port:80}")
    private String serverPort;



    //读取配置文件方式第二种
    //@Autowired注入Environment
    //env.getProperty("key")获取
    @Autowired
    private Environment env;


    //读取配置文件第三种
    //可以为配置文件创建实体类 注入实体类
    @Autowired
    private CustomInfo customInfoProperties;

        //@GetMapping 是@RequestMapping(method = RequestMethod.GET)的缩写
        @GetMapping("/")
        public Map config () {
        Map configMap  = new LinkedHashMap();
        //第一种方式声明的私有成员变量直接使用
        configMap.put("springApplicationName",springApplicationName);
        configMap.put("serverPort",serverPort);
        //第二种方式,使用env.getProperty()方法
        configMap.put("databaseDriverClassName",env.getProperty("spring.datasource.driver-class-name"));
        configMap.put("datasourceUrl",env.getProperty("spring.datasource.url"));
        //第三种方式,为自定义的配置创建实体类,并对属性设置get/set,然后注入实体类
        configMap.put("applicationPropertiesType", customInfoProperties.getApplicationPropertiesType());
        configMap.put("databaseType", customInfoProperties.getDatabaseType());
        return configMap;
    }


    public void getUserInfo () {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(UserInfoConfiguration.class);
        UserInfo userInfo = (UserInfo) ctx.getBean("userBean");
        System.out.println(userInfo.getUserId());
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }


}
