package com.hptpd.centralpivot.station;

import com.hptpd.centralpivot.component.Result;
import com.hptpd.centralpivot.station.domain.ServiceAreaRelation;
import com.hptpd.centralpivot.station.repository.ServiceAreaRelationRep;
import com.hptpd.centralpivot.station.service.IStationService;
import com.hptpd.centralpivot.station.vo.ServiceAreaVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 18:02
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StationServiceTest {

    private Logger logger = LoggerFactory.getLogger(StationServiceTest.class);

    @Resource
    private IStationService stationService;

    @Resource
    private ServiceAreaRelationRep serviceAreaRelationRep;

    @Test
    public void addStationWithSewageTest() {
        ServiceAreaVo serviceAreaVo = new ServiceAreaVo();
        serviceAreaVo.setCode("10000000000001");
        serviceAreaVo.setName("东西湖废水监测点");
        serviceAreaVo.setLat(BigDecimal.valueOf(30.706936));
        serviceAreaVo.setLon(BigDecimal.valueOf(114.047554));
        serviceAreaVo.setSewageId("10000000000001");
        Result result = stationService.addStationWithSewage(serviceAreaVo);
        logger.info(result.toString());
        Optional<ServiceAreaRelation> serviceAreaRelationOptional =
                serviceAreaRelationRep.findBySewageAreaId("10000000000001");
        serviceAreaRelationOptional.ifPresent(Assert::assertNotNull);
    }

    @Test
    public void getServiceAreasTest() {
        List<ServiceAreaVo> serviceAreaVos = stationService.getServiceAreas();
        logger.info(serviceAreaVos.toString());
        Assert.assertEquals(serviceAreaVos.size(), 1);
    }
}
