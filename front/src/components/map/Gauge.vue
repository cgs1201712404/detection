/**
\* Created with WebStorm.
\* User: 彭诗杰
\* Date: 2018/8/21 11:23
\* Description: 仪器表组件
\*/
<template id="gauge">
  <el-row>
    <el-card shadow="never">
      <div :id="label" style="width:100%; height:15em;"></div>
      <div style="text-align: center"><a href="javascript:void(0)">{{label}}</a></div>
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
              detail: {formatter: '{value}'},
              data: [{value: this.value}]
            }
          ]
        };
        return option;
      }
    },
    methods: {
      refreshGauge() {
        let that = this;
        setTimeout(function () {
          let gauge = document.getElementById(that.label);
          gauge.removeAttribute("_echarts_instance_");//加上这句
          that.gauge = echarts.init(gauge);
          that.gauge.setOption(that.dataGauge);
        }, 100)
      }
    },
    mounted() {
      this.chartGauge = echarts.init(document.getElementById(this.label));
      this.chartGauge.setOption(this.dataGauge);
    }
  }
</script>

<style scoped lang="scss">

</style>
