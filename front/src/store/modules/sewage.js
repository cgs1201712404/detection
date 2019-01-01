/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/3 16:07
 \* Description:  污水类state
 \*/
import API from "../../api/api_sewage";

const state = {
  // 当天最新数据
  latest: {},
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
        cod: 60,
        nH3N: 48,
        tP: 31,
        oil: 50,
        flow: 50,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 5.0,
        cod: 57,
        nH3N: 47,
        tP: 43,
        oil: 65,
        flow: 40,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 5.7,
        cod: 48,
        nH3N: 36,
        tP: 30,
        oil: 54,
        flow: 47,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 6.9,
        cod: 45,
        nH3N: 43,
        tP: 29,
        oil: 56,
        flow: 65,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 6.8,
        cod: 42,
        nH3N: 42,
        tP: 35,
        oil: 48,
        flow: 50,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 6.3,
        cod: 45,
        nH3N: 40,
        tP: 27,
        oil: 56,
        flow: 54,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 6.1,
        cod: 40,
        nH3N: 42,
        tP: 27,
        oil: 48,
        flow: 38,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 6.9,
        cod: 46,
        nH3N: 42,
        tP: 35,
        oil: 56,
        flow: 43,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 6.8,
        cod: 43,
        nH3N: 43,
        tP: 27,
        oil: 48,
        flow: 38,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 5.8,
        cod: 45,
        nH3N: 45,
        tP: 37,
        oil: 45,
        flow: 43,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        pH: 6.5,
        cod: 45,
        nH3N: 41,
        tP: 27,
        oil: 50,
        flow: 54,
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
  getSewageLatest({commit, state}, params) {
    let data = {
      id: 1,
      pH: 7.0,
      cod: 25,
      nH3N: 48,
      tP: 31,
      oil: 50,
      flow: 100,
      time: '2018-08-03 16:50:23'
    };
    commit('setSewageLatest', data)
  },

  /**
   * 从服务器获取当前服务区水质监测集成商系统
   *
   * @param commit
   * @param state
   * @param area
   * @returns {Promise<any>}
   */
  getSewageSystemsAct({commit, state}, area) {
    return new Promise((resolve, reject) => {
      API.getSewageSystems(area.sewageId).then(systems => {
        resolve(systems);
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    })
  },

  /**
   * 从服务器获取当前集成商系统监测指标
   * @param commit
   * @param state
   * @param params {sewageId:'', systemCode: ''}
   */
  getSystemFactorsAct({commit, state}, params) {
    return new Promise((resolve, reject) => {
      API.getSystemFactors(params).then(factPageVo => {
        resolve(factPageVo)
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    })
  },

  /**
   * 从服务器获取监测指标最新值
   * @param commit
   * @param state
   * @param params {sewageId:'', systemCode: '', factorCode: ''}
   * @returns {Promise}
   */
  getFactorLatestValueAct({commit, state}, params) {
    return new Promise((resolve, reject) => {
      API.getFactorLatestValue(params).then(factorValue => {
        resolve(factorValue)
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    })
  },

  setSewagePresentList({commit, state}, data) {
    commit('setSewagePresentList', data)
  },
  setSewageHistoryList({commit, state}, data) {
    commit('setSewageHistoryList', data)
  },
  setSewagePagination({commit, state}, data) {
    commit('setSewagePagination', data)
  },
  setSewageLatest({commit, state}, data) {
    commit('setSewageLatest', data)
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
  },
  setSewageLatest(state, entity) {
    state.latest = entity;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
