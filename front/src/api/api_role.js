/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/30 9:44
 \* Description: 角色权限后端交互接口
 \*/

import * as API from './'

export default {

  addRole: params => API.POST('/user-management/role/add.shtml', params),

  removeRole: id => API.GET('/user-management/role/remove/' + id + '.html'),

  batchRemoveRoles: ids => API.POST('/user-management/role/batch/remove.shtml', ids),

  /**
   * 角色授权
   * @param params
   * @return {*}
   */
  authorization: params => API.POST('/user-management/role/auth.shtml', params),

  /**
   * 修改角色信息
   * @param params
   * @return {*}
   */
  updateRole: params => API.POST('/user-management/role/update.shtml', params),

  /**
   * 获取角色列表
   * @param params
   * @returns {*}
   */
  getRolesPaging: params => API.GET('/user-management/role/list.html', params),

  /**
   * 以idName形式获取所有角色
   * @returns {*}
   */
  getRoles: () => API.GET('/user-management/role/id_name/list.json'),

  findRoleById: id => API.GET('/user-management/role/' + id + '.json')
}
