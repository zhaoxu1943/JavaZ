package com.concentration.config;


import com.concentration.core.ProjectConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger-ui配置类
 * @author zhaoxu
 * @className SwaggerConfig
 * @date 2020/4/26 9:09
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //添加BASE_PACKAGE,swagger进行自动扫描
                .apis(RequestHandlerSelectors.basePackage(ProjectConstant.BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JavaConcentration")
                .description("Restful接口文档")
                .version("1.0")
                .build();
    }

}