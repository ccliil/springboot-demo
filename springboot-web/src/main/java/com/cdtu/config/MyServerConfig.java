package com.cdtu.config;

import com.cdtu.listener.MyListener;
import com.cdtu.servlet.myServlet;
import com.cdtu.filter.MyFilter;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {
    @Bean
    public ServletRegistrationBean myServlet() {//用ServletRegistrationBean注册Servlet
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new myServlet(), "/myServet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {//用 FilterRegistrationBean注册Filter
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {//用ServletListenerRegistrationBean注册Listener
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

    @Bean
    /**
     * 使用EmbeddedServletContainerCustomizer嵌入式容器来定制修改端口配置
     */
    public EmbeddedServletContainerCustomizer myEmbeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8083);
            }
        };
    }
}
