import Vue from "vue";
import Vuex from "vuex";
import createLogger from "vuex/dist/logger";
import serviceArea from './modules/service_area'
import sewage from './modules/sewage'
import wasteGas from './modules/waste_gas'
import noise from './modules/noise'
import solid from './modules/solid'
import device from './modules/device'
import alarm from './modules/alarm'
import user from  './modules/user'
import report from './modules/report'
import role from './modules/role'

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== "production";

export default new Vuex.Store({
  modules: {
    serviceArea,
    sewage,
    wasteGas,
    noise,
    solid,
    device,
    alarm,
    user,
    report,
    role
  },
  // 不使用严格模式，vuex绑定checkbox中的坑
  // strict: debug,
  strict: false,
  plugins: debug ? [createLogger()] : []
});
