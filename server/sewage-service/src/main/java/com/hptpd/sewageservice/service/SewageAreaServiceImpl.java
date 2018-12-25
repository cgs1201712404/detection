package com.hptpd.sewageservice.service;//package com.hptpd.sewage.service;

import com.hptpd.sewageservice.repository.FactorRep;
import com.hptpd.sewageservice.repository.SewageAreaRep;
import com.hptpd.sewageservice.vo.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

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
     * 获取污水服务区集成商分页数据
     *
     * @param sewageAreaId
     * @return
     */
    @Override
    public List<SystemVo> getAreaSystems(String sewageAreaId) {
        return null;
    }

    /**
     * 获取污水服务区单个集成商数据
     *
     * @param sewageAreaId
     * @param systemCode
     * @return
     */
    @Override
    public SystemVo getAreaSystem(String sewageAreaId, String systemCode) {
        return null;
    }

    /**
     * 获单个集成商指标分页数据
     *
     * @param systemCode
     * @param pageable
     * @return
     */
    @Override
    public FactorValuePageVo getSystemFactors(String systemCode, Pageable pageable) {
        return null;
    }

    /**
     * 获取集成商单个指标数据
     *
     * @param systemCode
     * @param factorCode
     * @return
     */
    @Override
    public FactorValueVo getSystemFactor(String systemCode, String factorCode) {
        return null;
    }

    /**
     * 分页获取单个指标历史数据
     *
     * @param systemCode
     * @param factorCode
     * @param pageable
     * @return
     */
    @Override
    public FactorValuePageVo getSystemFactorHistoryValue(String systemCode, String factorCode, Pageable pageable) {
        return null;
    }

    /**
     * 分页获取单个指标实时数据
     *
     * @param systemCode
     * @param factorCode
     * @param pageable
     * @return
     */
    @Override
    public FactorValuePageVo getSystemFactorRealTimeValue(String systemCode, String factorCode, Pageable pageable) {
        return null;
    }

    /**
     * 获取单个指标最新数据
     *
     * @param systemCode
     * @param factorCode
     * @param pageable
     * @return
     */
    @Override
    public FactorValueVo getSystemFactorLatestValue(String systemCode, String factorCode, Pageable pageable) {
        return null;
    }

}
