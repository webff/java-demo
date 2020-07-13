package com.springbootweb.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求的语言参数
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();    //如果没有就使用默认的
        //r如果请求携带了国际化的参数
        if(!StringUtils.isEmpty(language)){
            //zh_CN
            String [] spilt= language.split("_");
            //国家,地区
            locale = new Locale(spilt[0],spilt[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
