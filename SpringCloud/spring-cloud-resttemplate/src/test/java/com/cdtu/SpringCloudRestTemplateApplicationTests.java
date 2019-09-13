package com.cdtu;

import com.cdtu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudRestTemplateApplicationTests {
    //使用RestTemplate第二部，在测试类中定义一个RestTemplate成员并注入
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
        User user = this.restTemplate.getForObject("http://localhost:8080/user/1", User.class);
        System.out.println(user);
    }

}
