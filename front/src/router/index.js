import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'

// import Map from '@/components/map/Map'
// import History from '@/components/single_point/History'
// import RealTime from '@/components/single_point/RealTime'
// import Control from '@/components/device/Control'
// import Maintaining from '@/components/device/Maintaining'
// import Surveillance from '@/components/device/Surveillance'
// import Processing from '@/components/alarm/Processing'
// import Configuration from '@/components/alarm/Configuration'
// import Notification from '@/components/alarm/Notification'
// import Analysis from '@/components/report/Analysis'
// import Daily from '@/components/report/Daily'
// import Monthly from '@/components/report/Monthly'
// import User from '@/components/system/User'
// import Role from '@/components/system/Role'
// import Permission from '@/components/system/Permission'
// import Logger from '@/components/system/Logger'
const Map = resolve => require(['@/components/map/Map'], resolve);
const History = resolve => require(['@/components/single_point/History'], resolve);
const RealTime = resolve => require(['@/components/single_point/RealTime'], resolve);
const Control = resolve => require(['@/components/device/Control'], resolve);
const Maintaining = resolve => require(['@/components/device/Maintaining'], resolve);
const Surveillance = resolve => require(['@/components/device/Surveillance'], resolve);
const Processing = resolve => require(['@/components/alarm/Processing'], resolve);
const Configuration = resolve => require(['@/components/alarm/Configuration'], resolve);
const Notification = resolve => require(['@/components/alarm/Notification'], resolve);
const Analysis = resolve => require(['@/components/report/Analysis'], resolve);
const Daily = resolve => require(['@/components/report/Daily'], resolve);
const Monthly = resolve => require(['@/components/report/Monthly'], resolve);
const User = resolve => require(['@/components/system/User'], resolve);
const Role = resolve => require(['@/components/system/Role'], resolve);
const Permission = resolve => require(['@/components/system/Permission'], resolve);

import Logger from '@/components/system/Logger'


Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      redirect: '/map',
      leaf: true, // 只有一个节点
      menuShow: true,
      iconCls: 'icon iconfont icon-ditujiankong',
      children: [
        {path: '/map', component: Map, name: 'map', label: '地图监控', menuShow: true}
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '单点监测',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont icon-dandianjianse',
      children: [
        {
          path: '/realTime',
          component: RealTime,
          name: 'realTime',
          label: '实时数据',
          iconCls: 'icon iconfont icon-shishishuju',
          menuShow: true
        },
        {
          path: '/history',
          component: History,
          name: 'history',
          label: '历史数据',
          iconCls: 'icon iconfont icon-lishishuju',
          menuShow: true
        }
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '设备管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont icon-sheibeiguanli',
      children: [
        {
          path: '/control',
          component: Control,
          name: 'control',
          label: '设备控制',
          iconCls: 'icon iconfont icon-xitongkongzhi',
          menuShow: true
        },
        {
          path: '/maintaining',
          component: Maintaining,
          name: 'maintaining',
          label: '设备维护',
          iconCls: 'icon iconfont icon-shebeiweihu',
          menuShow: true
        },
        {
          path: '/surveillance',
          component: Surveillance,
          name: 'surveillance',
          label: '视频监控',
          iconCls: 'icon iconfont icon-shipinjiankong',
          menuShow: true
        },
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '报警管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont icon-baojingguanli',
      children: [
        {
          path: '/processing',
          component: Processing,
          name: 'processing',
          label: '报警处理',
          iconCls: 'icon iconfont icon-baojingguanli',
          menuShow: true
        },
        {
          path: '/configuration',
          component: Configuration,
          name: 'configuration',
          label: '报警配置',
          iconCls: 'icon iconfont icon-baojingpeizhi',
          menuShow: true
        },
        {
          path: '/notification',
          component: Notification,
          name: 'notification',
          label: '报警通知',
          iconCls: 'icon iconfont icon-baijingtongzhi',
          menuShow: true
        },
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '报表管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont icon-baobiaoguanli',
      children: [
        {
          path: '/daily',
          component: Daily,
          name: 'daily',
          label: '日报',
          iconCls: 'icon iconfont icon-ribao',
          menuShow: true
        },
        {
          path: '/monthly',
          component: Monthly,
          name: 'monthly',
          label: '月报',
          iconCls: 'icon iconfont icon-yuebao',
          menuShow: true
        },
        {
          path: '/analysis',
          component: Analysis,
          name: 'analysis',
          label: '报表分析',
          iconCls: 'icon iconfont icon-baobiaofenxi',
          menuShow: true
        },
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '系统管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont icon-xitongkongzhi',
      children: [
        {
          path: '/user', component: User, name: 'user', label: '用户管理',
          iconCls: 'icon iconfont icon-yonghuguanli', menuShow: true
        },
        {
          path: '/role', component: Role, name: 'role', label: '角色管理',
          iconCls: 'icon iconfont icon-jiaoseguanli', menuShow: true
        },
        {
          path: '/permission', component: Permission, name: 'permission', label: '权限管理',
          iconCls: 'icon iconfont icon-quanxianguanli', menuShow: true
        },
        {
          path: '/logger', component: Logger, name: 'logger', label: '日志管理',
          iconCls: 'icon iconfont icon-rizhiguanli', menuShow: true
        }
      ]
    },
  ]
})
