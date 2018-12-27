package com.hptpd.sewageservice.vo;

import com.google.common.collect.Lists;
import com.hptpd.sewageservice.common.util.AbstractMyBeanUtils;
import com.hptpd.sewageservice.component.PageBase;
import com.hptpd.sewageservice.domain.Factor;
import org.springframework.data.domain.Page;

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

    public static FactorPageVo generateFactorPage(Page<Factor> factorPage){
        FactorPageVo factorPageVo =new FactorPageVo();
        List<FactorVo> factorVos = Lists.newArrayList();
        for (Factor factor:factorPage){
            FactorVo factorVo =new FactorVo();
            AbstractMyBeanUtils.copyProperties(factor,factorVo);
            factorVos.add(factorVo);
        }
        factorPageVo.setFactorVos(factorVos);
        factorPageVo.setTotal(factorPage.getTotalElements());
        factorPageVo.setLimit(factorPage.getNumberOfElements());
        return factorPageVo;
    }

}
