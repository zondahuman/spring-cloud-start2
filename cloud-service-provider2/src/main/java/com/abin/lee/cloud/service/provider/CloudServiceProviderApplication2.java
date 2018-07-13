package com.abin.lee.cloud.service.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by abin on 2016/12/9.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudServiceProviderApplication2 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudServiceProviderApplication2.class).web(true).run(args);
    }

}
