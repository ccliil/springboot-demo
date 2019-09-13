package com.cdtu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient //开启客户端

public class SpringbootClientConsumerDemoApplication {
    @Bean
    @LoadBalanced
    //添加负载均衡注解，在org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:2.1.2.RELEASE自动添加了org.springframework.cloud:spring-cloud-starter-netflix-ribbon:2.1.2.RELEASE
    //里面具有管理负载均衡的
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootClientConsumerDemoApplication.class, args);
    }

}
