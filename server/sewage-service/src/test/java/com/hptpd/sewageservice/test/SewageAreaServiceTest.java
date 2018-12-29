package com.hptpd.sewageservice.test;

import com.hptpd.sewageservice.common.Constant;
import com.hptpd.sewageservice.domain.Factor;
import com.hptpd.sewageservice.service.ISewageAreaService;
import com.hptpd.sewageservice.vo.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/29
 * \* @time: 9:10
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SewageAreaServiceTest {

    private Logger logger = LoggerFactory.getLogger(SewageAreaServiceTest.class);

    @Resource(name = "sewageAreaService")
    private ISewageAreaService sewageAreaService;

    @Test
    public void getAreaSystemsTest() {
        List<SystemVo> systemVos = sewageAreaService.getAreaSystems("JZ000000000001");
        logger.info(systemVos.toString());
        Assert.assertEquals(systemVos.size(), 1);
    }

    @Test
    public void getAreaSystemTest() {
        SystemVo systemVo = sewageAreaService.getAreaSystem("JZ000000000001",
                "juzheng_dongxilake");
        Assert.assertEquals(systemVo.getName(), "巨正监测系统");
    }

    @Test
    public void getSystemFactorsTest() {
        FactorPageVo factorPageVo = sewageAreaService.getSystemFactors("JZ000000000001",
                "juzheng_dongxilake", PageRequest.of(0, 10));
        Assert.assertEquals(factorPageVo.getFactorVos().size(), 6);
        Assert.assertEquals(factorPageVo.getTotal(), Long.valueOf(6));
    }

    @Test
    public void getSystemFactor() {
        FactorVo factorVo = sewageAreaService.getSystemFactor("JZ000000000001",
                Constant.JUZHENG_SYS_CODE, Constant.SYSTEM_PH);
        Assert.assertEquals(factorVo.getName(), Constant.PH);
    }

    @Test
    public void getSystemFactorHistoryValueTest() {
        FactorValuePageVo factorValuePageVo = sewageAreaService.getSystemFactorHistoryValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_PH, PageRequest.of(0, 10));
        logger.info(factorValuePageVo.getFactorValueVos().toString());
        Assert.assertNotNull(factorValuePageVo.getFactorValueVos());
    }

    @Test
    public void getSystemFactorRealTimeValueTest() {
        FactorValuePageVo factorValuePageVo = sewageAreaService.getSystemFactorRealTimeValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_PH, PageRequest.of(0, 10));
        logger.info(factorValuePageVo.getFactorValueVos().toString());
        Assert.assertNotNull(factorValuePageVo.getFactorValueVos());
    }

    @Test
    public void getSystemFactorLatestValueTest() {
        FactorValueVo ph = sewageAreaService.getSystemFactorLatestValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_PH);
        FactorValueVo cod = sewageAreaService.getSystemFactorLatestValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_COD);
        FactorValueVo nh3n = sewageAreaService.getSystemFactorLatestValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_NH3N);
        FactorValueVo ss = sewageAreaService.getSystemFactorLatestValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_SS);
        FactorValueVo tp = sewageAreaService.getSystemFactorLatestValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_TP);
        FactorValueVo flow = sewageAreaService.getSystemFactorLatestValue(Constant.JUZHENG_SYS_CODE,
                Constant.SYSTEM_FLOW);
        Assert.assertNotNull(ph);
        Assert.assertNotNull(cod);
        Assert.assertNotNull(nh3n);
        Assert.assertNotNull(ss);
        Assert.assertNotNull(tp);
        Assert.assertNotNull(flow);
    }
}
