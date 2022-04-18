package com.example.dashboardbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedOriginPatterns("*"). // allow domain of cross, use "*" to present allowing using by any domain
                        allowedMethods("*"). // allowed function(post, get and so on)
                        allowedHeaders("*"). // allowed request header
                        allowCredentials(true). // with cookie information
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); // maxAge(3600) present within 3600s,
                // no need send pre-check request again, result can be cached
            }
        };
    }
}
