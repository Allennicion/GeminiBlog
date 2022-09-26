package com.gemini.geminiblog.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 表明是Mybatis的Mapper
 * @Author zhangWj
 * @Date 2022/9/26 10:14
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MybatisMapper {

    String value() default "";
}
