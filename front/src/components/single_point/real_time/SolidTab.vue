/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/8/7 19:02
\* Description: 单点监测中固废当日数据组件
\*/
<template id="solid-tab">
  <div>
    <el-row>
      <el-col :md="24" :xl="24">
        <el-card shadow="never">
          <div id="chartLineSolid" style="width:100%; height:500px;"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>实时数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableSolid">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="capacity"
              label="垃圾压缩池池容">
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
    name: "SolidTab",
    data() {
      return {
        chartLine: {}
      }
    },
    mounted() {
      this.getPresentList();
      this.chartLine = echarts.init(document.getElementById('chartLineSolid'));
      this.chartLine.setOption(this.chartSolid);
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('setSolidPagination', pagination)
      },
      refreshSolidChart() {
        let that = this;
        setTimeout(function () {
          let chartLine = document.getElementById('chartLineSolid');
          chartLine.removeAttribute("_echarts_instance_");//加上这句
          that.chartLine = echarts.init(chartLine);
          that.chartLine.setOption(that.chartSolid);
        }, 100)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getSolidPresentList', params)
      },
      getPresentList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getSolidPresentList', params)
      }
    },
    computed: {
      chartSolid() {
        let presentList = this.$store.state.solid.presentList;
        let xData = presentList.map(function (solid) {
          return solid.time;
        });
        let capacities = presentList.map(function (solid) {
          return solid.capacity;
        });
        let option = {
          title: {
            text: '折线图堆叠'
          },
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['垃圾压缩池池容']
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
              name: '垃圾压缩池池容',
              type: 'line',
              stack: '总量',
              data: capacities
            },
          ]
        };
        return option;
      },
      tableSolid() {
        return this.$store.state.solid.presentList;
      },
      pagination() {
        return this.$store.state.solid.pagination;
      }
    }
  }
</script>

<style scoped>

</style>
