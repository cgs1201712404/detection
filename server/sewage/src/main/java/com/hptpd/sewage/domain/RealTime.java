package com.hptpd.sewage.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 11:26
 * \* Description: 污水监测实时数据（当日数据）
 * \
 */
@Data
@Entity
@Table(name = "realtime_data")
public class RealTime {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
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

    @ManyToOne
    private Factor factor;


}
