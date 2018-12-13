/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @date: 2018/12/13
 \* @time: 15:02
 \* Description: 用户管理后端交互接口
 \*/

import * as API from './'

export default {

  /**
   * 获取用户列表
   * @param params
   * @returns {*}
   */
  getUsers: params => API.GET('/user-management/user/list.html', params),

  addUser: params => API.POST('/user-management/user/add.shtml', params)
}
