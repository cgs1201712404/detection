package com.hptpd.sewageservice.vo.juzheng;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 19:33
 * \* Description: 巨正系统因子Vo类
 * \
 */
@Data
public class JuzhengFactorVo {

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
     * JCYZ_BM
     */
    private String jCYZBM;

    /**
     * 实时数据
     */
    private JuzhengData currentTimeData;

    /**
     * 历史数据
     */
    private List<JuzhengData> historyData;
}
