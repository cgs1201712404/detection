package com.hptpd.sewageservice.vo;

import com.hptpd.sewageservice.component.PageBase;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/25
 * \* @time: 10:12
 * \* Description:
 * \
 */
public class FactorPageVo extends PageBase {

    private List<FactorVo> factorVos;

    public List<FactorVo> getFactorVos() {
        return factorVos;
    }

    public void setFactorVos(List<FactorVo> factorVos) {
        this.factorVos = factorVos;
    }

}
