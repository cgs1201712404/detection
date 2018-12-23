package com.hptpd.centralpivot.station.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/16
 * \* @time: 21:45
 * \* Description: 服务区类
 * \
 */
@Entity
@DiscriminatorValue("service_area")
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceArea extends BaseMonitoringStation {

    /**
     * 服务区关系
     */
    @OneToOne(mappedBy = "serviceArea")
    private ServiceAreaRelation serviceAreaRelation;
}
