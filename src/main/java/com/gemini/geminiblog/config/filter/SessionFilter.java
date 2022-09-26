package com.gemini.geminiblog.config.filter;

import com.gemini.geminiblog.controllers.BaseController;
import com.gemini.geminiblog.utils.GeminiUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用于记录访问日志以及设置sessionUser的filter，没有任何URL的过滤作用
 *
 * @Author zhangWj
 * @Date 2021/5/26 23:02
 **/
public class SessionFilter extends BaseController implements HandlerInterceptor {

    private static final String DEVELOP_KEY = "app.develop";
    private ServletContext nbServletContext = GeminiUtils.getServletContext();

    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        session = request.getSession();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {

    }
}
