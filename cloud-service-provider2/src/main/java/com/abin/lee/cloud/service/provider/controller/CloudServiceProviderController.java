package com.abin.lee.cloud.service.provider.controller;

import com.abin.lee.cloud.sys.common.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建“服务提供方”
 * 下面我们创建提供服务的客户端，并向服务注册中心注册自己。
 * https://www.cnblogs.com/ityouknow/p/6906917.html
 */
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@Slf4j
@RestController
public class CloudServiceProviderController {

    private final Logger logger = Logger.getLogger(getClass());

    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    Registration registration;
    @Value("${financial.configs.name}")
    String financialName;
    @Value("${financial.configs.count}")
    String financialCount;


    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer add(Integer param1, Integer param2) {
        log.info("param1=" + param1 + ", param2=" + param2);

        String serviceId = registration.getServiceId();
        List<ServiceInstance> instanceList = discoveryClient.getInstances(serviceId);
        Integer result = param1 + param2;
//        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        logger.info("/add, instanceList : " + JsonUtil.toJson(instanceList) + ", result:" + result);
        return result;
    }


    @RequestMapping(value = "/getConf", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void getConf() {
        log.info("financialName=" + financialName + ", financialCount=" + financialCount);


    }


}
