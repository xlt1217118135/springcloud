package com.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.redis.RedisTempletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo
 * Date 2020/7/31 10:07
 */
@Component
@PropertySource("classpath:NotFilterUrl.properties")
public class LoginFilter  extends ZuulFilter {

    private final static Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Autowired
    private RedisTempletUtil redisTempletUtil;

    @Value("${NOT_FILTER_URL}")
    private String notFilterUrl;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext  context = RequestContext.getCurrentContext();

        HttpServletRequest request = context.getRequest();

        List<String> urls = Arrays.asList(notFilterUrl.split(","));

        String currenturl = request.getRequestURI();

        for(String url : urls){
            if(currenturl.indexOf(url) != -1){
                return false;
            }
        }

        String sessionId = request.getHeader("sessionId");
        try{
            if(sessionId == null){
                context.getResponse().sendRedirect("http://localhost/login.html");
            }else {
                JSONObject json = redisTempletUtil.getData(sessionId);
                if(json == null){
                    context.getResponse().sendRedirect("http://localhost/login.html");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Object run() throws ZuulException {


        return null;
    }
}
