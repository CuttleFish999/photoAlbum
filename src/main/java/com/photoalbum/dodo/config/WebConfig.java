package com.photoalbum.dodo.config;

import com.photoalbum.dodo.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/test")
                .excludePathPatterns("/login")
                .excludePathPatterns("/loginAPI")
                .excludePathPatterns("/register")
                .excludePathPatterns("/index")
                .excludePathPatterns("/css/frontEnd/index.css")
                .excludePathPatterns("/css/frontEnd/com/nav.css")
                .excludePathPatterns("/image/frontEnd/CLT-L290332.JPG")
                .excludePathPatterns("/image/frontEnd/CLT-L29044.JPG")
                .excludePathPatterns("/image/frontEnd/new.jpg")
                .excludePathPatterns("/icon/frontEnd/index/images.webp")
                .excludePathPatterns("/icon/frontEnd/index/sun.webp")
                .excludePathPatterns("/js/frontEnd/index.js");

    }
}
