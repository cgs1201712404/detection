package com.hptpd.sewageservice.controller;

import com.hptpd.sewageservice.service.ISewageAreaService;
import com.hptpd.sewageservice.vo.FactorPageVo;
import com.hptpd.sewageservice.vo.FactorValueVo;
import com.hptpd.sewageservice.vo.SystemVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/25
 * \* @time: 9:47
 * \* Description: 污水服务区controller
 * \
 */
@RestController
@RequestMapping("/sewage")
public class SewageController {

    private Logger logger = LoggerFactory.getLogger(SewageController.class);

    @Resource(name = "sewageAreaService")
    private ISewageAreaService iSewageAreaService;

    @RequestMapping(value = "/{id}/systems", method = RequestMethod.GET)
    public List<SystemVo> getAreaSystems(@PathVariable String id) {
        List<SystemVo> systemVos = iSewageAreaService.getAreaSystems(id);
        logger.info(systemVos.toString());
        return systemVos;
    }

    @RequestMapping(value = "/{id}/system/{systemCode}", method = RequestMethod.GET)
    public SystemVo getAreaSystem(@PathVariable String id, @PathVariable String systemCode) {
        SystemVo systemVo = iSewageAreaService.getAreaSystem(id, systemCode);
        logger.info(systemVo.toString());
        return systemVo;
    }

    @RequestMapping(value = "/{id}/system/{systemCode}/factors", method = RequestMethod.GET)
    public FactorPageVo getSystemFactors(@PathVariable String id, @PathVariable String systemCode,
                                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        FactorPageVo factorPageVo = iSewageAreaService.getSystemFactors(id, systemCode, pageable);
        logger.info(factorPageVo.toString());
        return factorPageVo;
    }

    @RequestMapping(value = "/{id}/system/{systemCode}/factor/{factorCode}/latest", method = RequestMethod.GET)
    public FactorValueVo getSystemFactorLatestValue(@PathVariable String id,
                                                    @PathVariable String systemCode, @PathVariable String factorCode) {
        FactorValueVo factorValueVo = iSewageAreaService.getSystemFactorLatestValue(systemCode, factorCode);
        logger.info(factorValueVo.toString());
        return factorValueVo;
    }
}
