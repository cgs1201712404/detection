/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @date: 2018/12/29
 \* @time: 23:05
 \* Description:
 \*/
import * as API from './'

export default {
  getSewageSystems: id => API.GET('/sewage-service/sewage/' + id + '/systems'),

  getSystemFactors: params => API.GET('/sewage-service/sewage/'+ params.sewageId
    + '/system/' + params.systemCode + '/factors'),

  getFactorLatestValue: params => API.GET('/sewage-service/sewage/'+ params.sewageId
    + '/system/' + params.systemCode + '/factor/' + params.factorCode + '/latest')
}
