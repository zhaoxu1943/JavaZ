package com.concentration.entity;

/**
 * @ClassName CustomInfo
 * @Description 配置文件实体类
 * @Author zhaoxu
 * @Date 2019/10/14 14:54
 * @Version 1.0
 **/
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "custom.info")
public class CustomInfo {
    private String  applicationPropertiesType ;
    private String databaseType;

    public String getApplicationPropertiesType() {
        return applicationPropertiesType;
    }

    public void setApplicationPropertiesType(String applicationPropertiesType) {
        this.applicationPropertiesType = applicationPropertiesType;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }
}
