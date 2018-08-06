/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/3 16:07
 \* Description:  污水类state
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
  getSewagePresentList({commit, state}, params) {
    let data = [
      {
        id: 1,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 2,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 3,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      }, {
        id: 4,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 5,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 6,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 7,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 8,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 9,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 10,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
      {
        id: 11,
        pH: 7.0,
        cod: 123,
        nH3N: 48,
        tP: 31,
        sS: 50,
        time: '2018-08-03 16:55:23'
      },
    ];
    commit('setSewagePagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setSewagePresentList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setSewagePresentList', data.slice((params.page - 1) * params.limit, data.length));
    }

  },
  setSewagePresentList({commit, state}, data) {
    commit('setSewagePresentList', data)
  },
  setSewagePagination({commit, state}, data) {
    commit('setSewagePagination', data)
  }
};

const mutations = {
  setSewagePresentList(state, entity) {
    state.presentList = entity;
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
