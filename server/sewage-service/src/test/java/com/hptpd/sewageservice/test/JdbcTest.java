package com.hptpd.sewageservice.test;

import com.hptpd.sewageservice.service.ISewageAreaService;
import com.hptpd.sewageservice.service.component.IJuzhengImporter;
import com.hptpd.sewageservice.vo.FactorPageVo;
import com.hptpd.sewageservice.vo.FactorValuePageVo;
import com.hptpd.sewageservice.vo.FactorVo;
import com.hptpd.sewageservice.vo.SystemVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Resource(name = "iJuzhengImporter")
    private IJuzhengImporter iJuzhengImporter;

    @Resource(name="sewageAreaService")
    private ISewageAreaService iSewageAreaService;

    @Test
    public void juzhengMonitorPointTest() {

//        String sql = "select * from EM.HB_WRY";
//        jdbcTemplate.query(sql, new RowMapper<Object>() {
//            @Nullable
//            @Override
//            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
//                logger.info(resultSet.getString("WRY_NAME"));
//                logger.info(resultSet.getString("WRY_SHORTNAME"));
//                return resultSet;
//            }
//        });
//        iJuzhengImporter.getHistoryData(2018, 12, "sS");
//        iJuzhengImporter.getRealTimeData("pH");

        //获取污水服务区集成商分页数据
//       List<SystemVo> systemVos= iSewageAreaService.getAreaSystems("JZ000000000001");
//       logger.info(systemVos.toString());

        //获取污水服务区单个集成商数据
//       SystemVo systemVo =iSewageAreaService.getAreaSystem("JZ000000000001","juzheng_dongxilake");
//       logger.info(systemVo.toString());

        Pageable pageable = new PageRequest(0, 10);
        //获单个集成商指标分页数据
//        FactorPageVo factorPageVo =iSewageAreaService.getSystemFactors("JZ000000000001","juzheng_dongxilake",pageable);
//        logger.info(factorPageVo.getFactorVos().toString());

        //获取集成商单个指标数据
//        FactorVo factorVo =iSewageAreaService.getSystemFactor("JZ000000000001","juzheng_dongxilake","pH");
//        logger.info(factorVo.toString());

        //分页获取单个指标历史数据
        FactorValuePageVo factorValuePageVo =iSewageAreaService.getSystemFactorHistoryValue("juzheng_dongxilake","pH",pageable);
        logger.info(factorValuePageVo.toString());
        logger.info(factorValuePageVo.getFactorValueVos().toString());

    }
}
