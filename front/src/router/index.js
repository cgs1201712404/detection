import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Map from '@/components/Map'
import History from '@/components/single_point/History'
import RealTime from '@/components/single_point/RealTime'
import Control from '@/components/device/Control'
import Maintaining from '@/components/device/Maintaining'
import Surveillance from '@/components/device/Surveillance'
import Processing from '@/components/alarm/Processing'
import Configuration from '@/components/alarm/Configuration'
import Notification from '@/components/alarm/Notification'
import Analysis from '@/components/report/Analysis'
import Daily from '@/components/report/Daily'
import Monthly from '@/components/report/Monthly'
import User from '@/components/system/User'
import Role from '@/components/system/Role'
import Permission from '@/components/system/Permission'
import Logger from '@/components/system/Logger'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      redirect: '/map',
      leaf: true, // 只有一个节点
      menuShow: true,
      iconCls: 'icon iconfont', // 图标样式class
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
      iconCls: 'icon iconfont', // 图标样式class
      children: [
        {path: '/realTime', component: RealTime, name: 'realTime', label: '实时数据', menuShow: true},
        {path: '/history', component: History, name: 'history', label: '历史数据', menuShow: true}
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '设备管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont', // 图标样式class
      children: [
        {path: '/control', component: Control, name: 'control', label: '设备控制', menuShow: true},
        {path: '/maintaining', component: Maintaining, name: 'maintaining', label: '设备维护', menuShow: true},
        {path: '/surveillance', component: Surveillance, name: 'surveillance', label: '视频监控', menuShow: true},
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '报警管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont', // 图标样式class
      children: [
        {path: '/processing', component: Processing, name: 'processing', label: '报警处理', menuShow: true},
        {path: '/configuration', component: Configuration, name: 'configuration', label: '报警配置', menuShow: true},
        {path: '/notification', component: Notification, name: 'notification', label: '报警通知', menuShow: true},
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '报表管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont',
      children: [
        {path: '/daily', component: Daily, name: 'daily', label: '日报', menuShow: true},
        {path: '/monthly', component: Monthly, name: 'monthly', label: '月报', menuShow: true},
        {path: '/analysis', component: Analysis, name: 'analysis', label: '报表分析', menuShow: true},
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      label: '系统管理',
      leaf: false,
      menuShow: true,
      iconCls: 'icon iconfont',
      children: [
        {path: '/user', component: User, name: 'user', label: '用户管理', menuShow: true},
        {path: '/role', component: Role, name: 'role', label: '角色管理', menuShow: true},
        {path: '/permission', component: Permission, name: 'permission', label: '权限管理', menuShow: true},
        {path: '/logger', component: Logger, name: 'logger', label: '日志管理', menuShow: true}
      ]
    },
  ]
})
