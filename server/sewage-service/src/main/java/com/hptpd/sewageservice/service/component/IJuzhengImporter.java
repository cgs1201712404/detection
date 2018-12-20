package com.hptpd.sewageservice.service.component;

import com.hptpd.sewageservice.vo.JuzhengFactorVo;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 19:26
 * \* Description: 巨正数据导入接口
 * \
 */
public interface IJuzhengImporter {

    /**
     * 获取巨正的历史数据
     *
     * @param year  年份  格式 2018
     * @param month 月份 格式 12
     * @param code  指标编码 ： pH,cod, nH3N, tP, sS, flow
     * @return
     */
    JuzhengFactorVo getHistoryData(Integer year, Integer month, String code);

    /**
     * 获取巨正的实时数据
     *
     * @param code 指标编码 ： pH,cod, nH3N, tP, sS, flow
     * @return
     */
    JuzhengFactorVo getRealTimeData(String code);
}
