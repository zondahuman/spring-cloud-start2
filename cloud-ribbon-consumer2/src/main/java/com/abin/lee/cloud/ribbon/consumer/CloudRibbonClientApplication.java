package com.abin.lee.cloud.ribbon.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CloudRibbonClientApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     *  http://localhost:3333/add
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonClientApplication.class, args);
    }


}



