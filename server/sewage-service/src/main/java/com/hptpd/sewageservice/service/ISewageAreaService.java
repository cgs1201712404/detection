package com.hptpd.sewageservice.service;

import com.hptpd.sewageservice.vo.FactorPageVo;
import com.hptpd.sewageservice.vo.FactorValuePageVo;
import com.hptpd.sewageservice.vo.FactorValueVo;
import com.hptpd.sewageservice.vo.FactorVo;

import java.awt.print.Pageable;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 14:34
 * \* Description: 污水服务区service
 * \
 */
public interface ISewageAreaService {

    /**
     * 污水服务区数据初始化
     */
    void sewageAreaInit();

    /**
     * 获取污水服务区分页指标数据
     *
     * @param sewageAreaId
     * @return
     */
    FactorPageVo getSewageAreaFactors(String sewageAreaId);

    /**
     * 获取污水服务区单个指标数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @return
     */
    FactorVo getSewageAreaFactor(String sewageAreaId, String factorCode);

    /**
     * 分页获取单个指标历史数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @param pageable
     * @return
     */
    FactorValuePageVo getAreaFactorHistoryValue(String sewageAreaId, String factorCode, Pageable pageable);

    /**
     * 分页获取单个指标实时数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @param pageable
     * @return
     */
    FactorValuePageVo getAreaFactorRealTimeValue(String sewageAreaId, String factorCode, Pageable pageable);

    /**
     * 获取单个指标最新数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @param pageable
     * @return
     */
    FactorValueVo getAreaFactorLatestValue(String sewageAreaId, String factorCode, Pageable pageable);
}
