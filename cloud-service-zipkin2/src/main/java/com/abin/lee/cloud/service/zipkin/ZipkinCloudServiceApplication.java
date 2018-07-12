package com.abin.lee.cloud.service.zipkin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by abin on 2018/7/12.
 */

@SpringBootApplication
@EnableDiscoveryClient // 通过eureka注册服务注册中心
public class ZipkinCloudServiceApplication {

//    public static void main(String[] args) {
//        args = new String[1];
//        args[0] = "--spring.profiles.active=zipkin";
//        SpringApplication.run(ZipkinCloudServiceApplication.class, args);
//    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(ZipkinCloudServiceApplication.class).web(true).run(args);
    }


}
