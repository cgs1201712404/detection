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
            <el-select v-model="filters.type" placeholder="请选择" clearable @change="classificationChange">
              <el-option v-for="entry in classifications" :key="entry.value" :label="entry.label"
                         :value="entry.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="监测因子" clearable>
            <el-select v-model="filters.factor" clearable>
              <el-option v-for="factor in factors" :key="factor.value" :label="factor.label"
                         :value="factor.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="设备名称">
            <el-input v-model="filters.deviceName"></el-input>
          </el-form-item>
        </el-form>
      </el-row>
      <el-row style="margin-top: .5em">
        <el-button type="primary" icon="el-icon-search">查询</el-button>
        <el-button type="primary" icon="el-icon-circle-plus-outline">新增</el-button>
      </el-row>
    </el-row>
    <el-row class="table-row">
      <el-table border class="table-row" :data="alarmConfigs">
        <el-table-column
          type="index">
        </el-table-column>
        <el-table-column
          prop="type"
          label="监测类型">
        </el-table-column>
        <el-table-column
          prop="factor"
          label="监测因子">
        </el-table-column>
        <el-table-column
          prop="normalLimit"
          label="正常范围">
        </el-table-column>
        <el-table-column
          prop="trigger"
          label="报警条件">
        </el-table-column>
        <el-table-column
          prop="enabled"
          label="是否启用">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="small" icon="el-icon-edit" type="success"
                       @click="update(scope.$index,scope.row)"></el-button>
            <el-button size="small" icon="el-icon-delete" type="danger"
                       @click="remove(scope.$index,scope.row)"></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
  </el-row>
</template>

<script>
  import constants from '../../common/constants'
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "configuration",
    computed: {
      ...mapGetters([
        'alarmConfigs'
      ])
    },
    data() {
      return {
        classifications: constants.classifications,
        factors: [],
        filters: {
          type: '',
          factor: '',
          deviceName: ''
        },
      }
    },
    methods: {
      ...mapActions([
        'initAlarmConfigs'
      ]),
      update(index, row) {

      },
      remove(index, row) {

      },
      classificationChange(value) {
        let that = this;
        that.classifications.forEach(function (classification, index) {
          if (value === classification.value) {
            that.factors = classification.factors;
          }
        })
      }
    },
    mounted() {
      this.initAlarmConfigs();
    }
  }
</script>

<style scoped>

</style>
