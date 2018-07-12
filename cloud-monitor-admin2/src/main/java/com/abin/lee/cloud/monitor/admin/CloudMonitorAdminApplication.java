package com.abin.lee.cloud.monitor.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by abin on 2018/7/12.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class CloudMonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMonitorAdminApplication.class, args);
    }


}