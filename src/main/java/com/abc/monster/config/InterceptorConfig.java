package com.abc.monster.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //注册一个拦截器,相当于applicationContext-mvc.xml配置
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //定义需要拦截的路径
        String [] addPathPatterns = {
                "/admin"
        };

        //定义不需要拦截的路径
        String [] excludePathPatterns = {
                "/login"

        };

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
