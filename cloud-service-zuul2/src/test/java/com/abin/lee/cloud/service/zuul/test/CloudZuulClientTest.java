package com.abin.lee.cloud.service.zuul.test;

import com.abin.lee.cloud.sys.common.OkHttpClientUtil;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by abin on 2018/7/12.
 *  http://localhost:9477/cloud-client/ribbon-client/add?param1=13&param2=33&token=zz
 */
public class CloudZuulClientTest {
    private static final String httpUrl = "http://localhost:9477/cloud-client/ribbon-client/add?param1=13&param2=33&token=zz";
    private static final String httpCreateUrl = "http://localhost:9477/cloud-client/ribbon-client/add";

    public static void main(String[] args) throws IOException {




    }

    @Test
    public void testCloudZuulClient1() throws IOException {
        String result = OkHttpClientUtil.httpPost(httpUrl, null);
        System.out.println("result="+result);
    }

    @Test
    public void testCloudZuulClient2() throws IOException {
        String result = OkHttpClientUtil.httpGet(httpUrl);
        System.out.println("result="+result);
    }

    @Test
    public void testCloudZuulClient() throws IOException {
        Map<String, String> params = Maps.newHashMap();
        params.put("param1", "123");
        params.put("param2", "234");
        params.put("token", "zz");

        String result = OkHttpClientUtil.httpPost(httpCreateUrl, params);
        System.out.println("result="+result);
    }



}
