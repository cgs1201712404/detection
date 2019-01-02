package com.hptpd.centralpivot.station.service;

import com.hptpd.centralpivot.common.util.AbstractMyBeanUtils;
import com.hptpd.centralpivot.common.util.JsonUtil;
import com.hptpd.centralpivot.component.Result;
import com.hptpd.centralpivot.station.domain.ServiceArea;
import com.hptpd.centralpivot.station.domain.ServiceAreaRelation;
import com.hptpd.centralpivot.station.repository.ServiceAreaRelationRep;
import com.hptpd.centralpivot.station.repository.ServiceAreaRep;
import com.hptpd.centralpivot.station.vo.ServiceAreaVo;
import com.hptpd.centralpivot.station.vo.app.ServiceMarker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 17:51
 * \* Description:
 * \
 */
@Service("stationService")
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
        return Result.setResult(Result.SUCCESS, "添加污水服务区成功！",
                JsonUtil.objectToJson(serviceAreaVo));
    }

    /**
     * 获取服务区列表
     *
     * @return
     */
    @Override
    public List<ServiceAreaVo> getServiceAreas() {
        return ServiceAreaVo.toVos(serviceAreaRep.findAll());
    }

    /**
     * 获取服务区列表（APP端）
     *
     * @return
     */
    @Override
    public List<ServiceMarker> getServicesMarkers() {
        List<ServiceMarker> serviceMarkers =ServiceMarker.genarate(serviceAreaRep.findAll());

        return serviceMarkers;
    }


    /**
     * 通过id获取服务区基本数据（对于污水服务区相关数据分两次请求）
     *
     * @param id
     * @return
     */
    @Override
    public ServiceAreaVo getServiceArea(String id) {
        Optional<ServiceArea> serviceAreaOptional = serviceAreaRep.findById(id);
        return serviceAreaOptional.map(ServiceAreaVo::toVo).orElse(null);
    }

    private ServiceArea addStation(ServiceAreaVo serviceAreaVo) {
        ServiceArea serviceArea = new ServiceArea();
        AbstractMyBeanUtils.copyProperties(serviceAreaVo, serviceArea);
        addServiceAreaRelationRep(serviceArea, serviceAreaVo.getSewageId());
        serviceAreaRep.save(serviceArea);
        return serviceArea;
    }

    private ServiceAreaRelation addServiceAreaRelationRep(ServiceArea serviceArea, String sewageId) {
        ServiceAreaRelation serviceAreaRelation = new ServiceAreaRelation();
        serviceAreaRelation.setServiceArea(serviceArea);
        serviceArea.setServiceAreaRelation(serviceAreaRelation);
        serviceAreaRelation.setSewageAreaId(sewageId);
        return serviceAreaRelation;
    }
}
