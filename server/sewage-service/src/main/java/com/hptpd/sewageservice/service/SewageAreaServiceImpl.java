package com.hptpd.sewageservice.service;//package com.hptpd.sewage.service;

import com.hptpd.sewageservice.repository.FactorRep;
import com.hptpd.sewageservice.repository.SewageAreaRep;
import com.hptpd.sewageservice.vo.FactorPageVo;
import com.hptpd.sewageservice.vo.FactorValuePageVo;
import com.hptpd.sewageservice.vo.FactorValueVo;
import com.hptpd.sewageservice.vo.FactorVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Pageable;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 14:35
 * \* Description:
 * \
 */
@Service("sewageAreaService")
public class SewageAreaServiceImpl implements ISewageAreaService {

    @Resource(name = "sewageAreaInitializer")
    private SewageAreaInitializer sewageAreaInitializer;

    @Resource(name = "sewageAreaRep")
    private SewageAreaRep sewageAreaRep;

    @Resource(name = "factorRep")
    private FactorRep factorRep;

    /**
     * 污水服务区数据初始化
     */
    @Override
    public void sewageAreaInit() {
        sewageAreaInitializer.sewageAreaInit();
    }

    /**
     * 获取污水服务区分页指标数据
     *
     * @param sewageAreaId
     * @return
     */
    @Override
    public FactorPageVo getSewageAreaFactors(String sewageAreaId) {
        return null;
    }

    /**
     * 获取污水服务区单个指标数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @return
     */
    @Override
    public FactorVo getSewageAreaFactor(String sewageAreaId, String factorCode) {
        return null;
    }

    /**
     * 分页获取单个指标历史数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @param pageable
     * @return
     */
    @Override
    public FactorValuePageVo getAreaFactorHistoryValue(String sewageAreaId, String factorCode, Pageable pageable) {
        return null;
    }

    /**
     * 分页获取单个指标实时数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @param pageable
     * @return
     */
    @Override
    public FactorValuePageVo getAreaFactorRealTimeValue(String sewageAreaId, String factorCode, Pageable pageable) {
        return null;
    }

    /**
     * 获取单个指标最新数据
     *
     * @param sewageAreaId
     * @param factorCode
     * @param pageable
     * @return
     */
    @Override
    public FactorValueVo getAreaFactorLatestValue(String sewageAreaId, String factorCode, Pageable pageable) {
        return null;
    }
}
