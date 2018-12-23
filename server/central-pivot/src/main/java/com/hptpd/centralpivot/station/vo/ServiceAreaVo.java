package com.hptpd.centralpivot.station.vo;

import lombok.Data;

import java.math.BigDecimal;

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
     * 污水服务区id
     */
    private String sewageId;
}
