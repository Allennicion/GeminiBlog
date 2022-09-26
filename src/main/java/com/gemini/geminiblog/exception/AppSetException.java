package com.gemini.geminiblog.exception;

/**
 *
 * @Author zhangWj
 * @Date 2022/9/26 14:10
 **/
public class AppSetException extends RuntimeException {
    public AppSetException(String message) {
        super(message);
    }

    public AppSetException(String message, Throwable cause) {
        super(message, cause);
    }
}
