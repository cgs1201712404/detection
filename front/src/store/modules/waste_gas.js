/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/6 14:35
 \* Description:  大气类state
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
  getGasPresentList({commit, state}, params) {
    let data = [
      {
        id: 1,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
      {
        id: 2,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
      {
        id: 3,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
      {
        id: 4,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
    ];
    commit('setGasPagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setGasPresentList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setGasPresentList', data.slice((params.page - 1) * params.limit, data.length));
    }

  },
  getGasHistoryList({commit, state}, params) {
    let data = [
      {
        id: 1,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
      {
        id: 2,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
      {
        id: 3,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
      {
        id: 4,
        sD: 7.0,  // 二氧化硫
        nOZ: 123, // 二氧化氮
        nO: 23, // 一氧化氮
        tCM: 48,  // 隧道一氧化碳
        tSP: 12,  // TSP（总悬浮物）
        pM1: 23, // PM1
        pM25: 23,
        pM10: 21,
        temperature: 22.1, // 温度
        humidity: 23, // 湿度
        atmPress: 21, // 大气压
        windSpeed: 5, // 风速
        rainfall: 132, // 降雨量
        time: '2018-08-03 16:50:23'
      },
    ];
    commit('setGasPagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setGasHistoryList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setGasHistoryList', data.slice((params.page - 1) * params.limit, data.length));
    }
  },
  setGasPresentList({commit, state}, data) {
    commit('setGasPresentList', data)
  },
  setGasHistoryList({commit, state}, data) {
    commit('setGasHistoryList', data)
  },
  setGasPagination({commit, state}, data) {
    commit('setGasPagination', data)
  }
};

const mutations = {
  setGasPresentList(state, entity) {
    state.presentList = entity;
  },
  setGasHistoryList(state, entity) {
    state.historyList = entity;
  },
  setGasPagination(state, entity) {
    state.pagination = entity;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
