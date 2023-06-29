package com.ses.interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ses.interceptor.interceptor.AdminInterceptor;
import com.ses.interceptor.interceptor.LogInterceptor;
import com.ses.interceptor.interceptor.OldLoginIterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
        registry.addInterceptor(new OldLoginIterceptor()).addPathPatterns("/admin/oldlog");
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/oldlog");
    }

}
