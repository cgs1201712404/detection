/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/23 16:26
 \* Description: 角色权限 state
 \*/

const state = {
  // 角色分页数据
  roles: [],
};

const getters = {
  roles: state => {
    return state.roles
  }
};

const actions = {
  mockRoles({commit, state}) {
    let roles = [
      {
        id: '1',
        roleName: '管理员',
        note: '这是拥有全部权限的角色'
      },
      {
        id: '2',
        roleName: '总经理',
        note: '这是总经理的角色'
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
  }
};

const mutations = {
  setRoles(state, entity) {
    state.roles = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
