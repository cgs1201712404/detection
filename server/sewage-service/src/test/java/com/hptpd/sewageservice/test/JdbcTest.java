package com.hptpd.sewageservice.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/19
 * \* @time: 1:07
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {

    private Logger logger = LoggerFactory.getLogger(JdbcTest.class);

    @Resource
    @Qualifier("juzhengJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void juzhengMonitorPointTest() {

        String sql = "select * from EM.HB_WRY";
        jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Nullable
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                logger.info(resultSet.getString("WRY_NAME"));
                logger.info(resultSet.getString("WRY_SHORTNAME"));
                return resultSet;
            }
        });
    }
}
