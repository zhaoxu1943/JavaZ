package com.concentration.config;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Spring 5.0中extends WebMvcConfigurerAdapter被弃用
 * Spring 5.0后，WebMvcConfigurerAdapter被废弃，取代的方法有两种：
 *
 * 1.implements WebMvcConfigurer（官方推荐）
 *
 * 2.extends WebMvcConfigurationSupport
 *
 * 这里实现WebMvcConfigurer接口导致了FastJsonConverter时间格式化的失效,重新继承WebMvcConfigurationSupport即可 TODO 探究原理
 * 拦截器中，只能有一个类集成WebMvcConfigurationSupport,
 * 出现多个类集成WebMvcConfigurationSupport时，配置是不生效的
 * Spring MVC 配置
 * @author zhaoxu
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final Logger logger = LoggerFactory.getLogger(com.concentration.config.WebMvcConfig.class);
    /**
     * 当前激活的配置文件
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    @Value("${spring.profiles.active}")
    private String env;


    /**
     * 使用阿里 FastJson 作为JSON MessageConverter
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        //保留空的字段
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        //fastJson全局配置输出时间的格式
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
        //SerializerFeature.WriteNullNumberAsZero//Number null -> 0
        // 按需配置，更多参考FastJson文档哈

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        converters.add(converter);
    }


    /**
     * //解决跨域问题
     * @author zhaoxu
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE","OPTIONS")
                .maxAge(3600);
    }




    /**
     * 重写 addResourceHandlers,为swagger-ui添加拦截 //todo 探究原理
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
