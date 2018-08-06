/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/8/3 15:10
\* Description: 单点监测中污水类组件
\*/
<template id="sewage-tab">
  <div>
    <el-row>
      <el-col :md="24" :xl="24">
        <el-card shadow="never">
          <div id="chartLine" style="width:100%; height:500px;"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>实时数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableSewages">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="pH"
              label="PH">
            </el-table-column>
            <el-table-column
              prop="cod"
              label="COD">
            </el-table-column>
            <el-table-column
              prop="nH3N"
              label="氨氮">
            </el-table-column>
            <el-table-column
              prop="tP"
              label="总磷">
            </el-table-column>
            <el-table-column
              prop="sS"
              label="悬浮物">
            </el-table-column>
            <el-table-column
              prop="time"
              label="时间">
            </el-table-column>
          </el-table>
        </el-col>
      </el-card>
    </el-row>
    <el-row class="pagination-row">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="flipOver"
        :current-page="pagination.page"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="pagination.limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="pagination.total">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  const echarts = require('echarts');
  export default {
    name: "sewageTab",
    data() {
      return {
        chartLine: {}
      }
    },
    mounted() {
      this.getPresentList();
      this.chartLine = echarts.init(document.getElementById('chartLine'));
      this.chartLine.setOption(this.chartSewages);
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('setSewagePagination', pagination)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getSewagePresentList', params)
      },
      getPresentList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getSewagePresentList', params)
      }
    },
    computed: {
      chartSewages() {
        let presentList = this.$store.state.sewage.presentList;
        let xData = presentList.map(function (sewage) {
          return sewage.time;
        });
        let phs = presentList.map(function (sewage) {
          return sewage.pH;
        });
        let cods = presentList.map(function (sewage) {
          return sewage.cod;
        });
        let nH3Ns = presentList.map(function (sewage) {
          return sewage.nH3N;
        });
        let tPs = presentList.map(function (sewage) {
          return sewage.tP;
        });
        let sSs = presentList.map(function (sewage) {
          return sewage.sS;
        });
        let option = {
          title: {
            text: '折线图堆叠'
          },
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['PH', 'COD', '氨氮', '总磷', '悬浮物']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          toolbox: {
            feature: {
              saveAsImage: {}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: xData
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name: 'PH',
              type: 'line',
              stack: '总量',
              data: phs
            },
            {
              name: 'COD',
              type: 'line',
              stack: '总量',
              data: cods
            },
            {
              name: '氨氮',
              type: 'line',
              stack: '总量',
              data: nH3Ns
            },
            {
              name: '总磷',
              type: 'line',
              stack: '总量',
              data: tPs
            },
            {
              name: '悬浮物',
              type: 'line',
              stack: '总量',
              data: sSs
            }
          ]
        };
        return option;
      },
      tableSewages() {
        return this.$store.state.sewage.presentList;
      },
      pagination() {
        return this.$store.state.sewage.pagination;
      },
    }
  }
</script>

<style scoped>
  .table-row {
    margin-top: 3em;
  }

  .pagination-row {
    margin-top: 2em;
  }
</style>
