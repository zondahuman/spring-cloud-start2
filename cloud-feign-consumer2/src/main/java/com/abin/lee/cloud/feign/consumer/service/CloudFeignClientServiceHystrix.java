package com.abin.lee.cloud.feign.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Component
public class CloudFeignClientServiceHystrix implements CloudFeignClientService{

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -99999;
    }
}
