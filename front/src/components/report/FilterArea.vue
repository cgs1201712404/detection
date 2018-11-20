/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* Date: 2018/11/20
\* Time: 22:12
\* Description:
\*/
<template id="filter-area">
  <el-row style="margin-top: 2em">
    <el-form :inline="true" :model="filters">
      <el-form-item label="服务区名称">
        <el-select v-model="filters.areaName" placeholder="请选择">
          <el-option v-for="area in areaList" :key="area.name" :label="area.name" :value="area.name"></el-option>
        </el-select>
      </el-form-item>
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
      <el-select v-model="filters.selectCity" @change="cityChange" placeholder="市/州" clearable>
        <el-option v-for="city in cities" :key="city.name" :label="city.name" :value="city.name">
        </el-option>
      </el-select>
      <el-select v-model="filters.selectDistrict" placeholder="区/县" clearable>
        <el-option v-for="district in districts" :key="district" :label="district" :value="district">
        </el-option>
      </el-select>

    </el-form>
    <el-form :inline="true" :model="filters">
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
</template>

<script>
  import constants from '../../common/constants'
  import {mapActions, mapGetters} from 'vuex';
  import ElRow from "element-ui/packages/row/src/row";
  import ElForm from "../../../node_modules/element-ui/packages/form/src/form.vue";

  export default {
    components: {
      ElForm,
      ElRow
    },
    name: "FilterArea",
    computed: {
      ...mapGetters([
        'areaList',
      ])
    },
    data() {
      return {
        cities: constants.cities,
        districts: [],
        classifications: constants.classifications,
        factors: [],
        filters: {
          areaName: '',
          selectCity: '',
          selectDistrict: '',
          start: '',
          end: ''
        },
        pagination: {
          page: 1,
          limit: 10,
          total: 100
        }
      }
    },
    methods: {
      cityChange(value) {
        let that = this;
        this.cities.forEach( (city) => {
          if (value === city.name) {
            that.districts = city.counties;
          }
        })
      },
      classificationChange(value) {
        let that = this;
        that.classifications.forEach(function (classification, index) {
          if (value === classification.value) {
            that.factors = classification.factors;
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
