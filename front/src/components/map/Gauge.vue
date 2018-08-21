/**
\* Created with WebStorm.
\* User: 彭诗杰
\* Date: 2018/8/21 11:23
\* Description: 仪器表组件
\*/
<template id="gauge">
  <el-row>

    <el-card shadow="never">
      <div :id="label" style="width:100%; height:20em;"></div>
    </el-card>
  </el-row>
</template>

<script>
  const echarts = require('echarts');
  export default {
    name: "Gauge",
    props: {
      label: String,
      value: Number
    },
    data() {
      return {
        chartGauge: {}
      }
    },
    computed: {
      dataGauge() {
        let option = {
          tooltip: {
            formatter: "{a} <br/>{b} : {c}%"
          },
          // toolbox: {
          //   feature: {
          //     restore: {},
          //     saveAsImage: {}
          //   }
          // },
          series: [
            {
              name: '业务指标',
              type: 'gauge',
              detail: {formatter: '{value}%'},
              data: [{value: this.value, name: this.label}]
            }
          ]
        };
        return option;
      }
    },
    methods: {},
    mounted() {
      this.chartGauge = echarts.init(document.getElementById(this.label));
      this.chartGauge.setOption(this.dataGauge);
    }
  }
</script>

<style scoped lang="scss">

</style>
