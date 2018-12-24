package com.hptpd.centralpivot.station.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    @OneToOne
    @JoinColumn(name = "servicearea_id")
    private ServiceArea serviceArea;

    @Column(name="sewage_id")
    private String sewageAreaId;
}
