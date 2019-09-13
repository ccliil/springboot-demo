package com.cdtu.dao;

import com.cdtu.entity.User;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    //@HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Integer id) {
        //初始代码
//    String Url="http://localhost:8080/user/"+id;//使用硬链接的方式不够灵活
//    return this.restTemplate.getForObject(Url,User.class);
        //第二次修改代码
      /*  List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance instance = instances.get(0);         // 获取ip和端口信息
        System.out.println(instance.getHost()+"...."+instance.getPort());
      String url = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/"+id;*/
        //加上负载均衡之后的代码
        String url = "http://user-service/user/" + id; //user-service中已经指向了服务器
        return this.restTemplate.getForObject(url, User.class);
    }
}
