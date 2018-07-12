package com.abin.lee.spring.cloud.config.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer // 激活该应用为配置文件服务器：读取远程配置文件，转换为rest接口服务
@EnableEurekaClient // 配置本应用将使用服务注册和服务发现
public class SpringCloudConfigApplication {

//    public static void main(String[] args) {
//        args = new String[1];
//        args[0] = "--spring.profiles.active=gitsimple2";
//        SpringApplication.run(SpringCloudConfigApplication.class, args);
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudConfigApplication.class).web(true).run(args);
    }
}