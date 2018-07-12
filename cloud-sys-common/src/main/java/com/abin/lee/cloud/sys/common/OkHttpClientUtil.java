package com.abin.lee.cloud.sys.common;

import okhttp3.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by abin on 2018/7/12.
 */
public class OkHttpClientUtil {
    //    static OkHttpClient client = new OkHttpClient();
    public static OkHttpClient httpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .build();


    public static String httpPost(String url, Map<String, String> params) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        if(null != params) {
            for (Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<String, String> entry = iterator.next();
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        RequestBody formBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = httpClient.newCall(request).execute();
        String result = response.body().string();
        System.out.println("result=" + result);
        if (response.isSuccessful()) {
            return result;
        } else {
            throw new IOException("Unexpected code :" + response);
        }
    }

    public static String httpGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        String result = response.body().string();
        System.out.println("result=" + result);
        return result;
    }



}
