/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/7 19:05
 \* Description: 固废类state
 \*/
const state = {
  // 当天实时数据
  presentList: [],
  pagination: {
    page: 0,
    limit: 10,
    total: 100,
  },
};

const getters = {};

const actions = {
  getSolidPresentList({commit, state}, params) {
    let data = [
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        intensity: 7.0,
        frequency: 20,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
      {
        id: 1,
        capacity: 7.0,
        time: '2018-08-03 16:50:23'
      },
    ];
    commit('setSolidPagination', {page: params.page, limit: params.limit, total: data.length});
    if (data.length > params.limit * params.page) {
      commit('setSolidPresentList', data.slice((params.page - 1) * params.limit, params.page * params.limit));
    } else {
      commit('setSolidPresentList', data.slice((params.page - 1) * params.limit, data.length));
    }

  },
  setSolidPresentList({commit, state}, data) {
    commit('setSolidPresentList', data)
  },
  setSolidPagination({commit, state}, data) {
    commit('setSolidPagination', data)
  }
};
