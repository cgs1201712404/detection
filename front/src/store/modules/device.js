/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/13 17:46
 \* Description:
 \*/
const state = {
  deviceControls: [],
  maintenances: []
};

const getters = {
  deviceControls: state => {
    return state.deviceControls
  },
  maintenances: state => {
    return state.maintenances
  }
};

const actions = {
  initMaintenances({commit}) {
    let controls = [
      {
        type: '污水类',
        factor: 'ph',
        deviceId: '1',
        deviceName: '1号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '污水类',
        factor: 'cod',
        deviceId: '2',
        deviceName: '2号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '污水类',
        factor: 'nH3N',
        deviceId: '3',
        deviceName: '3号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '污水类',
        factor: 'tP',
        deviceId: '4',
        deviceName: '4号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'sD',
        deviceId: '5',
        deviceName: '5号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'nOZ',
        deviceId: '6',
        deviceName: '6号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'nO',
        deviceId: '7',
        deviceName: '7号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'tCM',
        deviceId: '8',
        deviceName: '8号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'tSP',
        deviceId: '9',
        deviceName: '9号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'pM1',
        deviceId: '10',
        deviceName: '10号设备',
        record: '已经维护',
        time: '2018-11-14'
      },
    ];
    commit('setMaintenances', controls)
  },
  initControls({commit}) {
    let controls = [
      {
        type: '污水类',
        factor: 'ph',
        deviceId: '1',
        deviceName: '1号设备',
        status: '开启',
        time: '2018-11-14'
      },
      {
        type: '污水类',
        factor: 'cod',
        deviceId: '2',
        deviceName: '2号设备',
        status: '开启',
        time: '2018-11-14'
      },
      {
        type: '污水类',
        factor: 'nH3N',
        deviceId: '3',
        deviceName: '3号设备',
        status: '开启',
        time: '2018-11-14'
      },
      {
        type: '污水类',
        factor: 'tP',
        deviceId: '4',
        deviceName: '4号设备',
        status: '开启',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'sD',
        deviceId: '5',
        deviceName: '5号设备',
        status: '开启',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'nOZ',
        deviceId: '6',
        deviceName: '6号设备',
        status: '关闭',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'nO',
        deviceId: '7',
        deviceName: '7号设备',
        status: '关闭',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'tCM',
        deviceId: '8',
        deviceName: '8号设备',
        status: '关闭',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'tSP',
        deviceId: '9',
        deviceName: '9号设备',
        status: '关闭',
        time: '2018-11-14'
      },
      {
        type: '大气类',
        factor: 'pM1',
        deviceId: '10',
        deviceName: '10号设备',
        status: '关闭',
        time: '2018-11-14'
      },
    ];
    commit('setDeviceControls', controls)
  }
};
const mutations = {
  setMaintenances(state, entity) {
    state.maintenances = entity
  },
  setDeviceControls(state, entity) {
    state.deviceControls = entity
  }
};
export default {
  state,
  getters,
  actions,
  mutations
}
