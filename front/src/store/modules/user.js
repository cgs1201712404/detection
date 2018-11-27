/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/15 12:01
 \* Description: 用户state，用于存放用户相关数据（用户、权限组、菜单）
 \*/

const state = {
  // 当前用户
  currentUser: {},
  // 用户列表分页
  users: []
};

const getters = {
  currentUser: state => {
    return state.currentUser;
  },
  users: state => {
    return state.users;
  }
};

const actions = {
  mockPermissionList({commit, state}) {
    // 此处应该是先获取后端用户和权限数据
    let currentUser = {
      name: 'tracy4262',
      number: 18673687350,
      role: {
        id: '1',
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
            path: '/permission',
            name: 'permission'
          },
          {
            path: '/logger',
            name: 'logger'
          }
        ]
      }
    };
    commit('setCurrentUser', currentUser);
  },
  mockUsers({commit}) {
    let users = [
      {
        userName: 'tracy4262',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy4262',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy4262',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy4262',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy4262',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy4262',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy4262',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      }
    ];
    commit('setUsers', users)
  }
};

const mutations = {
  setCurrentUser(state, entity) {
    state.currentUser = entity
  },
  setUsers(state, entity) {
    state.users = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
