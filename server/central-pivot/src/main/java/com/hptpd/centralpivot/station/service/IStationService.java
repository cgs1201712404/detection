package com.hptpd.centralpivot.station.service;

import com.hptpd.centralpivot.component.Result;
import com.hptpd.centralpivot.station.vo.ServiceAreaVo;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 17:36
 * \* Description: 监测点业务逻辑service层类
 * \
 */
public interface IStationService {

    /**
     * 添加污水服务区级联建立主服务区
     *
     * @param serviceAreaVo
     * @return
     */
    Result addStationWithSewage(ServiceAreaVo serviceAreaVo);

    /**
     * 获取服务区列表
     *
     * @return
     */
    List<ServiceAreaVo> getServiceAreas();

}
