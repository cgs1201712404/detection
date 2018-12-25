package com.hptpd.sewageservice.vo;

import com.hptpd.sewageservice.component.PageBase;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/25
 * \* @time: 10:24
 * \* Description: 监测因子对应数据分页Vo
 * \
 */
public class FactorValuePageVo extends PageBase {

    private List<FactorValueVo> factorValueVos;

    public List<FactorValueVo> getFactorValueVos() {
        return factorValueVos;
    }

    public void setFactorValueVos(List<FactorValueVo> factorValueVos) {
        this.factorValueVos = factorValueVos;
    }
}
