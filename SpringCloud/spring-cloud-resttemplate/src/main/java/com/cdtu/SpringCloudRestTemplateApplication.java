package com.cdtu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringCloudRestTemplateApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudRestTemplateApplication.class, args);
    }

    /**
     * 使用spring自带的RestTemplate模板第一步，首先在启动类中注册一个RestTemplate
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
