package com.hptpd.sewageservice.domain;

import com.google.common.collect.Sets;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 8:38
 * \* Description: 监测因子
 * \
 */
@Data
@Entity
@Table(name = "monitor_factor")
public class Factor {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
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
    @Column(name = "max_value")
    private BigDecimal maxValue;

    /**
     * 最小值
     */
    @Column(name = "min_value")
    private BigDecimal minValue;

    /**
     * 单位
     */
    private String unit;

    /**
     * 传感器编号
     */
    @Column(name = "sensor_id")
    private String sensorID;

    @ManyToOne
    private SewageArea sewageArea;

    @OneToMany(mappedBy = "factor")
    private Set<History> histories = Sets.newLinkedHashSet();

    @OneToMany(mappedBy = "factor")
    private Set<RealTime> realTimes = Sets.newLinkedHashSet();


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Factor factor = (Factor) o;
        return Objects.equals(id, factor.id) &&
                Objects.equals(code, factor.code) &&
                Objects.equals(name, factor.name) &&
                Objects.equals(maxValue, factor.maxValue) &&
                Objects.equals(minValue, factor.minValue) &&
                Objects.equals(unit, factor.unit) &&
                Objects.equals(sensorID, factor.sensorID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, maxValue, minValue, unit, sensorID);
    }
}
