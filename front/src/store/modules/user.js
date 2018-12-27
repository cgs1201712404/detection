/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/15 12:01
 \* Description: 用户state，用于存放用户相关数据（用户、权限组、菜单）
 \*/
import util from '../../common/util'
import API from "../../api/api_user";
import CONSTANTS from '../../common/constants'

const state = {
  // 当前用户
  currentUser: {},
  // 被选中的用户
  userDialog: {},
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
      userName:'tracy4262',
      name: '彭诗杰',
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
        userName: 'tracy0',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy1',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy2',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy3',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy4',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy5',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      },
      {
        userName: 'tracy6',
        password: '123456',
        name: '彭诗杰',
        gender: '男',
        phone: '18673687350',
        department: '研发中心',
        position: '技术总监',
      }
    ];
    commit('setUsers', users)
  },

  /**
   * 分页获取所有用户
   * @param params
   * @param commit
   */
  getAllUsersPaging({commit}, params) {
    return new Promise((resolve, reject) => {
      API.getUsers(params).then(result => {
        if (result && result.users) {
          commit('setUsers', result.users);
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
   * 分页姓名查询用户
   * @param commit
   * @param params
   */
  queryUsersByNameAct({commit}, params) {
    return new Promise((resolve, reject) => {
      API.queryUsers(params).then(usersPage => {
        if (usersPage) {
          commit('setUsers', usersPage.users);
          resolve();
        } else {
          reject()
        }
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    })
  },

  /**
   * 新增用户
   * @param commit
   * @param user
   */
  addUserAct({commit}, user) {
    return new Promise((resolve, reject) => {
      API.addUser(user).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          commit('addUser', util.copyObject(user));
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
   * 编辑用户
   * @param commit
   * @param user
   */
  updateUserAct({commit}, user) {
    return new Promise((resolve, reject) => {
      API.updateUser(user).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          commit('updateUserInUsers', util.copyObject(user));
          resolve(result)
        } else {
          reject(result.msg)
        }
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    })
  },

  removeUserAct({commit}, user) {
    return new Promise((resolve, reject) => {
      API.removeUser(user.userName).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          commit('removeUser', user);
          resolve(result)
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

  removeUsersAct({commit}, users) {
    return new Promise((resolve, reject) => {
      API.batchRemoveUsers(users.map(user => user.userName)).then(result => {
        if (result.errCode === CONSTANTS.SUCCESS) {
          users.forEach(user => commit('removeUser', user))
          resolve(result);
        } else {
          reject(result.msg)
        }
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    })
  }
};

const mutations = {
  setCurrentUser(state, entity) {
    state.currentUser = entity
  },
  setUserDialog(state, entity) {
    state.userDialog = entity
  },
  setUsers(state, entity) {
    state.users = entity
  },
  removeUser(state, entity) {
    util.removeElement(state.users, entity, 'userName');
  },
  addUser(state, entity) {
    state.users.push(entity)
  },
  /**
   * 更新用户数组中用户
   * @param state
   * @param entity
   */
  updateUserInUsers(state, entity) {
    state.users.forEach((user, index, array) => {
      if (user.userName === entity.userName) {
        array.splice(index, 1, entity)
      }
    })
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
