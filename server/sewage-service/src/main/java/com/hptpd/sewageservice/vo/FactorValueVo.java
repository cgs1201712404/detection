package com.hptpd.sewageservice.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/25
 * \* @time: 10:22
 * \* Description: 监测因子对应数据Vo
 * \
 */
@Data
public class FactorValueVo {

    private String id;

    /**
     * 记录时间
     */
    private String time;

    /**
     * 标识
     */
    private String flag;

    /**
     * 记录值
     */
    private BigDecimal value;
}
