package com.hptpd.sewageservice.vo;

import com.hptpd.sewageservice.common.util.DateUtil;
import com.hptpd.sewageservice.vo.juzheng.JuzhengData;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
    private Date time;

    /**
     * 标识
     */
    private String flag;

    /**
     * 记录值
     */
    private BigDecimal value;


    public static FactorValueVo transFrom(JuzhengData juzhengData) {
        if (null != juzhengData) {
            FactorValueVo factorValueVo = new FactorValueVo();
            factorValueVo.setValue(new BigDecimal(juzhengData.getAValue()));
            factorValueVo.setFlag(juzhengData.getDataFlag());
            factorValueVo.setTime(DateUtil.stringToDate(juzhengData.getDataTime(),
                    DateUtil.FMT_YYYYMMDDHHMMSS));
            return factorValueVo;
        }
        return null;
    }
}
