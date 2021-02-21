package com.liu.smartzuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CustomZuulConfig
 * @Description TODO
 * @Author 刘培振
 * @Date 2020-07-13 10:42
 * @Version 1.0
 */
@Configuration
public class CustomZuulConfig {

    public final static Logger logger = LoggerFactory.getLogger(CustomZuulConfig.class);

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public CustomRouteLocator routeLocator(){
        logger.info("servletPrefix:{}", serverProperties.getServletPrefix());
        return new CustomRouteLocator(serverProperties.getServletPrefix(), zuulProperties);
    }

}
