/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @date: 2018/12/25
 \* @time: 15:22
 \* Description: 监测点后端交互接口
 \*/

import * as API from './'

export default {
  getAreas: params => API.GET('/central-pivot/station/service_areas', params)
  // getAreaSystems: id => API.GET('/sewage-service/sewage/' + id + '/systems')
}


