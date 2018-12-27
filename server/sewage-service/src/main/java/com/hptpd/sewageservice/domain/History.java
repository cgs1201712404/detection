package com.hptpd.sewageservice.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 11:14
 * \* Description: 污水监测历史数据（按月分表？暂时不定）
 * \
 */
@Data
@Entity
@Table(name = "history_data")
public class History {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    /**
     * 记录时间
     */
    private Date time;

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
