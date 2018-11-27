/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/23 16:26
 \* Description: 角色权限 state
 \*/

const state = {
  // 角色分页数据
  roles: [],
  // 被选中分配权限的角色
  roleDialog: {},
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
            path: '/',
            name: 'home',
          },
          {
            path: '/map',
            name: 'map'
          },
          {
            path: '/realTime',
            name: 'realTime',
          },
          {
            path: '/history',
            name: 'history'
          },
          {
            path: '/control',
            name: 'control'
          },
          {
            path: '/maintaining',
            name: 'maintaining',
            permission: ['edit', 'export']
          },
          {
            path: '/surveillance',
            name: 'surveillance',
            permission: ['edit', 'export']
          },
          {
            path: '/processing',
            name: 'processing',
            permission: ['edit', 'export']
          },
          {
            path: '/configuration',
            name: 'configuration'
          },
          {
            path: '/notification',
            name: 'notification'
          },
          {
            path: '/daily',
            name: 'daily'
          },
          {
            path: '/monthly',
            name: 'monthly'
          },
          {
            path: '/analysis',
            name: 'analysis'
          },
          {
            path: '/user',
            name: 'user'
          },
          {
            path: '/role',
            name: 'role'
          },
          {
            path: '/logger',
            name: 'logger'
          }
        ]
      },
      {
        id: '2',
        roleName: '总经理',
        note: '这是总经理的角色',
        permissionGroup: [
          {
            path: '/',
            name: 'home',
          },
          {
            path: '/map',
            name: 'map'
          },
          {
            path: '/realTime',
            name: 'realTime',
          },
          {
            path: '/history',
            name: 'history'
          },
          {
            path: '/control',
            name: 'control'
          },
          {
            path: '/maintaining',
            name: 'maintaining',
            permission: ['edit', 'export']
          },
          {
            path: '/surveillance',
            name: 'surveillance'
          },
          {
            path: '/processing',
            name: 'processing'
          },
          {
            path: '/configuration',
            name: 'configuration'
          },
          {
            path: '/notification',
            name: 'notification'
          },
          {
            path: '/daily',
            name: 'daily'
          },
          {
            path: '/monthly',
            name: 'monthly'
          },
          {
            path: '/analysis',
            name: 'analysis'
          },
          {
            path: '/user',
            name: 'user'
          },
          {
            path: '/role',
            name: 'role'
          },
          {
            path: '/logger',
            name: 'logger'
          }
        ]
      },
      {
        id: '3',
        roleName: '运维人员',
        note: '这是运维人员的角色'
      }
    ];
    if (state.roles && state.roles.length === 0) {
      commit('setRoles', roles)
    }
  },
  setRoleDialog({commit, state}, role) {
    commit('setRoleDialog', role);
  }
};

const mutations = {
  setRoles(state, entity) {
    state.roles = entity
  },
  setRoleDialog(state, entity) {
    state.roleDialog = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
