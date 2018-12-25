package com.hptpd.sewageservice.service.feign;

import com.hptpd.sewageservice.component.Result;
import com.hptpd.sewageservice.vo.ServiceAreaVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 11:14
 * \* Description: 污水服务调用中心服务(central-pivot)单元接口
 * \
 */
@FeignClient(name = "central-pivot")
public interface ICentralPivotService {

    /**
     * 调用central-pivot服务中添加服务区的接口
     * 前置条件：需要启动中心服务和服务注册单元
     *
     * @param serviceAreaVo
     * @return
     */
    @RequestMapping(value = "/station/service_areas", method = RequestMethod.PUT)
    Result addAreaWithSewage(@RequestBody ServiceAreaVo serviceAreaVo);
}
