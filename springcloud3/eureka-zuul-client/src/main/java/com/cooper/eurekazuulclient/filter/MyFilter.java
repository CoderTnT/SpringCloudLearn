package com.cooper.eurekazuulclient.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/15
 * @describe
 */

@Component
public class MyFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    //什么类型的过滤器 路由之前
    @Override
    public String filterType() {
        return  PRE_TYPE;
    }
    //执行顺序  order 越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }
    //是否需要执行过滤逻辑   true执行run方法
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();

        HttpServletRequest request = context.getRequest();

        Object accessToken = request.getParameter("token");

        if (accessToken == null) {
            log.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        log.info("ok");

        return null;
    }
}
