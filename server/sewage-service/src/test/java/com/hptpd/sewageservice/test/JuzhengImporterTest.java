package com.hptpd.sewageservice.test;

import com.hptpd.sewageservice.service.component.IJuzhengImporter;
import com.hptpd.sewageservice.vo.JuzhengFactorVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 19:13
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JuzhengImporterTest {

    private Logger logger = LoggerFactory.getLogger(JuzhengImporterTest.class);

    @Resource(name = "iJuzhengImporter")
    private IJuzhengImporter iJuzhengImporter;

    @Test
    public void getHistoryDataTest() {
        JuzhengFactorVo juzhengFactorVo = iJuzhengImporter.
                getHistoryData(2018, 12, "cod");
        logger.info(juzhengFactorVo.getHistoryData().toString());
        Assert.assertNotNull(juzhengFactorVo.getHistoryData());
    }
}
