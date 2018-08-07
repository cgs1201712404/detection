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
          <div id="chartLineGas" style="width:100%; height:500px;"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>实时数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableGas">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="sD"
              label="二氧化硫">
            </el-table-column>
            <el-table-column
              prop="nOZ"
              label="二氧化氮">
            </el-table-column>
            <el-table-column
              prop="nO"
              label="一氧化氮">
            </el-table-column>
            <el-table-column
              prop="tCM"
              label="隧道一氧化碳">
            </el-table-column>
            <el-table-column
              prop="tSP"
              label="TSP（总悬浮物）">
            </el-table-column>
            <el-table-column
              prop="pM1"
              label="PM1">
            </el-table-column>
            <el-table-column
              prop="pM25"
              label="PM2.5">
            </el-table-column>
            <el-table-column
              prop="pM10"
              label="PM10">
            </el-table-column>
            <el-table-column
              prop="temperature"
              label="温度">
            </el-table-column>
            <el-table-column
              prop="humidity"
              label="湿度">
            </el-table-column>
            <el-table-column
              prop="atmPress"
              label="大气压">
            </el-table-column>
            <el-table-column
              prop="windSpeed"
              label="风速">
            </el-table-column>
            <el-table-column
              prop="rainfall"
              label="降雨量">
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
      this.chartLine = echarts.init(document.getElementById('chartLineGas'));
      this.chartLine.setOption(this.chartWasteGas);
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('setGasPagination', pagination)
      },
      refreshGasChart() {
        let that = this;
        setTimeout(function () {
          let chartLine = document.getElementById('chartLineGas');
          chartLine.removeAttribute("_echarts_instance_");//加上这句
          that.chartLine = echarts.init(chartLine);
          that.chartLine.setOption(that.chartWasteGas);
        }, 100)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getGasPresentList', params)
      },
      getPresentList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getGasPresentList', params)
      }
    },
    computed: {
      chartWasteGas() {
        let presentList = this.$store.state.wasteGas.presentList;
        let xData = presentList.map(function (wasteGas) {
          return wasteGas.time;
        });
        let sDs = presentList.map(function (wasteGas) {
          return wasteGas.sD;
        });
        let nOZs = presentList.map(function (wasteGas) {
          return wasteGas.nOZ;
        });
        let nOs = presentList.map(function (wasteGas) {
          return wasteGas.nO;
        });
        let tCMs = presentList.map(function (wasteGas) {
          return wasteGas.tCM;
        });
        let tSPa = presentList.map(function (wasteGas) {
          return wasteGas.tSP;
        });
        let pM1s = presentList.map(function (wasteGas) {
          return wasteGas.pM1;
        });
        let pM25s = presentList.map(function (wasteGas) {
          return wasteGas.pM25;
        });
        let pM10s = presentList.map(function (wasteGas) {
          return wasteGas.pM10;
        });
        let temperatures = presentList.map(function (wasteGas) {
          return wasteGas.temperature;
        });
        let humiditys = presentList.map(function (wasteGas) {
          return wasteGas.humidity;
        });
        let atmPresses = presentList.map(function (wasteGas) {
          return wasteGas.atmPress;
        });
        let windSpeeds = presentList.map(function (wasteGas) {
          return wasteGas.windSpeed;
        });
        let rainfalls = presentList.map(function (wasteGas) {
          return wasteGas.rainfall;
        });
        let option = {
          title: {
            text: '折线图堆叠'
          },
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['二氧化硫', '二氧化氮', '一氧化氮', '隧道一氧化碳', 'TSP（总悬浮物）', 'PM1', 'PM2.5', 'PM10', '温度',
              '湿度', '大气压', '风速', '降雨量']
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
              data: sDs
            },
            {
              name: '二氧化氮',
              type: 'line',
              stack: '总量',
              data: nOZs
            },
            {
              name: '一氧化氮',
              type: 'line',
              stack: '总量',
              data: nOs
            },
            {
              name: '隧道一氧化碳',
              type: 'line',
              stack: '总量',
              data: tCMs
            },
            {
              name: 'TSP（总悬浮物）',
              type: 'line',
              stack: '总量',
              data: tSPa
            },
            {
              name: 'PM1',
              type: 'line',
              stack: '总量',
              data: pM1s
            },
            {
              name: 'PM2.5',
              type: 'line',
              stack: '总量',
              data: pM25s
            },
            {
              name: 'PM10',
              type: 'line',
              stack: '总量',
              data: pM10s
            },
            {
              name: '温度',
              type: 'line',
              stack: '总量',
              data: temperatures
            },
            {
              name: '湿度',
              type: 'line',
              stack: '总量',
              data: humiditys
            },
            {
              name: '大气压',
              type: 'line',
              stack: '总量',
              data: atmPresses
            },
            {
              name: '风速',
              type: 'line',
              stack: '总量',
              data: windSpeeds
            },
            {
              name: '降雨量',
              type: 'line',
              stack: '总量',
              data: rainfalls
            }
          ]
        };
        return option;
      },
      tableGas() {
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
