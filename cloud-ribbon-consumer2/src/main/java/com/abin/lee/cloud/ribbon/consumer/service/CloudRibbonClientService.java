package com.abin.lee.cloud.ribbon.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *
 */
@Slf4j
@Service
public class CloudRibbonClientService {

    @Resource
    RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "addServiceFallBack")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "true")},fallbackMethod = "addServiceFallBack")
    public String addService(Integer param1, Integer param2){
        log.info("param1=" + param1 + ", param2=" + param2);
        String result = restTemplate.getForEntity("http://cloud-service-provider/add?a=" + param1 + "&b=" + param2, String.class).getBody();
        log.info("param1=" + param1 + ", param2=" + param2 + ", result=" + result);
        return result;
    }

    public String addServiceFallBack(Integer param1, Integer param2){
        return "The System is busy, Please Wait for a moment!";
    }


}
