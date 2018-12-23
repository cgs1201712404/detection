package com.hptpd.centralpivot.station.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 17:06
 * \* Description: 服务区关系实体
 * \
 */
@Data
@Entity
@Table(name = "sewage_area_relation")
public class ServiceAreaRelation {

    @Id
    private String id;

    @OneToOne
    private ServiceArea serviceArea;

    @Column(name="sewage_id", nullable = false)
    private String sewageAreaId;
}
