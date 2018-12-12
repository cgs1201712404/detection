/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/23 16:26
 \* Description: 角色权限 state
 \*/

import API from '../../api/api_role'
import util from '../../common/util'
import CONSTANTS from '../../common/constants'

const state = {
  // 角色分页数据
  roles: [],
  // 被选中分配权限的角色
  roleDialog: {},
  // 新建角色时，权限的default值
  newPermissions: []
};

const getters = {
  roles: state => {
    return state.roles
  },
  roleDialog: state => {
    return state.roleDialog
  }
};

const actions = {
  mockRoles({commit, state}) {
    let roles = [
      {
        id: '1',
        roleName: '管理员',
        note: '这是拥有全部权限的角色',
        permissionGroup: [
          {
            path: '/map',
            name: 'map',
            label: '地图监控',
            checked: true
          },
          {
            path: '/realTime',
            name: 'realTime',
            label: '实时数据',
            checked: true
          },
          {
            path: '/history',
            name: 'history',
            label: '历史数据',
            checked: true
          },
          {
            path: '/control',
            name: 'control',
            label: '设备控制',
            checked: true
          },
          {
            path: '/maintaining',
            name: 'maintaining',
            label: '设备维护',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/surveillance',
            name: 'surveillance',
            label: '视频监控',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/processing',
            name: 'processing',
            label: '报警处理',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/configuration',
            name: 'configuration',
            label: '报警配置',
            checked: true,
            permission: [{value: 'remove', label: '删除', checked: true},
              {value: 'add', label: '新增', checked: true},
              {value: 'edit', label: '编辑', checked: true}]
          },
          {
            path: '/daily',
            name: 'daily',
            label: '日报',
            checked: true,
            permission: [{value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/monthly',
            name: 'monthly',
            label: '月报',
            checked: true,
            permission: [{value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/analysis',
            name: 'analysis',
            label: '报表分析',
            checked: true,
          },
          {
            path: '/user',
            name: 'user',
            label: '用户管理',
            checked: true,
            permission: [{value: 'remove', label: '删除', checked: true},
              {value: 'add', label: '新增', checked: true},
              {value: 'edit', label: '编辑', checked: true}]
          },
          {
            path: '/role',
            name: 'role',
            label: '角色权限管理',
            checked: true,
            permission: [{value: 'remove', label: '删除', checked: true},
              {value: 'add', label: '新增', checked: true},
              {value: 'edit', label: '编辑', checked: true},
              {value: 'grant', label: '分配权限', checked: true}]
          },
          {
            path: '/logger',
            name: 'logger',
            label: '日志管理',
            checked: true,
          }
        ]
      },
      {
        id: '2',
        roleName: '总经理',
        note: '这是总经理的角色',
        permissionGroup: [
          {
            path: '/map',
            name: 'map',
            label: '地图监控',
            checked: true,
          },
          {
            path: '/realTime',
            name: 'realTime',
            label: '实时数据',
            checked: true,
          },
          {
            path: '/history',
            name: 'history',
            label: '历史数据',
            checked: true,
          },
          {
            path: '/control',
            name: 'control',
            label: '设备控制',
            checked: true,
          },
          {
            path: '/maintaining',
            name: 'maintaining',
            label: '设备维护',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/surveillance',
            name: 'surveillance',
            label: '视频监控',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/processing',
            name: 'processing',
            label: '报警处理',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/configuration',
            name: 'configuration',
            label: '报警配置',
            checked: true,
            permission: [{value: 'remove', label: '删除', checked: true},
              {value: 'add', label: '新增', checked: true},
              {value: 'edit', label: '编辑', checked: true}]
          },
          {
            path: '/notification',
            name: 'notification',
            label: '报警通知',
            checked: true,
          },
          {
            path: '/daily',
            name: 'daily',
            label: '日报',
            checked: true,
            permission: [{value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/monthly',
            name: 'monthly',
            label: '月报',
            checked: true,
            permission: [{value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/analysis',
            name: 'analysis',
            checked: true,
            label: '报表分析',
          },
          {
            path: '/user',
            name: 'user',
            label: '用户管理',
            checked: true,
            permission: [{value: 'remove', label: '删除', checked: false},
              {value: 'add', label: '新增', checked: false},
              {value: 'edit', label: '编辑', checked: false}]
          },
          {
            path: '/role',
            name: 'role',
            label: '角色权限管理',
            checked: true,
            permission: [{value: 'remove', label: '删除', checked: false},
              {value: 'add', label: '新增', checked: false},
              {value: 'edit', label: '编辑', checked: false},
              {value: 'grant', label: '分配权限', checked: false}]
          },
          {
            path: '/logger',
            name: 'logger',
            label: '日志管理',
            checked: true,
          }
        ]
      },
      {
        id: '3',
        roleName: '运维人员',
        note: '这是运维人员的角色',
        permissionGroup: [
          {
            path: '/map',
            name: 'map',
            label: '地图监控',
            checked: true,
          },
          {
            path: '/realTime',
            name: 'realTime',
            label: '实时数据',
            checked: true,
          },
          {
            path: '/history',
            name: 'history',
            label: '历史数据',
            checked: true,
          },
          {
            path: '/control',
            name: 'control',
            label: '设备控制',
            checked: true,
          },
          {
            path: '/maintaining',
            name: 'maintaining',
            label: '设备维护',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/surveillance',
            name: 'surveillance',
            label: '视频监控',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/processing',
            name: 'processing',
            label: '报警处理',
            checked: true,
            permission: [{value: 'edit', label: '编辑', checked: true}, {value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/configuration',
            name: 'configuration',
            label: '报警配置',
            checked: true,
            permission: [{value: 'remove', label: '删除', checked: true},
              {value: 'add', label: '新增', checked: true},
              {value: 'edit', label: '编辑', checked: true}]
          },
          {
            path: '/notification',
            name: 'notification',
            label: '报警通知',
            checked: true,
          },
          {
            path: '/daily',
            name: 'daily',
            label: '日报',
            checked: true,
            permission: [{value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/monthly',
            name: 'monthly',
            label: '月报',
            checked: true,
            permission: [{value: 'export', label: '导出', checked: true}]
          },
          {
            path: '/analysis',
            name: 'analysis',
            label: '报表分析',
            checked: true,
          },
          {
            path: '/user',
            name: 'user',
            label: '用户管理',
            checked: false,
            permission: [{value: 'remove', label: '删除', checked: false},
              {value: 'add', label: '新增', checked: false},
              {value: 'edit', label: '编辑', checked: false}]
          },
          {
            path: '/role',
            name: 'role',
            label: '角色权限管理',
            checked: false,
            permission: [{value: 'remove', label: '删除', checked: false},
              {value: 'add', label: '新增', checked: false},
              {value: 'edit', label: '编辑', checked: false},
              {value: 'grant', label: '分配权限', checked: false}]
          },
          {
            path: '/logger',
            name: 'logger',
            label: '日志管理',
            checked: false,
          }
        ]
      }
    ];
    if (state.roles && state.roles.length === 0) {
      commit('setRoles', roles);
      commit('setRoleDialog', roles[0])
    }
  },

  /**
   * 分页获取所有角色
   *
   * @param commit
   * @param state
   * @param params
   * @returns {Promise<any>}
   */
  getAllRolesPaging({commit, state}, params) {
    return new Promise((resolve, reject) => {
      API.getRoles(params).then(result => {
        if (result && result.roles) {
          commit('setRoles', result.roles);
          resolve(result);
        }
      }, error => {
        reject(error);
      }).catch(err => {
        reject(err);
      })
    })
  },

  /**
   * 根据角色id获取角色基本和权限信息，并设置为当前选中角色
   * @param commit
   * @param state
   * @param role
   */
  setRoleDialog({commit, state}, role) {
    return new Promise((resolve, reject) => {
      API.findRoleById(role.id).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          commit('setRoleDialog', JSON.parse(result.data));
          resolve(result);
        } else {
          reject(result.msg)
        }
      }, error => {
        reject(error);
      }).catch(err => {
        reject(err);
      })
    })
  },

  /**
   * 修改角色信息
   * @param commit
   * @param state
   * @param role
   * @return {Promise<any>}
   */
  updateRole({commit, state}, role) {
    return new Promise((resolve, reject) => {
      let params = {
        id: role.id,
        name: role.name,
        note: role.note
      };
      API.updateRole(params).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          console.log(result)
          commit('updateRoles', JSON.parse(result.data));
          commit('setRoleDialog', role);
          resolve(result);
        } else {
          reject(result.msg)
        }
      }, err => reject(err)).catch(error => reject(error))
    })
  },

  /**
   * 添加角色
   * @param commit
   * @param state
   * @param role
   */
  addRoleAct({commit, state}, role) {
    return new Promise((resolve, reject) => {
      API.addRole(role).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          commit('addRole', JSON.parse(result.data))
          resolve(result);
        } else {
          reject(result.msg)
        }
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    });
  },

  /**
   * 分配权限
   * @param commit
   * @param state
   * @returns {Promise<any>}
   */
  submitAuthorization({commit, state}) {
    return new Promise((resolve, reject) => {
      let params = state.roleDialog;
      API.authorization(params).then(result => {
        resolve(result);
      }, err => reject(err)).catch(error => reject(error))
    })
  },

  /**
   * 删除角色
   * @param commit
   * @param state
   * @param role
   */
  removeRoleAct({commit, state}, role) {
    return new Promise((resolve, reject) => {
      API.removeRole(role.id).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          commit('removeRole', role);
          resolve(result);
        } else {
          reject(result.msg);
        }
      }, error => {
        reject(error);
      }).catch(err => {
        reject(err);
      })
    });
  },

  removeRolesAct({commit, state}, roles) {
    roles.forEach(role => commit('removeRole', role))
  }
};

const mutations = {
  setRoles(state, entity) {
    state.roles = entity
  },

  updateRoles(state, entity) {
    state.roles.forEach((role, index) => {
      if (role.id === entity.id) {
        role.name = entity.name;
        role.note = entity.note
      }
    })
  },
  setRoleDialog(state, entity) {
    state.roleDialog = entity
  },
  setWholePermissions(state, entity) {
    state.wholePermissions = entity;
  },

  removeRole(state, entity) {
    util.removeElement(state.roles, entity, 'id');
  },

  addRole(state, entity) {
    state.roles.push(entity);
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
