package com.practice.spring.IOC;

import com.google.common.annotations.VisibleForTesting;
import com.practice.spring.IOC.MyBeans.POJO.MySpringBean;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhaoxu
 * @className SpringBeanFactory
 * @projectName JavaConcentration

 * @date 3/18/2020 4:28 PM
 */
public class SpringBeanFactory {
    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        //这里通过bean的name属性去配置文件中找
        //MySpringBean mySpringBean  = (MySpringBean) beanFactory.getBean("myspringbean");
        //这里通过class对象去找
        //MySpringBean mySpringBean  = (MySpringBean) beanFactory.getBean(MySpringBean.class);
        //还可以通过name和class去找
        MySpringBean mySpringBean  = (MySpringBean) beanFactory.getBean("myspringbeancd",MySpringBean.class);
        //获取实例调用
        System.out.println(beanFactory.getBeanClassLoader());
        mySpringBean.getStr();
    }
}
