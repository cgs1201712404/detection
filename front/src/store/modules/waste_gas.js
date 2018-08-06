/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/6 14:35
 \* Description:  大气类state
 \*/

const state = {
  // 当天实时数据
  presentList: [],
  pagination: {
    page: 0,
    limit: 10,
    total: 100,
  },
};

const getters = {};

const actions = {
  getWastePresentList({commit, state}, params) {
    let data = [
      {
        id: 1,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:50:23'
      },
      {
        id: 2,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 3,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      }, {
        id: 4,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 5,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 6,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 7,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 8,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 9,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 10,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
      {
        id: 11,
        sD: 7.0,  // 二氧化硫
        nOX: 123, // 氮氧化物
        tCM: 48,  // 隧道一氧化碳
        time: '2018-08-03 16:55:23'
      },
    ];
    commit('setWastePagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setWastePresentList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setWastePresentList', data.slice((params.page - 1) * params.limit, data.length));
    }

  },
  setWastePresentList({commit, state}, data) {
    commit('setWastePresentList', data)
  },
  setWastePagination({commit, state}, data) {
    commit('setWastePagination', data)
  }
};

const mutations = {
  setWastePresentList(state, entity) {
    state.presentList = entity;
  },
  setWastePagination(state, entity) {
    state.pagination = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
