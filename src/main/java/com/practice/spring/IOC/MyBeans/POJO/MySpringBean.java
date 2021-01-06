package com.practice.spring.IOC.MyBeans.POJO;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author zhaoxu
 * @className MySpringBean
 * @projectName JavaConcentration

 * @date 3/18/2020 4:25 PM
 */
public class MySpringBean implements BeanFactoryPostProcessor {

    public void getStr() {
        System.out.println("Hello BeanS! Im POJO!");
    }


    //当一个Bean实现了BeanFactoryPostProcessor,初始化时会调用这个method
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("bean初始化时调用了!");
    }
}
