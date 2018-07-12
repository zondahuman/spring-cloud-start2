package com.abin.lee.cloud.service.hystrix;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Created by abin on 2018/7/12.
 */

@SpringBootApplication
@EnableDiscoveryClient // 通过eureka注册服务注册中心
public class HystrixCloudServiceApplication {

//    public static void main(String[] args) {
//        args = new String[1];
//        args[0] = "--spring.profiles.active=hystrix";
//        SpringApplication.run(HystrixCloudServiceApplication.class, args);
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixCloudServiceApplication.class).web(true).run(args);
    }

    /**
     * 使用fastjson做为json的解析器
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //	fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }
}