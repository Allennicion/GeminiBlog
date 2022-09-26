package com.gemini.geminiblog.exception;

/**
 *
 * @Author zhangWj
 * @Date 2022/9/26 14:10
 **/
public class AppRunningException extends RuntimeException {
    public AppRunningException(String message) {
        super(message);
    }
}
