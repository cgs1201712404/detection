package com.hptpd.sewageservice.domain.system;

import com.google.common.collect.Sets;
import com.hptpd.sewageservice.domain.Factor;
import com.hptpd.sewageservice.domain.SewageArea;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 14:54
 * \* Description: 污水监测设备集成商系统
 * \
 */
@Entity
@DiscriminatorValue("monitoring")
@Data
@EqualsAndHashCode(callSuper = true)
public class MonitoringSystem extends BaseIntegrationSystem {

    @ManyToOne
    private SewageArea sewageArea;

    @OneToMany(mappedBy = "monitoringSystem")
    private Set<Factor> factors = Sets.newLinkedHashSet();
}
