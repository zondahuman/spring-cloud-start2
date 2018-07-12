package com.abin.lee.cloud.service.zipkin.test;

import com.abin.lee.cloud.sys.common.OkHttpClientUtil;
import com.google.common.collect.Maps;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by abin on 2018/7/12.
 */
public class ZipkinSimpleTest {
    private static final String httpUrl = "http://localhost:9412/zipkin/simple";
    private static final String httpCreateUrl = "http://localhost:9412/zipkin/create";

    public static void main(String[] args) throws IOException {




    }

    @Test
    public void testZipkinSimple1() throws IOException {
        String result = OkHttpClientUtil.httpPost(httpUrl, null);
        System.out.println("result="+result);
    }

    @Test
    public void testZipkinSimple2() throws IOException {
        String result = OkHttpClientUtil.httpGet(httpUrl);
        System.out.println("result="+result);
    }

    @Test
    public void testZipkinCreate() throws IOException {
        Map<String, String> params = Maps.newHashMap();
        params.put("id", "1000");
        params.put("name", "abin111");

        String result = OkHttpClientUtil.httpPost(httpCreateUrl, params);
        System.out.println("result="+result);
    }



}
