package com.liu.smartzuul;

import com.liu.smartzuul.filters.ErrorFilter;
import com.liu.smartzuul.filters.FirstPreFilter;
import com.liu.smartzuul.filters.PostFilter;
import com.liu.smartzuul.filters.SecondPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class SmartzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartzuulApplication.class, args);
    }

    @Bean
    public FirstPreFilter firstPreFilter(){
        return new FirstPreFilter();
    }

    @Bean
    public SecondPreFilter secondPreFilter(){
        return new SecondPreFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

}
