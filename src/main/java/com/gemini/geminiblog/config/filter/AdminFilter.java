package com.gemini.geminiblog.config.filter;

import com.gemini.geminiblog.controllers.BaseController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问拦截
 * @Author zhangWj
 * @Date 2022/9/26 10:16
 **/
public class AdminFilter extends BaseController implements HandlerInterceptor {

    private static final String FRONTEND_INDEX = "/";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
