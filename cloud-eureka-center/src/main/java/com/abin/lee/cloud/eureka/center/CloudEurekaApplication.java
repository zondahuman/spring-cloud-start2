package com.abin.lee.cloud.eureka.center;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by abin on 2018/7/12.
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaApplication {

//    public static void main(String[] args) {
//        args = new String[1];
//        args[0] = "--spring.profiles.active=simple2";
//        SpringApplication.run(CloudEurekaApplication.class, args);
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudEurekaApplication.class).web(true).run(args);
    }


}