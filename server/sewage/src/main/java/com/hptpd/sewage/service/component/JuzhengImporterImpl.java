package com.hptpd.sewage.service.component;

import com.hptpd.sewage.vo.JuzhengFactorVo;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 19:58
 * \* Description:
 * \
 */
public class JuzhengImporterImpl implements IJuzhengImporter {

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
        return null;
    }


    /**
     * 获取巨正的实时数据
     *
     * @param code 指标编码 ： pH,cod, nH3N, tP, sS, flow
     * @return
     */
    @Override
    public JuzhengFactorVo getRealTimeData(String code) {
        return null;
    }
}
