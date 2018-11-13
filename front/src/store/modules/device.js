/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/13 17:46
 \* Description:
 \*/

const state = {
  deviceControls: []
};

const getters = {
  deviceControls : state => {
    return state.deviceControls
  }
};

const actions = {

  setSolidPresentList({commit, state}, data) {
    commit('setSolidPresentList', data)
  },
  setSolidHistoryList({commit, state}, data) {
    commit('setSolidHistoryList', data)
  },
  setSolidPagination({commit, state}, data) {
    commit('setSolidPagination', data)
  }
};
const mutations = {

};
export default {
  state,
  getters,
  actions,
  mutations
}
