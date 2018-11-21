/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/11/20
 \* Time: 22:53
 \* Description: 报告 state
 \*/

const state = {
  // 日报分页数据
  dailies: [],
  // 月报分页数据
  monthlies: []
};

const getters = {
  dailies: state => {
    return state.dailies
  },

  monthlies: state => {
    return state.monthlies
  }
};

const actions = {
  initDailies({commit}) {
    let dailies = [
      {
        date: '2018-11-21',
        areaName: '设计院',
        district: '武汉江汉',
        type: '大气类',
        factor: 'nOZ',
        exceedingAvg: '12',
        exceedingNum: 3
      },
      {
        date: '2018-11-21',
        areaName: '设计院',
        district: '武汉江汉',
        type: '大气类',
        factor: 'nO',
        exceedingAvg: '5',
        exceedingNum: 3
      },
      {
        date: '2018-11-21',
        areaName: '设计院',
        district: '武汉江汉',
        type: '大气类',
        factor: 'pM1',
        exceedingAvg: '2',
        exceedingNum: 2
      },
      {
        date: '2018-11-21',
        areaName: '武汉大学',
        district: '武汉洪山',
        type: '大气类',
        factor: 'pM1',
        exceedingAvg: '2',
        exceedingNum: 2
      },
      {
        date: '2018-11-21',
        areaName: '武汉大学',
        district: '武汉洪山',
        type: '大气类',
        factor: 'pM1',
        exceedingAvg: '2',
        exceedingNum: 2
      },
      {
        date: '2018-11-21',
        areaName: '武汉大学',
        district: '武汉洪山',
        type: '大气类',
        factor: 'nO',
        exceedingAvg: '2',
        exceedingNum: 2
      },
    ];
    commit('setDailies', dailies)
  },
  initMonthlies({commit}) {
    let monthlies = [
      {
        month: '2018-11',
        areaName: '设计院',
        district: '武汉江汉',
        type: '大气类',
        factor: 'nOZ',
        exceedingAvg: '3',
        exceedingNum: 3
      },
      {
        month: '2018-11',
        areaName: '设计院',
        district: '武汉江汉',
        type: '大气类',
        factor: 'nO',
        exceedingAvg: '5',
        exceedingNum: 3
      },
      {
        month: '2018-11',
        areaName: '设计院',
        district: '武汉江汉',
        type: '大气类',
        factor: 'pM1',
        exceedingAvg: '4',
        exceedingNum: 7
      },
      {
        month: '2018-11',
        areaName: '武汉大学',
        district: '武汉洪山',
        type: '大气类',
        factor: 'pM1',
        exceedingAvg: '5',
        exceedingNum: 3
      },
      {
        month: '2018-11',
        areaName: '武汉大学',
        district: '武汉洪山',
        type: '大气类',
        factor: 'nO',
        exceedingAvg: '4',
        exceedingNum: 2
      },
      {
        month: '2018-11',
        areaName: '武汉大学',
        district: '武汉洪山',
        type: '大气类',
        factor: 'pM1',
        exceedingAvg: '7',
        exceedingNum: 2
      },

    ];
    commit('setMonthlies', monthlies)
  }
};

const mutations = {
  setDailies(state, entity) {
    state.dailies = entity
  },

  setMonthlies(state, entity) {
    state.monthlies = entity
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
