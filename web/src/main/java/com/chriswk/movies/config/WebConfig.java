package com.chriswk.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import org.fusesource.scalate.spring.view.ScalateViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.chriswk.movies.web.controller")
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);
        return viewResolver;
    }

    @Bean
    public ViewResolver scalateViewResolver() {
        ScalateViewResolver viewResolver = new ScalateViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/scalate/");
        viewResolver.setSuffix(".jade");
        viewResolver.setOrder(1);
        return viewResolver;
    }
}
