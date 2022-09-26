package com.gemini.geminiblog.config.filter;

import com.gemini.geminiblog.utils.GeminiUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页拦截
 * @Author zhangWj
 * @Date 2022/9/26 10:16
 **/
public class InitFilter extends HandlerInterceptorAdapter {

    private static final String INIT_URL = "/init";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
