/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/30 9:44
 \* Description: 角色权限后端交互接口
 \*/

import * as API from './'

export default {

  /**
   * 角色授权
   * @param params
   * @return {*}
   */
  authorization: params => API.POST('/role/auth', params),
}
