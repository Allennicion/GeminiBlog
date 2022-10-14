package com.gemini.geminiblog;

import com.gemini.geminiblog.annotation.MybatisMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @Author zhangWj
 * @Date 2022/9/26 14:11
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.gemini.geminiblog.Dao", annotationClass = MybatisMapper.class)
@EnableScheduling
@EnableCaching
@ServletComponentScan(basePackages="com.gemini.geminiblog")
public class GeminiBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeminiBlogApplication.class, args);
    }

}
