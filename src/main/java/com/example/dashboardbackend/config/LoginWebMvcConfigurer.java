package com.example.dashboardbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginHandlerInterceptor authInterceptor() {
        return new LoginHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // available path
        List<String> patterns = new ArrayList<String>();
        patterns.add("/**");
        patterns.add("/admin");
        patterns.add("/api/user/userLogin");
        patterns.add("/api/user/isStillValid");
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}
