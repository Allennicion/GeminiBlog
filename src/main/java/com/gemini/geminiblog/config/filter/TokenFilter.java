package com.gemini.geminiblog.config.filter;

import com.gemini.geminiblog.controllers.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于对前端用户登录作用的过滤，例如评论
 * @Author zhangWj
 * @Date 2022/9/26 10:15
 **/
@Slf4j
public class TokenFilter extends BaseController implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
