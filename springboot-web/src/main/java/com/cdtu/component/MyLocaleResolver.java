package com.cdtu.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自己编写区域信息实现根据链接切换登录界面上的中英文提示
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");//获取页面参数
        Locale locale = Locale.getDefault();//选用默认的区域信息
        if (!StringUtils.isEmpty(l)) {//判断是否传递过来请求头
            String[] split = l.split("_");//根据命名规则的下划线分割国籍语言
            locale = new Locale(split[0], split[1]);//根据分割的国际语言重新定义区域信息
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {

    }
}
