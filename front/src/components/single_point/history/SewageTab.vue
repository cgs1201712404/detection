/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/8/8 15:10
\* Description: 单点监测中历史数据模块污水类组件
\*/
<template id="sewage-h-tab">
  <div>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>历史数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableSewages">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="pH"
              label="PH">
            </el-table-column>
            <el-table-column
              prop="cod"
              label="COD">
            </el-table-column>
            <el-table-column
              prop="nH3N"
              label="氨氮">
            </el-table-column>
            <el-table-column
              prop="tP"
              label="总磷">
            </el-table-column>
            <el-table-column
              prop="oil"
              label="水中油">
            </el-table-column>
            <el-table-column
              prop="flow"
              label="流量">
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
    name: "SewageHTab",
    mounted() {
      this.getHistoryList();
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('setSewagePagination', pagination)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getSewageHistoryList', params)
      },
      getHistoryList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getSewageHistoryList', params)
      }
    },
    computed: {
      tableSewages() {
        return this.$store.state.sewage.historyList;
      },
      pagination() {
        return this.$store.state.sewage.pagination;
      },
    }
  }
</script>

<style scoped>

</style>
