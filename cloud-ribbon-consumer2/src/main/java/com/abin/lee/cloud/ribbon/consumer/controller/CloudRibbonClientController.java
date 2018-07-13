package com.abin.lee.cloud.ribbon.consumer.controller;

import com.abin.lee.cloud.ribbon.consumer.service.CloudRibbonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class CloudRibbonClientController {

    @Autowired
    CloudRibbonClientService cloudRibbonClientService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(){
        return cloudRibbonClientService.addService();
    }



}
