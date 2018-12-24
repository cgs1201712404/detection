package com.hptpd.sewageservice.service;//package com.hptpd.sewage.service;

import com.hptpd.sewageservice.common.Constant;
import com.hptpd.sewageservice.common.util.AbstractMyBeanUtils;
import com.hptpd.sewageservice.component.Result;
import com.hptpd.sewageservice.domain.Factor;
import com.hptpd.sewageservice.domain.SewageArea;
import com.hptpd.sewageservice.domain.system.MonitoringSystem;
import com.hptpd.sewageservice.repository.FactorRep;
import com.hptpd.sewageservice.repository.IntegrationSystemRep;
import com.hptpd.sewageservice.repository.SewageAreaRep;
import com.hptpd.sewageservice.service.feign.ICentralPivotService;
import com.hptpd.sewageservice.vo.ServiceAreaVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 14:38
 * \* Description:
 * \
 */
@Component("sewageAreaInitializer")
public class SewageAreaInitializer {

    private Logger logger = LoggerFactory.getLogger(SewageAreaInitializer.class);

    @Resource(name = "sewageAreaRep")
    private SewageAreaRep sewageAreaRep;

    @Resource(name = "factorRep")
    private FactorRep factorRep;

    @Resource(name = "integrationSystemRep")
    private IntegrationSystemRep integrationSystemRep;

    @Autowired
    private ICentralPivotService feignService;

    public void sewageAreaInit() {
        SewageArea dongxiLake = dongxiLakeStationInit();
        dongxiLakeFactorsInit(dongxiLake);
        ServiceAreaVo dongxiLakeVo = new ServiceAreaVo();
        AbstractMyBeanUtils.copyProperties(dongxiLake, dongxiLakeVo);
        dongxiLakeVo.setSewageId(dongxiLake.getCode());
        Result result = feignService.addAreaWithSewage(dongxiLakeVo);
        logger.info(result.toString());
    }

    private SewageArea dongxiLakeStationInit() {
        Optional<SewageArea> sewageAreaOptional = sewageAreaRep.findById("JZ000000000001");
        if (sewageAreaOptional.isPresent()) {
            return sewageAreaOptional.get();
        }
        SewageArea sewageArea = new SewageArea();
        // 东西湖废水监测点通信标志
        sewageArea.setCode("JZ000000000001");
        sewageArea.setName("东西湖废水监测点");
        sewageArea.setLon(BigDecimal.valueOf(114.047554));
        sewageArea.setLat(BigDecimal.valueOf(30.706936));
        return sewageAreaRep.save(sewageArea);
    }

    private void dongxiLakeFactorsInit(SewageArea sewageArea) {
        MonitoringSystem monitoringSystem = juzhengSystemInit(sewageArea);
        pHInit(monitoringSystem);
        codInit(monitoringSystem);
        nH3NInit(monitoringSystem);
        tPInit(monitoringSystem);
        sSInit(monitoringSystem);
        flowInit(monitoringSystem);
    }

    private MonitoringSystem juzhengSystemInit(SewageArea sewageArea) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        monitoringSystem.setName(Constant.JUZHENG_SYS_NAME);
        monitoringSystem.setSystemCode(Constant.JUZHENG_SYS_CODE);
        monitoringSystem.setSewageArea(sewageArea);
        integrationSystemRep.save(monitoringSystem);
        return monitoringSystem;
    }

    private Factor pHInit(MonitoringSystem monitoringSystem) {
        Factor factor = new Factor();
        factor.setCode("pH");
        factor.setName("PH");
        factor.setMinValue(BigDecimal.valueOf(6));
        factor.setMaxValue(BigDecimal.valueOf(9));
        factor.setSensorID("001");
        factor.setMonitoringSystem(monitoringSystem);
        factorRep.save(factor);
        return factor;
    }

    private Factor codInit(MonitoringSystem monitoringSystem) {
        Factor factor = new Factor();
        factor.setCode("cod");
        factor.setName("COD");
        factor.setMaxValue(BigDecimal.valueOf(60));
        factor.setSensorID("011");
        factor.setUnit("mg/L");
        factor.setMonitoringSystem(monitoringSystem);
        factorRep.save(factor);
        return factor;
    }

    private Factor nH3NInit(MonitoringSystem monitoringSystem) {
        Factor factor = new Factor();
        factor.setCode("nH3N");
        factor.setName("氨氮");
        factor.setMaxValue(BigDecimal.valueOf(15));
        factor.setSensorID("060");
        factor.setUnit("mg/L");
        factor.setMonitoringSystem(monitoringSystem);
        factorRep.save(factor);
        return factor;
    }

    private Factor tPInit(MonitoringSystem monitoringSystem) {
        Factor factor = new Factor();
        factor.setCode("tP");
        factor.setName("总磷");
        factor.setMaxValue(BigDecimal.valueOf(0.5));
        factor.setSensorID("101");
        factor.setUnit("mg/L");
        factor.setMonitoringSystem(monitoringSystem);
        factorRep.save(factor);
        return factor;
    }

    private Factor sSInit(MonitoringSystem monitoringSystem) {
        Factor factor = new Factor();
        factor.setCode("sS");
        factor.setName("悬浮物");
        factor.setMaxValue(BigDecimal.valueOf(70));
        factor.setSensorID("003");
        factor.setUnit("mg/L");
        factor.setMonitoringSystem(monitoringSystem);
        factorRep.save(factor);
        return factor;
    }

    private Factor flowInit(MonitoringSystem monitoringSystem) {
        Factor factor = new Factor();
        factor.setCode("flow");
        factor.setName("流量");
        factor.setSensorID("B01");
        factor.setUnit("l/s");
        factor.setMonitoringSystem(monitoringSystem);
        factorRep.save(factor);
        return factor;
    }
}
