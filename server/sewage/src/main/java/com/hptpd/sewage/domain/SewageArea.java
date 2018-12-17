package com.hptpd.sewage.domain;

import com.google.common.collect.Sets;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 8:33
 * \* Description: 污水服务区实体，对应中心服务中的服务区实体
 * \
 */
@Data
@Entity
@Table(name = "sewage_area")
public class SewageArea {

    /**
     * 监测点编码
     * 说明（对应巨正系统中的通信标志TXBZ）
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
     * 所在省份
     */
    @Column(name = "province")
    private String province;

    /**
     * 所在城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 所在地区
     */
    @Column(name = "district")
    private String district;

    @OneToMany(mappedBy = "sewageArea",fetch = FetchType.EAGER)
    private Set<Factor> factors = Sets.newLinkedHashSet();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SewageArea that = (SewageArea) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lon, that.lon) &&
                Objects.equals(lat, that.lat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, lon, lat);
    }
}
