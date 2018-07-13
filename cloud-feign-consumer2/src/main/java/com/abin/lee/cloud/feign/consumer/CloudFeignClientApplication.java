package com.abin.lee.cloud.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudFeignClientApplication {

    /**
     *  http://localhost:3333/add
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudFeignClientApplication.class, args);
    }

}



