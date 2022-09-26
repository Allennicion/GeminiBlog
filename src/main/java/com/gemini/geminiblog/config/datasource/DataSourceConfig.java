package com.gemini.geminiblog.config.datasource;

import cn.hutool.core.util.StrUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 数据库连接
 * @Author zhangWj
 * @Date 2022/9/26 10:15
 **/
@Slf4j
@Configuration
@Data
public class DataSourceConfig {

    private final Environment env;
    @Value("${db.ip:127.0.0.1}")
    private String ip;
    @Value("${db.port:3306}")
    private String port;
    @Value("${db.name:geminiblog}")
    private String name;
    @Value("${db.username:root}")
    private String user;
    @Value("${db.password:root}")
    private String pass;
    @Value("${db.useSSL:false}")
    private String useSsl;
    @Value("${db.jdbcUrl:}")
    private String jdbcUrl;

    @Autowired
    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        try {
            DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
            String url = StrUtil.isNotEmpty(jdbcUrl) ? getJdbcUrl() : StrUtil
                    .format("jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=UTF-8&useSSL={}&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true"
                            , getIp(), getPort(), getName(),getUseSsl());
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(getUser());
            druidDataSource.setPassword(getPass());
            return druidDataSource;
        } catch (Exception e) {
            log.error("初始化数据源出错，错误信息：{}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
