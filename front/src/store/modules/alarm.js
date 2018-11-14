/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/14 10:14
 \* Description: 报警 state
 \*/

const state = {
  alarmProcessings: [],
  processingPagination: {
    page: 1,
    limit: 10,
    total: 100
  },
  alarmConfigs: [],
  alarmConfigsPagination: {
    page: 1,
    limit: 10,
    total: 100
  },
};

const getters = {
  alarmProcessings: state => {
    return state.alarmProcessings
  },
  alarmConfigs: state => {
    return state.alarmConfigs
  }
};

const actions = {

  initAlarmProcessings({commit, state}, type) {
    let processings = [];
    if (type === 'processed') {

    } else if (type === 'unprocessed') {

    }
    processings = [
      {
        areaName: '服务区1',
        district: '武汉市江汉区',
        type: '污水类',
        factor: 'ph',
        deviceId: '1',
        deviceName: '1号设备',
        normalLimit: '1-10',
        value: '3',
        level: '超出警戒值',
        time: '2018-11-14'
      },
      {
        areaName: '服务区2',
        district: '武汉市江汉区',
        type: '污水类',
        factor: 'cod',
        deviceId: '2',
        deviceName: '2号设备',
        normalLimit: '1-10',
        value: '3',
        level: '超出警戒值',
        time: '2018-11-14'
      },
      {
        areaName: '服务区3',
        district: '武汉市江汉区',
        type: '污水类',
        factor: 'nH3N',
        deviceId: '3',
        deviceName: '3号设备',
        normalLimit: '1-10',
        value: '3',
        level: '超出警戒值',
        time: '2018-11-14'
      },
      {
        areaName: '服务区4',
        district: '武汉市江汉区',
        type: '污水类',
        factor: 'tP',
        deviceId: '4',
        deviceName: '4号设备',
        normalLimit: '1-10',
        value: '3',
        level: '超出警戒值',
        time: '2018-11-14'
      },
      {
        areaName: '服务区5',
        district: '武汉市江汉区',
        type: '大气类',
        factor: 'sD',
        deviceId: '5',
        deviceName: '5号设备',
        normalLimit: '1-10',
        value: '3',
        level: '超出警戒值',
        time: '2018-11-14'
      },
    ];
    commit('setProcessingPagination', {page: 1, limit: 10, total: 100})
    commit('setAlarmProcessings', processings)
  }
};

const mutations = {
  setAlarmProcessings(state, entity) {
    state.alarmProcessings = entity
  },
  setAlarmConfigs(state, entity) {
    state.alarmConfigs = entity
  },
  setProcessingPagination(state, entity) {
    state.processingPagination = entity
  },
  setConfigsPagination(state, entity) {
    state.alarmConfigsPagination = entity
  }
};
export default {
  state,
  getters,
  actions,
  mutations
}
