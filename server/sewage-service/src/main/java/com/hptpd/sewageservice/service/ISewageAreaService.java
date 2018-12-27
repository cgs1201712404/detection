package com.hptpd.sewageservice.service;

import com.hptpd.sewageservice.vo.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
     * 获取污水服务区集成商列表数据
     *
     * @param sewageAreaId
     * @return
     */
    List<SystemVo> getAreaSystems(String sewageAreaId);

    /**
     * 获取污水服务区单个集成商数据
     *
     * @param sewageAreaId
     * @param systemCode
     * @return
     */
    SystemVo getAreaSystem(String sewageAreaId, String systemCode);

    /**
     * 获单个集成商指标分页数据
     *
     * @param systemCode
     * @param pageable
     * @return
     */
    FactorPageVo getSystemFactors(String sewageAreaId, String systemCode, Pageable pageable);

    /**
     * 获取集成商单个指标数据
     *
     * @param systemCode
     * @param factorCode
     * @return
     */
    FactorVo getSystemFactor(String sewageAreaId, String systemCode, String factorCode);

    /**
     * 分页获取单个指标历史数据
     *
     * @param systemCode
     * @param factorCode
     * @param pageable
     * @return
     */
    FactorValuePageVo getSystemFactorHistoryValue(String systemCode, String factorCode, Pageable pageable);

    /**
     * 分页获取单个指标实时数据
     *
     * @param systemCode
     * @param factorCode
     * @param pageable
     * @return
     */
    FactorValuePageVo getSystemFactorRealTimeValue(String systemCode, String factorCode, Pageable pageable);

    /**
     * 获取单个指标最新数据
     *
     * @param systemCode
     * @param factorCode
     * @return
     */
    FactorValueVo getSystemFactorLatestValue(String systemCode, String factorCode);
}
