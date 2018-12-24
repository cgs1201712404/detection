package com.hptpd.centralpivot.station.controller;

import com.hptpd.centralpivot.component.Result;
import com.hptpd.centralpivot.station.service.IStationService;
import com.hptpd.centralpivot.station.vo.ServiceAreaVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 10:45
 * \* Description: 监测点（服务区和收费站）controller
 * \
 */
@RestController
@RequestMapping("/station")
public class StationController {

    private Logger logger = LoggerFactory.getLogger(StationController.class);

    @Resource
    private IStationService stationService;

    @RequestMapping(value = "/service_area", method = RequestMethod.PUT)
    public Result addAreaWithSewage(@RequestBody ServiceAreaVo serviceAreaVo) {
        Result result = stationService.addStationWithSewage(serviceAreaVo);
        logger.info(result.toString());
        return result;
    }

    /**
     * 获取服务区列表
     * @return
     */
    @RequestMapping(value = "/service_area", method = RequestMethod.GET)
    public List<ServiceAreaVo> getServiceAreas() {
        List<ServiceAreaVo> serviceAreaVos = stationService.getServiceAreas();
        logger.info(serviceAreaVos.toString());
        return serviceAreaVos;
    }
}
