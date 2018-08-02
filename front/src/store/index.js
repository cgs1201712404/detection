import Vue from "vue";
import Vuex from "vuex";
import createLogger from "vuex/dist/logger";
// import forum from "./modules/forum";
import serviceArea from './modules/service_area'

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== "production";

export default new Vuex.Store({
  modules: {
    serviceArea,
  },
  strict: debug,
  plugins: debug ? [createLogger()] : []
});
