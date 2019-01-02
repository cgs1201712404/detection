package com.hptpd.centralpivot.station.vo.app;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Coordinate {

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;
}
