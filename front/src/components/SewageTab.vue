/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/8/3 15:10
\* Description: 单点监测中污水类组件
\*/
<template id="sewage-tab">
  <div>
    <span>污水类</span>
    <el-row>
      <el-col :md="24" :xl="24">
        <div id="chartLine" style="width:100%; height:500px;"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  const echarts = require('echarts');
  export default {
    name: "sewageTab",
    data() {
      return {}
    },
    mounted() {
      this.getPresentList();
    },
    methods: {
      getPresentList() {
        let params = {};
        this.$store.dispatch('getPresentList', params)
      }
    },
    computed: {
      chartSewages() {
        let presentList = this.$store.state.sewage.presentList;
        let xData = presentList.map(function (sewage) {
          return sewage.time;
        });
        let phs = presentList.map(function (sewage) {

        });
        let option = {
          title: {
            text: '折线图堆叠'
          },
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data:['PH','COD','氨氮','总磷','悬浮物']
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
              name:'PH',
              type:'line',
              stack: '总量',
              data:[120, 132, 101, 134, 90, 230, 210]
            },
            {
              name:'COD',
              type:'line',
              stack: '总量',
              data:[220, 182, 191, 234, 290, 330, 310]
            },
            {
              name:'氨氮',
              type:'line',
              stack: '总量',
              data:[150, 232, 201, 154, 190, 330, 410]
            },
            {
              name:'总磷',
              type:'line',
              stack: '总量',
              data:[320, 332, 301, 334, 390, 330, 320]
            },
            {
              name:'悬浮物',
              type:'line',
              stack: '总量',
              data:[820, 932, 901, 934, 1290, 1330, 1320]
            }
          ]
        }
      },
      tableSewages() {

      }
    }
  }
</script>

<style scoped>

</style>
