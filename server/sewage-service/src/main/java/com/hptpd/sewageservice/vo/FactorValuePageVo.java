package com.hptpd.sewageservice.vo;

import com.google.common.collect.Lists;
import com.hptpd.sewageservice.common.util.AbstractMyBeanUtils;
import com.hptpd.sewageservice.component.PageBase;
import com.hptpd.sewageservice.domain.History;
import com.hptpd.sewageservice.domain.RealTime;
import org.springframework.data.domain.Page;


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

    public static FactorValuePageVo generate(Page<History> historyPage){
        FactorValuePageVo factorValuePageVo =new FactorValuePageVo();
        List<FactorValueVo> factorValueVoList = Lists.newArrayList();
        for (History history:historyPage){
            FactorValueVo factorValueVo =new FactorValueVo();
            AbstractMyBeanUtils.copyProperties(history,factorValueVo);
            factorValueVoList.add(factorValueVo);

        }
        factorValuePageVo.setFactorValueVos(factorValueVoList);
        factorValuePageVo.setTotal(historyPage.getTotalElements());
        factorValuePageVo.setLimit(historyPage.getNumberOfElements());
        return factorValuePageVo;
    }

    public static FactorValuePageVo generateReal(Page<RealTime> realTimePage){
        FactorValuePageVo factorValuePageVo =new FactorValuePageVo();
        List<FactorValueVo> factorValueVoList =Lists.newArrayList();
        for (RealTime realTime:realTimePage){
            FactorValueVo factorValueVo =new FactorValueVo();
            AbstractMyBeanUtils.copyProperties(realTime,factorValueVo);
            factorValueVoList.add(factorValueVo);

        }
        factorValuePageVo.setFactorValueVos(factorValueVoList);
        factorValuePageVo.setTotal(realTimePage.getTotalElements());
        factorValuePageVo.setLimit(realTimePage.getNumberOfElements());
        return factorValuePageVo;
    }
}
