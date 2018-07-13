package com.abin.lee.cloud.ribbon.consumer.controller;

import com.abin.lee.cloud.ribbon.consumer.service.CloudRibbonClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/ribbon-consumer")
@Slf4j
public class CloudRibbonConsumerController {

    @Autowired
    CloudRibbonClientService cloudRibbonClientService;

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(Integer param1, Integer param2){
        return cloudRibbonClientService.addService(param1, param2);
    }



}
