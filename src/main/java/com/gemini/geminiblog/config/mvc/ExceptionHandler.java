package com.gemini.geminiblog.config.mvc;


import com.gemini.geminiblog.exception.AppRunningException;
import com.gemini.geminiblog.exception.AppSetException;
import com.gemini.geminiblog.model.json.ResultBeanObj;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 * @Author zhangWj
 * @Date 2022/9/26 10:17
 **/
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {
            AppRunningException.class,
            AppSetException.class
    })
    @ResponseBody
    public ResultBeanObj handle(Exception e) {
        return ResultBeanObj.error(e.getMessage());
    }
}
