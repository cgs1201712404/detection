package com.hptpd.sewageservice;//package com.hptpd.sewage;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import javax.sql.DataSource;
//
//
///**
// * \* Created with IntelliJ IDEA.
// * \* @author: 彭诗杰
// * \* @date: 2018/12/17
// * \* @time: 19:42
// * \* Description: JDBC配置
// * \
// */
//@Configuration
//public class JdbcConfig {
//
//    @Bean(name = "primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(
//            @Qualifier("primaryDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    @Bean(name = "juzhengJdbcTemplate")
//    public JdbcTemplate juzhengJdbcTemplate(
//            @Qualifier("juzhengDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//}
