/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/15 12:01
 \* Description: 用户state，用于存放用户相关数据（用户、权限组、菜单）
 \*/

const state = {
  // 当前用户
  currentUser: {
    name: 'tracy4262',
    number: 18673687350,
    privilegeGroup: [
      {
        path: '/',
        name: 'home',
      },
      {
        path: '/map',
        name: 'map'
      }
    ]
  }
};

const getters = {
  currentUser: state => {
    return state.currentUser;
  }
};

const mutations = {
  setCurrentUser(state, entity) {
    state.currentUser = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
