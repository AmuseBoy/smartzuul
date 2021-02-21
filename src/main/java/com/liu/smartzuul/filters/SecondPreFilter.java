package com.liu.smartzuul.filters;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @ClassName SecondPreFilter
 * @Description TODO
 * @Author 刘培振
 * @Date 2020-07-16 14:23
 * @Version 1.0
 */
public class SecondPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("输出，这是second filter");
        return null;
    }
}
