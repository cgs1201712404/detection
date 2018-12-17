package com.hptpd.sewage.vo;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 19:42
 * \* Description: 巨正监测数据项实体
 * \
 */
@Data
public class JuzhengData {

    /**
     * JCYZ_BM
     */
    private String jCYZBM;

    /**
     * TXBZ
     */
    private String tXBZ;

    private String dataTime;

    private String aValue;

    private String cValue;

    private String dataFlag;
}
