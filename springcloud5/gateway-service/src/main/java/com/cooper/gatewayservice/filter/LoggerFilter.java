package com.cooper.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/16
 * @describe 自定义链路数据  比如记录操作人 通过tracer获取全局唯一id ，并且打印 或者记录到log中
 */
public class LoggerFilter extends ZuulFilter {


    @Autowired
    Tracer tracer;
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        tracer.addTag("opretor","cooper");
        System.out.println(tracer.getCurrentSpan().traceIdString());
        return null;
    }
}
