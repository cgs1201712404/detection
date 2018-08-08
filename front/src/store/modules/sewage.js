/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/3 16:07
 \* Description:  污水类state
 \*/

const state = {
  // 当天实时数据
  presentList: [],
  // 历史数据
  historyList: [],
  pagination: {
    page: 0,
    limit: 10,
    total: 100,
  },
};

const getters = {};

const actions = {
  getSewagePresentList({commit, state}, params) {
    let data = [
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
    ];
    commit('setSewagePagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setSewagePresentList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setSewagePresentList', data.slice((params.page - 1) * params.limit, data.length));
    }
  },
  getSewageHistoryList({commit, state}, params) {
    let data = [
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 100,
        time: '2018-08-03 16:50:23'
      }
    ];
    commit('setSewagePagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setSewageHistoryList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setSewageHistoryList', data.slice((params.page - 1) * params.limit, data.length));
    }
  },
  setSewagePresentList({commit, state}, data) {
    commit('setSewagePresentList', data)
  },
  setSewageHistoryList({commit, state}, data) {
    commit('setSewageHistoryList', data)
  },
  setSewagePagination({commit, state}, data) {
    commit('setSewagePagination', data)
  }
};

const mutations = {
  setSewagePresentList(state, entity) {
    state.presentList = entity;
  },
  setSewageHistoryList(state, entity) {
    state.historyList = entity;
  },
  setSewagePagination(state, entity) {
    state.pagination = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
