/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/7/31 14:58
 \* Description:  服务区state
 \*/
import constants from '../../common/constants'

const state = {
  serviceArea: {
    name: '测试1',
    district: {
      province: '湖北',
      city: '武汉',
      county: '江汉区'
    }
  },
  pagination: {
    page: 0,
    limit: 10,
    total: 0,
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
          county: '江汉区'
        }
      }, {
        name: '测试2',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉区'
        }
      }, {
        name: '测试3',
        district: {
          province: '湖北',
          city: '武汉',
          county: '武昌区'
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
          if (area.district.city === city && area.district.county === county) {
            return {id: area.name, label: area.name}
          }
        });
        return {id: id, label: label, children: children};
      });
      return {id: id, label: label, children: children}
    });
    console.log(aTreeData)
    commit('setATreeList', aTreeData);
  },
  getAreaList({commit, state}, params) {
    let areas = [
      {
        name: '测试1',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉区'
        }
      }, {
        name: '测试2',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉区'
        }
      }, {
        name: '测试3',
        district: {
          province: '湖北',
          city: '武汉',
          county: '武昌区'
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
