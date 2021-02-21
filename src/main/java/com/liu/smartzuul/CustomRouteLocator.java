package com.liu.smartzuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName CustomRouteLocator
 * @Description TODO
 * @Author 刘培振
 * @Date 2020-07-13 9:42
 * @Version 1.0
 */
public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public final static Logger logger = LoggerFactory.getLogger(CustomRouteLocator.class);

    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    /**
     * 实现RefreshableRouteLocator接口，通过事件支持刷新功能
     */
    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        routesMap.putAll(super.locateRoutes());
        routesMap.putAll(this.customLocateRoutes());
        return routesMap;
    }

    /**
     * 自定义路由信息
     * @return
     */
    private Map<String, ZuulProperties.ZuulRoute> customLocateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> customRoutesMap = new LinkedHashMap<>();
        ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
        zuulRoute.setId("demo");
        zuulRoute.setPath("/demo/**");
        zuulRoute.setServiceId("DEMO");
        customRoutesMap.put(zuulRoute.getPath(), zuulRoute);
        return customRoutesMap;
    }
}
