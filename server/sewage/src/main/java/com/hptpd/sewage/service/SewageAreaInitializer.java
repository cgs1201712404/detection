package com.hptpd.sewage.service;

import com.hptpd.sewage.domain.Factor;
import com.hptpd.sewage.domain.SewageArea;
import com.hptpd.sewage.repository.FactorRep;
import com.hptpd.sewage.repository.SewageAreaRep;
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

    @Resource(name = "sewageAreaRep")
    private SewageAreaRep sewageAreaRep;

    @Resource(name = "factorRep")
    private FactorRep factorRep;

    public void sewageAreaInit() {
        SewageArea dongxiLake = dongxiLakeStationInit();
        dongxiLakeFactorsInit(dongxiLake);
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
        pHInit(sewageArea);
        codInit(sewageArea);
        nH3NInit(sewageArea);
        tPInit(sewageArea);
        sSInit(sewageArea);
        flowInit(sewageArea);
    }

    private Factor pHInit(SewageArea sewageArea) {
        Factor factor = new Factor();
        factor.setCode("pH");
        factor.setName("PH");
        factor.setMinValue(BigDecimal.valueOf(6));
        factor.setMaxValue(BigDecimal.valueOf(9));
        factor.setSensorID("001");
        factor.setSewageArea(sewageArea);
        factorRep.save(factor);
        return factor;
    }

    private Factor codInit(SewageArea sewageArea) {
        Factor factor = new Factor();
        factor.setCode("cod");
        factor.setName("COD");
        factor.setMaxValue(BigDecimal.valueOf(60));
        factor.setSensorID("011");
        factor.setUnit("mg/L");
        factor.setSewageArea(sewageArea);
        factorRep.save(factor);
        return factor;
    }

    private Factor nH3NInit(SewageArea sewageArea) {
        Factor factor = new Factor();
        factor.setCode("nH3N");
        factor.setName("氨氮");
        factor.setMaxValue(BigDecimal.valueOf(15));
        factor.setSensorID("060");
        factor.setUnit("mg/L");
        factor.setSewageArea(sewageArea);
        factorRep.save(factor);
        return factor;
    }

    private Factor tPInit(SewageArea sewageArea) {
        Factor factor = new Factor();
        factor.setCode("tP");
        factor.setName("总磷");
        factor.setMaxValue(BigDecimal.valueOf(0.5));
        factor.setSensorID("101");
        factor.setUnit("mg/L");
        factor.setSewageArea(sewageArea);
        factorRep.save(factor);
        return factor;
    }

    private Factor sSInit(SewageArea sewageArea) {
        Factor factor = new Factor();
        factor.setCode("sS");
        factor.setName("悬浮物");
        factor.setMaxValue(BigDecimal.valueOf(70));
        factor.setSensorID("003");
        factor.setUnit("mg/L");
        factor.setSewageArea(sewageArea);
        factorRep.save(factor);
        return factor;
    }

    private Factor flowInit(SewageArea sewageArea) {
        Factor factor = new Factor();
        factor.setCode("flow");
        factor.setName("流量");
        factor.setSensorID("B01");
        factor.setUnit("l/s");
        factor.setSewageArea(sewageArea);
        factorRep.save(factor);
        return factor;
    }
}
