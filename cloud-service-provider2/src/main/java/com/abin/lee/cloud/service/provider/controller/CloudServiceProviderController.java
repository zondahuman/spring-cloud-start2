package com.abin.lee.cloud.service.provider.controller;

import com.abin.lee.cloud.sys.common.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建“服务提供方”
 * 下面我们创建提供服务的客户端，并向服务注册中心注册自己。
 */
@RestController
public class CloudServiceProviderController {

    private final Logger logger = Logger.getLogger(getClass());

    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    Registration registration;

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public Integer add(Integer a, Integer b) {
        String serviceId = registration.getServiceId();
        List<ServiceInstance> instanceList = discoveryClient.getInstances(serviceId);
        Integer r = a + b;
//        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        logger.info("/add, instanceList : " + JsonUtil.toJson(instanceList) + ", result:" + r);
        return r;
    }


}
