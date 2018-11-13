/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* Date: 2018/8/6 16:08
\* Description:
\*/
<template id="noise-tab">
  <div>
    <el-row>
      <el-col :md="24" :xl="24">
        <el-card shadow="never">
          <div id="chartLineNoise" style="width:100%; height:500px;"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>实时数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableNoise">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="intensity"
              label="噪声强度">
            </el-table-column>
            <el-table-column
              prop="frequency"
              label="噪声频率">
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
    name: "NoiseTab",
    data() {
      return {
        chartLine: {}
      }
    },
    mounted() {
      this.getPresentList();
      this.chartLine = echarts.init(document.getElementById('chartLineNoise'));
      this.chartLine.setOption(this.chartNoise);
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('setNoisePagination', pagination)
      },
      refreshNoiseChart() {
        let that = this;
        setTimeout(function () {
          let chartLine = document.getElementById('chartLineNoise');
          chartLine.removeAttribute("_echarts_instance_");//加上这句
          that.chartLine = echarts.init(chartLine);
          that.chartLine.setOption(that.chartNoise);
        }, 100)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getNoisePresentList', params)
      },
      getPresentList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getNoisePresentList', params)
      }
    },
    computed: {
      chartNoise() {
        let presentList = this.$store.state.noise.presentList;
        let xData = presentList.map(function (noise) {
          return noise.time;
        });
        let intensities = presentList.map(function (noise) {
          return noise.intensity;
        });
        let frequencies = presentList.map(function (noise) {
          return noise.frequency;
        });
        let option = {
          title: {
            text: '折线图堆叠'
          },
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['噪声强度', '噪声频率']
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
              name: '噪声强度',
              type: 'line',
              stack: '总量',
              data: intensities
            },
            {
              name: '噪声频率',
              type: 'line',
              stack: '总量',
              data: frequencies
            }
          ]
        };
        return option;
      },
      tableNoise() {
        return this.$store.state.noise.presentList;
      },
      pagination() {
        return this.$store.state.noise.pagination;
      }
    }
  }
</script>

<style scoped>

</style>
