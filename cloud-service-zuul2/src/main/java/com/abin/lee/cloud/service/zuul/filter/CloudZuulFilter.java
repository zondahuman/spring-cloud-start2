package com.abin.lee.cloud.service.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by abin on 2018/7/13.
 * 编写一个zuul过滤器，用来控制权限。每次发送请求的时候都需要一个token，如果没有token就没有权限，在被路由之前过滤器就会自动拦截掉返回401错误。
 * https://blog.csdn.net/qq_19301269/article/details/78920821
 */
@Slf4j
public class CloudZuulFilter extends ZuulFilter {

    /**
     * 返回一个字符串代表过滤器的类型
     * pre表示被路由之前
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤顺序
     */

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = String.valueOf(request.getParameter("token"));
        log.info("--------------------------token=" + accessToken );
        if (!accessToken.equals("zz")) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }

}