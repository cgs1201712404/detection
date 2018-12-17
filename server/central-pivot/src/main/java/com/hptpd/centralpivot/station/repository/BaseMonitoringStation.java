package com.hptpd.centralpivot.station.repository;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/16
 * \* @time: 21:38
 * \* Description: 服务区、收费站的基类
 * \
 */
@Entity
@Table(name = "monitor_station")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
@Data
public abstract class BaseMonitoringStation {

    /**
     * 监测点编码
     */
    @Id
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
     * 状态：normal 或者 alarm
     * 正常或报警
     */
    private Short state;
}