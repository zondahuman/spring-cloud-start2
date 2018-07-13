package com.abin.lee.cloud.service.zuul;

import com.abin.lee.cloud.service.zuul.filter.CloudZuulFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by abin on 2018/5/2 21:46.
 *
 *
 */
@EnableZuulProxy
@SpringCloudApplication
public class CloudServiceZuulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudServiceZuulApplication.class).web(true).run(args);
    }

    @Bean
    public CloudZuulFilter getFilter() {
        return new CloudZuulFilter();
    }

}
