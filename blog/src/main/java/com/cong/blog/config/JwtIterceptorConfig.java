package com.cong.blog.config;

import com.cong.blog.Interceptor.JwtIterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JwtIterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtIterceptor())
                .addPathPatterns("/api/**")//拦截的url
                .excludePathPatterns("/api/login");//放行的url
    }
}
