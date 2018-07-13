package com.abin.lee.cloud.feign.consumer.controller;

import com.abin.lee.cloud.feign.consumer.service.CloudFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class CloudFeignClientController {

    @Autowired
    CloudFeignClientService cloudFeignClientService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(){
        return cloudFeignClientService.add(10, 20);
    }



}
