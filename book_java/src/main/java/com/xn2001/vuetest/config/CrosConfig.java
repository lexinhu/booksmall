package com.xn2001.vuetest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")  //允许任何方法（post、get等
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*"); //允许跨域的域名，可以用*表示允许任何域名使用
    }
}
