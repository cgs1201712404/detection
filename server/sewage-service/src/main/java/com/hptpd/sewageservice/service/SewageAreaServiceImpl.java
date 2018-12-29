package com.hptpd.sewageservice.service;//package com.hptpd.sewage.service;

import com.google.common.collect.Lists;
import com.hptpd.sewageservice.common.Constant;
import com.hptpd.sewageservice.common.util.AbstractMyBeanUtils;
import com.hptpd.sewageservice.domain.Factor;
import com.hptpd.sewageservice.domain.History;
import com.hptpd.sewageservice.domain.RealTime;
import com.hptpd.sewageservice.domain.SewageArea;
import com.hptpd.sewageservice.domain.system.MonitoringSystem;
import com.hptpd.sewageservice.repository.*;
import com.hptpd.sewageservice.service.component.IJuzhengImporter;
import com.hptpd.sewageservice.vo.*;
import com.hptpd.sewageservice.vo.juzheng.JuzhengFactorVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


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

    @Resource(name = "monitoringRep")
    private MonitoringRep monitoringRep;

    @Resource(name = "historyRep")
    private HistoryRep historyRep;

    @Resource(name = "realTimeRep")
    private RealTimeRep realTimeRep;


    @Resource(name = "iJuzhengImporter")
    private IJuzhengImporter iJuzhengImporter;

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
        List<SystemVo> systemVos = Lists.newArrayList();

        SewageArea sewageArea = sewageAreaRep.getOne(sewageAreaId);
        List<MonitoringSystem> monitoringSystems = monitoringRep.findBySewageArea(sewageArea);

        for (MonitoringSystem monitoringSystem : monitoringSystems) {
            SystemVo systemVo = new SystemVo();
            systemVo.setName(monitoringSystem.getName());
            systemVo.setSystemCode(monitoringSystem.getSystemCode());
            systemVos.add(systemVo);
        }
        return systemVos;
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
        Optional<MonitoringSystem> monitoringSystem = monitoringRep.findById(systemCode);

        SystemVo systemVo = new SystemVo();
        systemVo.setSystemCode(systemCode);
        systemVo.setName(monitoringSystem.get().getName());

        return systemVo;
    }

    /**
     * 获单个集成商指标分页数据
     *
     * @param sewageAreaId
     * @param systemCode
     * @param pageable
     * @return
     */
    @Override
    public FactorPageVo getSystemFactors(String sewageAreaId, String systemCode, Pageable pageable) {
        MonitoringSystem monitoringSystem = monitoringRep.getOne(systemCode);
        Page<Factor> factorPage = factorRep.findByMonitoringSystem(monitoringSystem, pageable);
        FactorPageVo factorPageVo = FactorPageVo.generateFactorPage(factorPage);

        return factorPageVo;
    }

    /**
     * 获取集成商单个指标数据
     *
     * @param sewageAreaId
     * @param systemCode
     * @param factorCode
     * @return
     */
    @Override
    public FactorVo getSystemFactor(String sewageAreaId, String systemCode, String factorCode) {
        MonitoringSystem monitoringSystem = monitoringRep.getOne(systemCode);
        Factor factor = factorRep.findByMonitoringSystemAndCode(monitoringSystem, factorCode);
        FactorVo factorVo = new FactorVo();
        AbstractMyBeanUtils.copyProperties(factor, factorVo);

        return factorVo;
    }


    /**
     * 分页获取单个指标历史数据
     *
     * @param systemCode
     * @param factorCode
     * @param pageable
     * @return factorValuePageVo
     */
    @Override
    public FactorValuePageVo getSystemFactorHistoryValue(String systemCode, String factorCode, Pageable pageable) {
        MonitoringSystem monitoringSystem = monitoringRep.getOne(systemCode);
        Factor factor = factorRep.findByMonitoringSystemAndCode(monitoringSystem, factorCode);
        Page<History> historyPage = historyRep.findByFactor(factor, pageable);
        FactorValuePageVo factorValuePageVo = FactorValuePageVo.generate(historyPage);
        return factorValuePageVo;
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
        MonitoringSystem monitoringSystem = monitoringRep.getOne(systemCode);
        Factor factor = factorRep.findByMonitoringSystemAndCode(monitoringSystem, factorCode);
        Page<RealTime> realTimePage = realTimeRep.findByFactor(factor, pageable);
        FactorValuePageVo factorValuePageVo = FactorValuePageVo.generateReal(realTimePage);
        return factorValuePageVo;
    }

    /**
     * 获取单个指标最新数据
     *
     * @param systemCode
     * @param factorCode
     * @return
     */
    @Override
    public FactorValueVo getSystemFactorLatestValue(String systemCode, String factorCode) {
        if (systemCode.equals(Constant.JUZHENG_SYS_CODE)) {
            return getJuzhengLatestValue(factorCode);
        }
        return null;
    }

    /**
     * 获取巨正集成系统最新读数
     *
     * @param factorCode
     * @return
     */
    private FactorValueVo getJuzhengLatestValue(String factorCode) {
        JuzhengFactorVo juzhengFactorVo = iJuzhengImporter.getRealTimeData(factorCode);
        return FactorValueVo.transFrom(juzhengFactorVo.getCurrentTimeData());
    }

}
