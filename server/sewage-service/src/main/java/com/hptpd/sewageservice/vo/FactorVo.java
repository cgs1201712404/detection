package com.hptpd.sewageservice.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/25
 * \* @time: 10:06
 * \* Description:
 * \
 */
@Data
public class FactorVo {

    private String id;

    /**
     * 因子编码
     */
    private String code;

    /**
     * 因子名称
     */
    private String name;

    /**
     * 最大值
     */
    private BigDecimal maxValue;

    /**
     * 最小值
     */
    private BigDecimal minValue;

    /**
     * 单位
     */
    private String unit;

    /**
     * 传感器编号
     */
    private String sensorID;
}
