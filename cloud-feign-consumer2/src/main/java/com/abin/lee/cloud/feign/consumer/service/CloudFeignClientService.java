package com.abin.lee.cloud.feign.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient(value = "cloud-service-provider", fallback = CloudFeignClientServiceHystrix.class)
public interface CloudFeignClientService {

    @RequestMapping(method= RequestMethod.GET, value="/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);


}
