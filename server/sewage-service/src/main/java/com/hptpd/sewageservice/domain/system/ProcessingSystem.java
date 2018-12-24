package com.hptpd.sewageservice.domain.system;

import com.hptpd.sewageservice.domain.SewageArea;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 14:55
 * \* Description: 污水处理设备集成商系统
 * \
 */
@Entity
@DiscriminatorValue("processing")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProcessingSystem extends BaseIntegrationSystem {

    @ManyToOne
    private SewageArea sewageArea;

}
