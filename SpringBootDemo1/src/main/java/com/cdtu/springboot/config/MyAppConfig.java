package com.cdtu.springboot.config;

import com.cdtu.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//用于表明这个类是一个配置类
public class MyAppConfig {
    @Bean//将返回值放入容器中，然后将方法名作为id值
    public HelloService helloService() {
        System.out.println("配置的组件已添加至容器中");
        return new HelloService();
    }
}