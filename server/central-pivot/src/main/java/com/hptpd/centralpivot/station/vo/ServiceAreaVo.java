package com.hptpd.centralpivot.station.vo;

import com.google.common.collect.Lists;
import com.hptpd.centralpivot.common.util.AbstractMyBeanUtils;
import com.hptpd.centralpivot.station.domain.ServiceArea;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 17:42
 * \* Description:
 * \
 */
@Data
public class ServiceAreaVo {

    /**
     * 监测点编码
     */
    private String code;

    /**
     * 监测点名称
     */
    private String name;

    /**
     * 经度
     */
    private BigDecimal lon;

    /**
     * 纬度
     */
    private BigDecimal lat;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在地区
     */
    private String district;

    /**
     * 污水服务区id
     */
    private String sewageId;

    public static ServiceAreaVo toVo(ServiceArea serviceArea) {
        ServiceAreaVo serviceAreaVo = new ServiceAreaVo();
        AbstractMyBeanUtils.copyProperties(serviceArea, serviceAreaVo);
        if (serviceArea.getServiceAreaRelation() != null) {
            serviceAreaVo.setSewageId(serviceArea.getServiceAreaRelation().getSewageAreaId());
        }
        return serviceAreaVo;
    }

    public static List<ServiceAreaVo> toVos(Collection<ServiceArea> serviceAreas) {
        List<ServiceAreaVo> serviceAreaVos = Lists.newLinkedList();
        for (ServiceArea serviceArea: serviceAreas) {
            ServiceAreaVo serviceAreaVo = toVo(serviceArea);
            serviceAreaVos.add(serviceAreaVo);
        }
        return serviceAreaVos;
    }
}
