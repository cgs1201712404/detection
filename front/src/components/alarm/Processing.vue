/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 17:10
\* Description: 报警处理页面组件
\*/
<template>
  <el-row>
    <el-row style="margin-top: 2em">
      <el-row>
        <el-form :inline="true" :model="filters">
          <el-form-item label="服务区名称">
            <el-select v-model="filters.areaName" placeholder="请选择">
              <el-option v-for="area in areaList" :label="area.name" :value="area.name"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="开始时间">
            <el-date-picker type="date" placeholder="选择日期" v-model="filters.start"
                            style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间">
            <el-date-picker type="date" placeholder="选择日期" v-model="filters.end" style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-download">导出</el-button>
          </el-form-item>
        </el-form>
      </el-row>
    </el-row>
    <el-row class="tab-row">
      <el-tabs v-model="activeTab" @tab-click="handleTabClick">
        <el-tab-pane label="未处理" name="unprocessed">
          <processing-tab :param="activeTab" ref="unprocessedTab"></processing-tab>
        </el-tab-pane>
        <el-tab-pane label="已处理" name="processed">
          <processing-tab :param="activeTab" ref="processedTab"></processing-tab>
        </el-tab-pane>

      </el-tabs>
    </el-row>
  </el-row>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';
  import ProcessingTab from "./ProcessingTab";

  export default {
    name: "alarm",
    components: {ProcessingTab},
    computed: {
      ...mapGetters([
        'areaList',
      ])
    },
    methods: {
      handleTabClick(tab) {
        console.log(tab);
        this.$refs.processedTab.initAlarmProcessings(tab.name)
      },
      initTabs() {
        console.log(this.$refs);
        this.$refs.processedTab.initAlarmProcessings(this.activeTab)
      }
    },
    data() {
      return {
        filters: {
          areaName: '',
          start: '',
          end: ''
        },
        activeTab: 'unprocessed'
      }
    },
    created() {

    },
    mounted() {
      this.initTabs();
    }
  }
</script>

<style scoped>

</style>
