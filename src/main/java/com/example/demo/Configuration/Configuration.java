package com.example.demo.Configuration;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@org.springframework.context.annotation.Configuration
public class Configuration extends  CorsFilter
{
    @Bean
    public CorsConfiguration corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        config.setMaxAge(3600L);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        config.setExposedHeaders(Arrays.asList("Content-Type"));
        return config;
    }
}