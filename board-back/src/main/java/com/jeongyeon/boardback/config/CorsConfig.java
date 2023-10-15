package com.jeongyeon.boardback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings (org.springframework.web.servlet.config.annotation.CorsRegistry CorsRegistry){
        CorsRegistry
            .addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins("*");
            
    }
}
