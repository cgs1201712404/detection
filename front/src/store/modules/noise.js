/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/6 16:09
 \* Description:  噪声类state
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
  getNoisePresentList({commit, state}, params) {
    let data = [
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
    ];
    commit('setNoisePagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setNoisePresentList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setNoisePresentList', data.slice((params.page - 1) * params.limit, data.length));
    }

  },
  setNoisePresentList({commit, state}, data) {
    commit('setNoisePresentList', data)
  },
  setNoisePagination({commit, state}, data) {
    commit('setNoisePagination', data)
  }
};

const mutations = {
  setNoisePresentList(state, entity) {
    state.presentList = entity;
  },
  setNoisePagination(state, entity) {
    state.pagination = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
