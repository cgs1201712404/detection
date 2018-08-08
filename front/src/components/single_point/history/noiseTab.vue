/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/8/8 15:10
\* Description: 单点监测中历史数据模块噪声类组件
\*/
<template id="noise-h-tab">
  <div>
    <el-row class="table-row">
      <el-card shadow="never">
        <el-col :offset="10" :md="4" :xl="4">
          <h3>实时数据</h3>
        </el-col>
        <el-col :md="24" :xl="24">
          <el-table style="width: 100%" :data="tableNoise">
            <el-table-column
              type="index">
            </el-table-column>
            <el-table-column
              prop="intensity"
              label="噪声强度">
            </el-table-column>
            <el-table-column
              prop="frequency"
              label="噪声频率">
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
    name: "noiseHTab",
    mounted() {
      this.getHistoryList();
    },
    methods: {
      handleSizeChange(val) {
        let pagination = this.pagination;
        pagination.limit = val;
        this.$store.dispatch('setNoisePagination', pagination)
      },
      flipOver(page) {
        let params = {page: page, limit: this.pagination.limit};
        this.$store.dispatch('getNoiseHistoryList', params)
      },
      getHistoryList() {
        let params = {page: 1, limit: this.pagination.limit};
        this.$store.dispatch('getNoiseHistoryList', params)
      }
    },
    computed: {
      tableNoise() {
        return this.$store.state.noise.historyList;
      },
      pagination() {
        return this.$store.state.noise.pagination;
      },
    }
  }
</script>

<style scoped>

</style>
