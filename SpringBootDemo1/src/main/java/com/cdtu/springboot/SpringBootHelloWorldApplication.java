package com.cdtu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations={"classpath:serviceBean.xml"})
@SpringBootApplication
public class SpringBootHelloWorldApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootHelloWorldApplication.class, args);
    }

}
