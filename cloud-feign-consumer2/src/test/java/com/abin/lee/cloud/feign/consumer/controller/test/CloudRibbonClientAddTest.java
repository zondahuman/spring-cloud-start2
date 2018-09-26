package com.abin.lee.cloud.feign.consumer.controller.test;

import com.abin.lee.cloud.sys.common.OkHttpClientUtil;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by abin on 2018/7/12.
 */
public class CloudRibbonClientAddTest {
    private static final String httpUrl = "http://localhost:9466/add";
//    private static final String httpUrl = "http://localhost:9466/ribbon-client/add";
//    private static final String httpCreateUrl = "http://localhost:9466/ribbon-client/add";
    private static final String httpCreateUrl = "http://localhost:9466/add";

    public static void main(String[] args) throws IOException {


    }

    @Test
    public void testZipkinSimple1() throws IOException {
        String result = OkHttpClientUtil.httpPost(httpUrl, null);
        System.out.println("result=" + result);
    }

    @Test
    public void testZipkinSimple2() throws IOException {
        String result = OkHttpClientUtil.httpGet(httpUrl);
        System.out.println("result=" + result);
    }

    @Test
    public void testZipkinCreate() throws IOException {
        Map<String, String> params = Maps.newHashMap();
        params.put("param1", "12345");
        params.put("param2", "67890");

        String result = OkHttpClientUtil.httpPost(httpCreateUrl, params);
        System.out.println("result=" + result);
    }

    @Test
    public void testZipkinCreateLoop() throws IOException {
        for (int i = 0; i < 1000; i++) {
            Map<String, String> params = Maps.newHashMap();
            params.put("param1", (int) (Math.random() * 100000) + "");
            params.put("param2", (int) (Math.random() * 100000) + "");

            String result = OkHttpClientUtil.httpPost(httpCreateUrl, params);
            System.out.println("result=" + result);
        }

    }


}
