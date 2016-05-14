package com.boot.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by zy on 2016/5/12.
 */
@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration implements EnvironmentAware {

    private static Logger log = LoggerFactory.getLogger(DataBaseConfiguration.class);
    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "jdbc.");
    }

    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    @Primary
    public DataSource dataSource() {
        log.debug("Configruing Write DataSource");

        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(propertyResolver.getProperty("driver"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setMaxActive(propertyResolver.getProperty("maxActive", Integer.TYPE));
        datasource.setValidationQuery(propertyResolver.getProperty("validationQuery"));
        datasource.setTestOnBorrow(propertyResolver.getProperty("testOnBorrow", Boolean.TYPE));
        datasource.setTestOnReturn(propertyResolver.getProperty("testOnReturn", Boolean.TYPE));
        datasource.setTestWhileIdle(propertyResolver.getProperty("testWhileIdle", Boolean.TYPE));
        datasource.setTimeBetweenEvictionRunsMillis(propertyResolver.getProperty("timeBetweenEvictionRunsMillis", Long.TYPE));
        datasource.setMinEvictableIdleTimeMillis(propertyResolver.getProperty("minEvictableIdleTimeMillis", Long.TYPE));
        return datasource;
    }

}