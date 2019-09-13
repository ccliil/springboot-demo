package com.cdtu.springboot;

import com.cdtu.springboot.entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootHelloWorldApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean a = ioc.containsBean("helloService");
        System.out.println(a);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }


}
