package com.hptpd.sewage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 19:42
 * \* Description: 数据源配置
 * \
 */
@Configuration
public class DataSourceConfig {

    /**
     * 主数据源
     *
     * @return
     */
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 巨正数据源
     *
     * @return
     */
    @Bean(name = "juzhengDataSource")
    @Qualifier("juzhengDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.juzheng")
    public DataSource juzhengDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "juzhengJdbcTemplate")
    public JdbcTemplate juzhengJdbcTemplate(
            @Qualifier("juzhengDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
