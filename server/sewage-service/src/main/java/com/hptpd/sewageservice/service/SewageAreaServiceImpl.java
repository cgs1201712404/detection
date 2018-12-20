package com.hptpd.sewageservice.service;//package com.hptpd.sewage.service;

import com.hptpd.sewageservice.repository.FactorRep;
import com.hptpd.sewageservice.repository.SewageAreaRep;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 14:35
 * \* Description:
 * \
 */
@Service("sewageAreaService")
public class SewageAreaServiceImpl implements ISewageAreaService {

    @Resource(name = "sewageAreaInitializer")
    private SewageAreaInitializer sewageAreaInitializer;

    @Resource(name = "sewageAreaRep")
    private SewageAreaRep sewageAreaRep;

    @Resource(name = "factorRep")
    private FactorRep factorRep;

    /**
     * 污水服务区数据初始化
     */
    @Override
    public void sewageAreaInit() {
        sewageAreaInitializer.sewageAreaInit();
    }


}
