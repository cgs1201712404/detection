/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/8/8 15:10
\* Description: 单点监测中历史数据模块大气类组件
\*/
<template id="gas-h-tab">
  <div>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>实时数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableGas">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="sD"
              label="二氧化硫">
            </el-table-column>
            <el-table-column
              prop="nOZ"
              label="二氧化氮">
            </el-table-column>
            <el-table-column
              prop="nO"
              label="一氧化氮">
            </el-table-column>
            <el-table-column
              prop="tCM"
              label="隧道一氧化碳">
            </el-table-column>
            <el-table-column
              prop="tSP"
              label="TSP（总悬浮物）">
            </el-table-column>
            <el-table-column
              prop="pM1"
              label="PM1">
            </el-table-column>
            <el-table-column
              prop="pM25"
              label="PM2.5">
            </el-table-column>
            <el-table-column
              prop="pM10"
              label="PM10">
            </el-table-column>
            <el-table-column
              prop="temperature"
              label="温度">
            </el-table-column>
            <el-table-column
              prop="humidity"
              label="湿度">
            </el-table-column>
            <el-table-column
              prop="atmPress"
              label="大气压">
            </el-table-column>
            <el-table-column
              prop="windSpeed"
              label="风速">
            </el-table-column>
            <el-table-column
              prop="rainfall"
              label="降雨量">
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
  export default {
    name: "GasHTab",
    mounted() {
      this.getHistoryList();
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('getGasHistoryList', pagination)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getGasHistoryList', params)
      },
      getHistoryList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getGasHistoryList', params)
      }
    },
    computed: {
      tableGas() {
        return this.$store.state.wasteGas.historyList;
      },
      pagination() {
        return this.$store.state.wasteGas.pagination;
      },
    }

  }
</script>

<style scoped>

</style>
