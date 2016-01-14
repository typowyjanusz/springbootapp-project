package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Janusz on 2016-01-05.
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/user_create").setViewName("user_create");
        registry.addViewController("/db").setViewName("db");
        registry.addViewController("/db2").setViewName("db2");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logged").setViewName("logged");
        registry.addViewController("/403").setViewName("403");
    }

}