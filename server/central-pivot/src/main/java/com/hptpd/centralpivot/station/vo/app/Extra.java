package com.hptpd.centralpivot.station.vo.app;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Extra {


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
     * 所在省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;
    /**
     * 所在地区
     */
    private String county;


    private Boolean state;

    /**
     * 污水服务区id
     */
    private String sewageId;
}
