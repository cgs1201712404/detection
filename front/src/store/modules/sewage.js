/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/3 16:07
 \* Description:  污水类state
 \*/

const state = {
  // 当天实时数据
  presentList: []
};

const getters = {};

const actions = {
  getPresentList({commit, state}, params) {
    let data = [
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        sS: 50,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 2,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        sS: 50,
        time: '2018-08-03 16:55:23'
      }
    ];
    commit('setPresentList', data);
  },
  setPresentList({commit, state}, data) {
    commit('setPresentList', data)
  }
};

const mutations = {
  setPresentList(state, entity) {
    state.presentList = entity;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
