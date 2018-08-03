/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/7/31 14:58
 \* Description:  服务区state
 \*/
import Vue from 'vue'
import constants from '../../common/constants'
import util from '../../common/util'

const state = {
  area: {
    name: '常青花园服务区',
    district: {
      province: '湖北',
      city: '武汉',
      county: '江汉',
      detail: '武汉市江汉区常青三路122号'
    }
  },
  pagination: {
    page: 1,
    limit: 10,
    total: 100,
  },
  areaList: [],
  //searchBar组件中的服务区树形搜索控件
  areaTreeList: []
};

const getters = {};

const actions = {
  getTreeList({commit, state}, params) {
    let areas = [
      {
        name: '测试1',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉'
        }
      }, {
        name: '测试2',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉'
        }
      }, {
        name: '测试3',
        district: {
          province: '湖北',
          city: '武汉',
          county: '武昌'
        }
      }
    ];
    let aTreeData = constants.cities.map(function (city) {
      let label = city.name;
      let id = city.name;
      let children = city.counties.map(function (county) {
        let label = county;
        let id = county;
        let children = areas.map(function (area) {
          if (area.district.city === city.name && area.district.county === county) {
            return {id: area.name + county + city.name, label: area.name}
          } else {
            return {}
          }
        });
        for (let index = 0; index < children.length; index++) {
          if (!children[index].id) {
            children.splice(index, 1);
          }
        }
        if (children) {
          return {id: id + city.name, label: label, children: children};
        }
      });
      if (children) {
        return {id: id, label: label, children: children}
      }
    });
    commit('setATreeList', aTreeData);
  },
  getAreaList({commit, state}, params) {
    let areas = [
      {
        name: '测试1',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉'
        }
      }, {
        name: '测试2',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉'
        }
      }, {
        name: '测试3',
        district: {
          province: '湖北',
          city: '武汉',
          county: '武昌'
        }
      }
    ];
    commit('setAreaList', areas);
  },
  setAreaList({commit, state}, areas) {
    commit('setAreaList', areas);
  },
  setATreeList({commit, state}, areas) {
    commit('setATreeList', areas);
  }
};

const mutations = {
  setAreaList(state, entity) {
    state.areaList = entity
  },
  setATreeList(state, entity) {
    state.areaTreeList = entity;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
