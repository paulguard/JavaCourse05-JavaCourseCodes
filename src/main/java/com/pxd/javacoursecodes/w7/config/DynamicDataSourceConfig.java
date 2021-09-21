package com.pxd.javacoursecodes.w7.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource firstDataSource(){
       return new HikariDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource(){
        return new HikariDataSource();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource){
        Map<Object,Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(DataSourceNames.FIRST,firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND,secondDataSource);

        return new DynamicDataSource(firstDataSource,targetDataSources);
    }

}
