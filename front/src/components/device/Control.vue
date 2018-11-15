/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 16:54
\* Description: 设备控制页面组件
\*/
<template>
  <el-row :gutter="20">
    <el-col :md="4" :xl="4">
      <search-bar>
      </search-bar>
    </el-col>
    <el-col :md="20" :xl="20">
      <el-row>
        <div><span>监测点：<b>{{area.name}}</b></span><span
          style="margin-left: 2em"> 详细地址：{{area.district.detail}}</span></div>
      </el-row>
      <el-row style="margin-top: 2em">
        <el-row>
          <el-form :inline="true" :model="filters">
            <el-form-item label="监测类型">
              <el-select v-model="filters.type" placeholder="请选择" clearable @change="classificationChange">
                <el-option v-for="entry in classifications" :label="entry.label" :value="entry.value"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="监测因子">
              <el-select v-model="filters.factor" placeholder="请选择" clearable>
                <el-option v-for="factor in factors" :label="factor.label" :value="factor.value"></el-option>
              </el-select>
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
      <el-row>
        <el-table border class="table-row" :data="deviceControls">
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
            prop="deviceId"
            label="设备编号">
          </el-table-column>
          <el-table-column
            prop="deviceName"
            label="设备名称">
          </el-table-column>
          <el-table-column
            prop="status"
            label="当前状态">
          </el-table-column>
          <el-table-column
            prop="time"
            label="维护时间">
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="small" type="success" @click="showDetail(scope.$index,scope.row)">启动</el-button>
              <el-button size="small" type="danger" @click="showDetail(scope.$index,scope.row)">停止</el-button>
            </template>
          </el-table-column>
        </el-table>
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
    </el-col>
  </el-row>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';
  import SearchBar from "../SearchBar";
  import constants from '../../common/constants'

  export default {
    name: "Device",
    components: {SearchBar},
    computed: {
      ...mapGetters([
        'area',
        'deviceControls'
      ])
    },
    methods: {
      ...mapActions([
        'setCurrentArea',
        'initControls'
      ]),
      showDetail(index, row) {
        console.log(row)
      },
      handleSizeChange() {

      },
      flipOver() {

      },
      classificationChange(value) {
        let that =this;
        that.classifications.forEach(function (classification, index) {
          if (value === classification.value) {
            that.factors = classification.factors;
          }
        })
      }
    },
    data() {
      return{
        classifications: constants.classifications,
        factors: [],
        filters: {
          type:'',
          factor: '',
          deviceName: ''
        },
        pagination: {
          page: 1,
          limit: 10,
          total: 100
        }
      }
    },
    mounted() {
      this.initControls();
    },
    created() {
      // 初始化当前area
      this.setCurrentArea({
        name: '常青花园服务区',
        district: {
          province: '湖北',
          city: '武汉',
          county: '江汉',
          detail: '武汉市江汉区常青三路122号'
        }
      });
    }
  }

</script>

<style scoped>

</style>
