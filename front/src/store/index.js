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
    alarm
  },
  strict: debug,
  plugins: debug ? [createLogger()] : []
});
