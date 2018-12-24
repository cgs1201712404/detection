package com.hptpd.sewageservice.service.feign;

import com.hptpd.sewageservice.component.Result;
import com.hptpd.sewageservice.vo.ServiceAreaVo;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 11:17
 * \* Description:
 * \
 */
@Component
public class CentralPivotFallback implements ICentralPivotService {

    /**
     * 调用central-pivot服务中添加服务区的接口
     *
     * @param serviceAreaVo
     * @return
     */
    @Override
    public Result addAreaWithSewage(ServiceAreaVo serviceAreaVo) {
        return Result.setResult(Result.ERROR, "内部网络错误！");
    }
}
