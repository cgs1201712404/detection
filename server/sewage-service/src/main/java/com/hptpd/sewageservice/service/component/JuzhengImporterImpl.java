package com.hptpd.sewageservice.service.component;

import com.google.common.collect.Lists;
import com.hptpd.sewageservice.common.Constant;
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
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    @Qualifier("juzhengJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private String JCYZBM = null;
    private String TXBZ = "JZ000000000001";

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
        String sqlBM = "select * from EM.PUB_CURRENTTIME" + TableName + " where JCYZ_BM =" + "'" + JCYZBM + "'"+ "and JKXT_MN =" + "'" + TXBZ + "'";
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
         if (code.equals(Constant.SYSTEM_PH)) {
             strCode = Constant.PH;
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals(Constant.SYSTEM_COD)) {
             strCode = Constant.COD;
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals(Constant.SYSTEM_NH3N)) {
             strCode = Constant.NH3N;
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals(Constant.SYSTEM_TP)) {
             strCode = Constant.TP;
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals(Constant.SYSTEM_SS)) {
             strCode = Constant.SS;
             sql = "select * from EM.HB_WRY_JCYZ where JCYZ_MC =" + "'" + strCode + "'" + "and TXBZ =" + "'" + TXBZ + "'";
         } else if (code.equals(Constant.SYSTEM_FLOW)) {
             strCode = Constant.FLOW;
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
    @Transactional(rollbackFor = Exception.class)
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
                juzhengFactorVo.setCurrentTimeData(juzhengData);
                return resultSet;
            }
        });
        return juzhengFactorVo;
    }
}
