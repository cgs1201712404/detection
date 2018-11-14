/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 17:11
\* Description: 报警配置页面组件
\*/
<template>
  <el-row>
    <el-row style="margin-top: 2em">
      <el-row>
        <el-form :inline="true" :model="filters">
          <el-form-item label="监测类型">
            <el-select v-model="filters.type" placeholder="请选择">
              <el-option v-for="entry in classifications" :label="entry.label" :value="entry.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="监测因子">
            <el-input v-model="filters.factor"></el-input>
          </el-form-item>
          <el-form-item label="设备名称">
            <el-input v-model="filters.deviceName"></el-input>
          </el-form-item>
        </el-form>
      </el-row>
      <el-row style="margin-top: .5em">
        <el-button type="primary" icon="el-icon-search">查询</el-button>
        <el-button type="primary" icon="el-icon-download">导出</el-button>
      </el-row>
    </el-row>
  </el-row>
</template>

<script>
  import constants from '../../common/constants'

  export default {
    name: "configuration",
    data() {
      return {
        classifications: constants.classifications,
        filters: {
          type:'',
          factor: '',
          deviceName: ''
        },
      }
    }
  }
</script>

<style scoped>

</style>
