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
  // 该系统所能被分配的全部权限
  wholePermissions: []
};

const getters = {
  roles: state => {
    return state.roles
  },
  roleDialog: state => {
    return state.roleDialog
  },
  wholePermissions: state => {
    return state.wholePermissions
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

  setRoleDialog({commit, state}, role) {
    commit('setRoleDialog', role);
  },
  initWholePermissions({commit}) {
    let allPermissions = [
      {
        path: '/map',
        name: 'map',
        label: '地图监控',
      },
      {
        path: '/realTime',
        name: 'realTime',
        label: '实时数据',
      },
      {
        path: '/history',
        name: 'history',
        label: '历史数据',
      },
      {
        path: '/control',
        name: 'control',
        label: '设备控制',
        permission: [{value: 'manipulate', label: '操作'}]
      },
      {
        path: '/maintaining',
        name: 'maintaining',
        label: '设备维护',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      },
      {
        path: '/surveillance',
        name: 'surveillance',
        label: '视频监控',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      },
      {
        path: '/processing',
        name: 'processing',
        label: '报警处理',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      },
      {
        path: '/configuration',
        name: 'configuration',
        label: '报警配置',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      },
      {
        path: '/notification',
        name: 'notification',
        label: '报警通知',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      },
      {
        path: '/daily',
        name: 'daily',
        label: '日报',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      },
      {
        path: '/monthly',
        name: 'monthly',
        label: '月报',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      },
      {
        path: '/analysis',
        name: 'analysis',
        label: '报表分析',
      },
      {
        path: '/user',
        name: 'user',
        label: '用户管理',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}, {value: 'add', label: '新建'}]
      },
      {
        path: '/role',
        name: 'role',
        label: '角色权限管理',
      },
      {
        path: '/logger',
        name: 'logger',
        label: '日志管理',
        permission: [{value: 'edit', label: '编辑'}, {value: 'export', label: '导出'}]
      }
    ];
    commit('setWholePermissions', allPermissions)
  }
};

const mutations = {
  setRoles(state, entity) {
    state.roles = entity
  },
  setRoleDialog(state, entity) {
    state.roleDialog = entity
  },
  setWholePermissions(state, entity) {
    state.wholePermissions = entity;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
