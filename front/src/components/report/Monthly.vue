/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 17:15
\* Description: 月报页面组件
\*/
<template>
  <el-row>
    <filter-area>
    </filter-area>
    <el-row class="table-row">
      <el-table border :data="monthlies">
        <el-table-column
          type="index">
        </el-table-column>
        <el-table-column
          prop="month"
          label="月份">
        </el-table-column>
        <el-table-column
          prop="areaName"
          label="服务区名称">
        </el-table-column>
        <el-table-column
          prop="district"
          label="所属区域">
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
          prop="exceedingAvg"
          label="超标范围平均值">
        </el-table-column>
        <el-table-column
          prop="exceedingNum"
          label="超标记录数">
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
  </el-row>
</template>

<script>
  import FilterArea from "./FilterArea.vue";
  import ElRow from "element-ui/packages/row/src/row";
  import {mapActions, mapGetters} from 'vuex';


  export default {
    name: "Monthly",
    components: {
      ElRow,
      FilterArea
    },
    computed: {
      ...mapGetters([
        'monthlies'
      ])
    },
    data() {
      return {
        pagination: {
          page: 1,
          limit: 10,
          total: 100
        }
      }
    },
    methods: {
      ...mapActions([
        'initMonthlies'
      ]),
      handleSizeChange() {

      },
      flipOver() {

      },
    },
    created() {
      this.initMonthlies();
    }
  }
</script>

<style scoped>

</style>
