package com.hptpd.sewageservice.service.component;

import com.google.common.collect.Lists;
import com.hptpd.sewageservice.common.util.StringUtil;
import com.hptpd.sewageservice.vo.juzheng.JuzhengData;
import com.hptpd.sewageservice.vo.juzheng.JuzhengFactorVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 19:58
 * \* Description:
 * \
 */
@Service("iJuzhengImporter")
public class JuzhengImporterImpl implements IJuzhengImporter {
    private Logger logger = LoggerFactory.getLogger(JuzhengImporterImpl.class);

    @Resource
    @Qualifier("juzhengJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private String JCYZBM = null;
    private String TXBZ = "JZ000000000001";
//    private String sql;


    /**
     * 获取巨正的历史数据
     *
     * @param year  年份  格式 2018
     * @param month 月份 格式 12
     * @param code  指标编码 ： pH,cod, nH3N, tP, sS, flow
     * @return
     */
    @Override
    public JuzhengFactorVo getHistoryData(Integer year, Integer month, String code) {

        JuzhengFactorVo juzhengFactorVo = strSql(code);

        List<JuzhengData> juzhengDataList = Lists.newArrayList();

        String TableName = "_" + year + month;
        String sqlBM = "select * from EM.PUB_CURRENTTIME" + TableName + " where JCYZ_BM =" + "'" + JCYZBM + "'"+ "and TXBZ =" + "'" + TXBZ + "'";
        jdbcTemplate.query(sqlBM, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                JuzhengData juzhengData = new JuzhengData();
                juzhengData.setJCYZBM(resultSet.getString("JCYZ_BM"));
                juzhengData.setTXBZ(TXBZ);
                juzhengData.setDataTime(resultSet.getString("DATATIME"));
                juzhengData.setAValue(resultSet.getString("AVALUE"));
                juzhengData.setCValue(resultSet.getString("CVALUE"));
                juzhengData.setDataFlag(resultSet.getString("DATAFLAG"));
                juzhengDataList.add(juzhengData);
                juzhengFactorVo.setHistoryData(juzhengDataList);
                return resultSet;
            }
        });
        logger.info(juzhengFactorVo.toString());
        return juzhengFactorVo;
    }

    /**
     *  指标编码 转换sql 语句
     * @return  juzhengFactorVo
     */
     private JuzhengFactorVo strSql(String code){
         String strCode;
         String sql =null;
         JuzhengFactorVo juzhengFactorVo =new JuzhengFactorVo();
         if (code.equals("pH")) {
             strCode = "PH";
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals("cod")) {
             strCode = "COD";
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals("nH3N")) {
             strCode = "氨氮";
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals("tP")) {
             strCode = "总磷";
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals("sS")) {
             strCode = "水中油";
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals("flow")) {
             strCode = "悬浮物";
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         }
         jdbcTemplate.query(sql, new RowMapper<Object>() {
             @Nullable
             @Override
             public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                 //因子编码
                 JCYZBM = resultSet.getString("JCYZ_BM");
                 TXBZ = resultSet.getString("TXBZ");
                 juzhengFactorVo.setCode(resultSet.getString("TXBZ"));
                 juzhengFactorVo.setName(resultSet.getString("JCYZ_MC"));
                 juzhengFactorVo.setJCYZBM(resultSet.getString("JCYZ_BM"));
                 String strMax = resultSet.getString("WJ_UPLIMIT");
                 if (StringUtil.isNotEmpty(strMax)) {
                     BigDecimal max = new BigDecimal(strMax);
                     juzhengFactorVo.setMaxValue(max);
                 }
                 String strMin = resultSet.getString("WJ_LOWLIMIT");
                 if (StringUtil.isNotEmpty(strMin)) {
                     BigDecimal min = new BigDecimal(strMin);
                     juzhengFactorVo.setMinValue(min);
                 }
                 logger.info(juzhengFactorVo.toString());
                 return resultSet;
             }
         });
        return juzhengFactorVo;
     }


    /**
     * 获取巨正的实时数据
     *
     * @param code 指标编码 ： pH,cod, nH3N, tP, sS, flow
     * @return
     */
    @Override
    public JuzhengFactorVo getRealTimeData(String code) {
        JuzhengFactorVo juzhengFactorVo =strSql(code);
        //根据因子编码查询 实时数据 (PUB_CURRENTTEMP 表)
        String sqlBM = "select * from EM.PUB_CURRENTTEMP where JCYZ_BM =" + "'" + JCYZBM + "'"+ "and TXBZ =" + "'" + TXBZ + "'";
        jdbcTemplate.query(sqlBM, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                JuzhengData juzhengData = new JuzhengData();
                juzhengData.setJCYZBM(resultSet.getString("JCYZ_BM"));
                juzhengData.setTXBZ(TXBZ);
                juzhengData.setDataTime(resultSet.getString("DATATIME"));
                juzhengData.setAValue(resultSet.getString("AVALUE"));
                juzhengData.setCValue(resultSet.getString("CVALUE"));
                juzhengData.setDataFlag(resultSet.getString("DATAFLAG"));
                logger.info(juzhengData.getAValue().toString());
                juzhengFactorVo.setCurrentTimeData(juzhengData);
                return resultSet;
            }
        });
        logger.info(juzhengFactorVo.toString());
        return juzhengFactorVo;
    }
}
