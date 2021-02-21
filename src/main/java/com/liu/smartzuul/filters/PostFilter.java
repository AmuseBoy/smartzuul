package com.liu.smartzuul.filters;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @ClassName PostFilter
 * @Description TODO
 * @Author 刘培振
 * @Date 2020-07-16 14:24
 * @Version 1.0
 */
public class PostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

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
        System.out.println("只是 post filter");
        return null;
    }
}
