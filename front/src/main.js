// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/iconfont.css'
import '@/assets/styles/main.scss'
import store from "./store";
import VueLogger from 'vuejs-logger';
const isProduction = process.env.NODE_ENV === 'production';

const options = {
  isEnabled: true,
  logLevel : isProduction ? 'error' : 'debug',
  stringifyArguments : false,
  showLogLevel : false,
  showMethodName : false,
  separator: '|',
  showConsoleColors: false
};

Vue.use(VueLogger, options);

/**
 * 数据级权限命令hasPermission的定义，暂时必须放置在main.js中
 */
Vue.directive('hasPermission', {
  bind(el, binding, vnode) {
    let permissionList = vnode.context.$route.meta.permission;
    if (permissionList && permissionList.length && !permissionList.includes(binding.value)) {
      el.parentNode.removeChild(el)
    }
  }
});

Vue.config.productionTip = false;
Vue.use(ElementUI);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>',
  store
});
