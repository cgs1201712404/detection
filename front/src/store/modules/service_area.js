/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/7/31 14:58
 \* Description:  服务区state
 \*/
import constants from '../../common/constants'
import util from '../../common/util'
import API from "../../api/api_station";

const state = {
  // 当前服务区
  area: {},
  pagination: {
    page: 1,
    limit: 10,
    total: 100,
  },
  areaList: [],
  //searchBar组件中的服务区树形搜索控件
  areaTreeList: []
};

const getters = {
  area: state => {
    return state.area;
  },
  areaList: state => {
    return state.areaList
  }
};

const actions = {
  getTreeList({commit, state}, params) {
    let areas = [
      {
        name: '设计院',
        lat: 39.1128650215,
        lon: 117.2191704349,
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉'
        }
      }, {
        name: '地质大学',
        lat: 39.9967339449,
        lon: 116.3548912199,
        district: {
          province: '湖北',
          city: '武汉',
          county: '洪山'
        }
      }, {
        name: '武汉大学',
        lat: 30.5441471993,
        lon: 114.3692234779,
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
        let children = [];
        for (let area of areas) {
          if (area.district.city === city.name && area.district.county === county) {
            children.push({id: area.name + county + city.name, label: area.name});
          }
        }
        if (children) {
          for (let index = 0; index < children.length; index++) {
            if (children[index] && !children[index].id) {
              children.splice(index, 1);
            }
          }
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
        name: '设计院',
        lat: 30.6308522809,
        log: 114.2504879481,
        state: false,
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉'
        }
      }, {
        name: '地质大学',
        lat: 30.5245586396,
        log: 114.4065534568,
        state: false,
        district: {
          province: '湖北',
          city: '武汉',
          county: '洪山'
        }
      }, {
        name: '武汉大学',
        lat: 30.5441471993,
        log: 114.3692234779,
        state: false,
        district: {
          province: '湖北',
          city: '武汉',
          county: '武昌'
        }
      }
    ];
    commit('setAreaList', areas);
  },

  /**
   * 从服务器获取服务区列表数据并填充state中的List与Tree
   *
   * @param commit
   * @param state
   * @param context 组件上下文环境
   * @returns {Promise<any>}
   */
  initAreaListAndTreeAct({commit, state}) {
    return new Promise((resolve, reject) => {
      API.getAreas(null).then(backAreas => {
        let areas = areasFormat(backAreas);
        let treeAreas = transAreaListToTree(areas);
        commit('setAreaList', areas);
        commit('setATreeList', treeAreas);
        // 设置当前area
        // context.setCurrentArea(areas[0]);
        commit('setArea', areas[0]);
        resolve()
      }, error => {
        reject(error)
      }).catch(err => {
        reject(err)
      })
    });
  },

  setAreaList({commit, state}, areas) {
    commit('setAreaList', areas);
  },
  setATreeList({commit, state}, areas) {
    commit('setATreeList', areas);
  },
  setCurrentArea({commit, state}, area) {

    commit('setArea', area)
  }
};

function areasFormat(backendAreas) {
  let areas = []
  if (backendAreas) {
    backendAreas.forEach(backArea => {
      let area = {}
      area = util.copyObject(backArea);
      area.district = {}
      area.district.province = backArea.province;
      area.district.city = backArea.city;
      area.district.county = backArea.county;
      areas.push(area)
    })
  }
  return areas;
}

/**
 * 将服务区List转化为Tree组件中可用格式
 * @param areas
 * @returns {*}
 */
function transAreaListToTree(areas) {
  let aTreeData = constants.cities.map(function (city) {
    let label = city.name;
    let id = city.name;
    let children = city.counties.map(function (county) {
      let label = county;
      let id = county;
      let children = [];
      for (let area of areas) {
        if (area.district.city === city.name && area.district.county === county) {
          children.push({id: area.name + county + city.name, label: area.name});
        }
      }
      if (children) {
        for (let index = 0; index < children.length; index++) {
          if (children[index] && !children[index].id) {
            children.splice(index, 1);
          }
        }
        return {id: id + city.name, label: label, children: children};
      }
    });
    if (children) {
      return {id: id, label: label, children: children}
    }
  });
  return aTreeData;
}

const mutations = {
  setAreaList(state, entity) {
    state.areaList = entity
  },
  setATreeList(state, entity) {
    state.areaTreeList = entity;
  },
  setArea(state, entity) {
    state.area = entity;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}
