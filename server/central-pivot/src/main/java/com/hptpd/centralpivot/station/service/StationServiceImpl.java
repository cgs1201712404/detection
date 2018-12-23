package com.hptpd.centralpivot.station.service;

import com.hptpd.centralpivot.common.util.AbstractMyBeanUtils;
import com.hptpd.centralpivot.component.Result;
import com.hptpd.centralpivot.station.domain.ServiceArea;
import com.hptpd.centralpivot.station.domain.ServiceAreaRelation;
import com.hptpd.centralpivot.station.repository.ServiceAreaRelationRep;
import com.hptpd.centralpivot.station.repository.ServiceAreaRep;
import com.hptpd.centralpivot.station.vo.ServiceAreaVo;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 17:51
 * \* Description:
 * \
 */
public class StationServiceImpl implements IStationService {

    @Resource(name = "serviceAreaRep")
    private ServiceAreaRep serviceAreaRep;

    @Resource(name = "serviceAreaRelationRep")
    private ServiceAreaRelationRep serviceAreaRelationRep;

    /**
     * 添加污水服务区级联建立主服务区
     *
     * @param serviceAreaVo
     * @return
     */
    @Override
    public Result addStationWithSewage(ServiceAreaVo serviceAreaVo) {
        ServiceArea serviceArea = addStation(serviceAreaVo);

        return null;
    }

    private ServiceArea addStation(ServiceAreaVo serviceAreaVo) {
        ServiceArea serviceArea = new ServiceArea();
        AbstractMyBeanUtils.copyProperties(serviceAreaVo, serviceArea);
        serviceAreaRep.save(serviceArea);
        return serviceArea;
    }

    private ServiceAreaRelation addServiceAreaRelationRep(ServiceArea serviceArea, String sewageId) {


        return null;
    }
}
