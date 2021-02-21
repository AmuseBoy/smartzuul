package com.liu.smartzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName RouteFilter
 * @Description TODO
 * @Author 刘培振
 * @Date 2020-07-16 16:06
 * @Version 1.0
 */
@Component
public class RouteFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 修改url只能在 route的filter
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String appKey = request.getHeader("appKey");
        if(!StringUtils.isEmpty(appKey)){
            try {
                System.out.println("输出 route filter"+appKey);
                URI uri = new URI("https://www.zhihu.com");
                context.setRouteHost(uri.toURL());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            context.put(FilterConstants.REQUEST_URI_KEY, "/aaa");
            return null;
        }
        return null;
    }


}
