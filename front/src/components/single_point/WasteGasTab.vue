/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/8/6 14:27
\* Description: 单点监测中大气类组件
\*/
<template id="waste-gas-tab">
  <div>
    <el-row>
      <el-col :md="24" :xl="24">
        <el-card shadow="never">
          <div id="chartLineWaste" style="width:100%; height:500px;"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>实时数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableWaste">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="sD"
              label="二氧化硫">
            </el-table-column>
            <el-table-column
              prop="nOX"
              label="氮氧化物">
            </el-table-column>
            <el-table-column
              prop="tCM"
              label="隧道一氧化碳">
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
    name: "wasteGasTab",
    data() {
      return {
        chartLine: {}
      }
    },
    mounted() {
      this.getPresentList();
      this.chartLine = echarts.init(document.getElementById('chartLineWaste'));
      this.chartLine.setOption(this.chartWasteGas);
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('setWastePagination', pagination)
      },
      refreshWasteChart() {
        let that = this;
        setTimeout(function () {
          let chartLine = document.getElementById('chartLineWaste');
          chartLine.removeAttribute("_echarts_instance_");//加上这句
          that.chartLine = echarts.init(chartLine);
          that.chartLine.setOption(that.chartWasteGas);
        }, 100)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getWastePresentList', params)
      },
      getPresentList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getWastePresentList', params)
      }
    },
    computed: {
      chartWasteGas() {
        let presentList = this.$store.state.wasteGas.presentList;
        let xData = presentList.map(function (wasteGas) {
          return wasteGas.time;
        });
        let nOXs = presentList.map(function (wasteGas) {
          return wasteGas.nOX;
        });
        let sDs = presentList.map(function (wasteGas) {
          return wasteGas.sD;
        });
        let tCMs = presentList.map(function (wasteGas) {
          return wasteGas.tCM;
        });
        let option = {
          title: {
            text: '折线图堆叠'
          },
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['二氧化硫', '氮氧化物', '隧道一氧化碳']
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
              name: '二氧化硫',
              type: 'line',
              stack: '总量',
              data: nOXs
            },
            {
              name: '氮氧化物',
              type: 'line',
              stack: '总量',
              data: sDs
            },
            {
              name: '隧道一氧化碳',
              type: 'line',
              stack: '总量',
              data: tCMs
            }
          ]
        };
        return option;
      },
      tableWaste() {
        return this.$store.state.wasteGas.presentList;
      },
      pagination() {
        return this.$store.state.wasteGas.pagination;
      },
    }
  }
</script>

<style scoped>

</style>
