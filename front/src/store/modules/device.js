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
  initMaintenances({commit, state}) {
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
    ];
    commit('setMaintenances', controls)
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
