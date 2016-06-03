package com.boot.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

/**
 * Created by zy on 2016/5/12.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
public class DataBaseConfiguration{

    private static Logger log = LoggerFactory.getLogger(DataBaseConfiguration.class);

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.type}")
    private String type;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;

    @Primary
    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    public DataSource dataSource() throws SQLException {
        log.debug("Configruing Write DataSource");

        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(driver);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setUrl(url);
        datasource.setDbType(type);
        datasource.setMaxActive(maxActive);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setFilters(filters);
        datasource.setInitialSize(initialSize);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);

        return datasource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}