package com.abin.lee.cloud.zipkin.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

/**
 * Created by abin on 2018/7/12.
 */
@EnableEurekaClient // 配置本应用将使用服务注册和服务发现
@SpringBootApplication
@EnableZipkinServer // 启动Zipkin服务
public class ZipkinDashboardCloudApplication {

//    public static void main(String[] args) {
//        args = new String[1];
//        args[0] = "--spring.profiles.active=zipkin-http";
//        SpringApplication.run(ZipkinDashboardCloudApplication.class, args);
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZipkinDashboardCloudApplication.class).web(true).run(args);
    }

    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }

    /**
     * 使用fastjson做为json的解析器
     * @return
     */
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastConverter;
//        return new HttpMessageConverters(converter);
//    }
}