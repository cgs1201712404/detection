package com.hptpd.sewageservice.generate;

import com.hptpd.sewageservice.domain.SewageArea;
import com.hptpd.sewageservice.repository.SewageAreaRep;
import com.hptpd.sewageservice.service.ISewageAreaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 11:38
 * \* Description: 污水服务数据初始化工作（暂时包括污水服务区初始化）
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInit {

    @Resource(name = "sewageAreaService")
    private ISewageAreaService sewageAreaService;

    @Resource(name = "sewageAreaRep")
    private SewageAreaRep sewageAreaRep;

    @Test
    public void sewageAreaInitTest() {

        sewageAreaService.sewageAreaInit();
        Optional<SewageArea> sewageAreaOptional = sewageAreaRep.findById("JZ000000000001");
        if (sewageAreaOptional.isPresent()) {
            Assert.assertEquals(sewageAreaOptional.get().getName(), "东西湖废水监测点");
//            Assert.assertSame(sewageAreaOptional.get().getFactors().size(), 6);
        }
    }

}
