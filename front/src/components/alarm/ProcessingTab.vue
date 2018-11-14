/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* @time: 2018/11/14 11:15
\* Description: 报警处理
\*/
<template id="processing-tab">
  <el-row>
    <el-row class="table-row">
      <el-table border :data="alarmProcessings">
        <el-table-column
          type="index">
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
          prop="deviceId"
          label="设备编号">
        </el-table-column>
        <el-table-column
          prop="deviceName"
          label="设备名称">
        </el-table-column>
        <el-table-column
          prop="normalLimit"
          label="正常范围">
        </el-table-column>
        <el-table-column
          prop="value"
          label="实际值">
        </el-table-column>
        <el-table-column
          prop="level"
          label="报警级别">
        </el-table-column>
        <el-table-column
          prop="time"
          label="报警时间">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button v-if="param == 'unprocessed'" size="small" type="primary"
                       @click="handleProcessing(scope.$index,scope.row)">处理
            </el-button>
            <el-button v-else size="small" type="success" @click="showDetail(scope.$index,scope.row)">查看</el-button>
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
  </el-row>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "ProcessingTab",
    props: ['param'],
    computed: {
      ...mapGetters([
        'alarmProcessings',
        'alarmConfigs'
      ])
    },
    methods: {
      ...mapActions([
        'initAlarmProcessings'
      ]),
      showDetail(index, row) {
        console.log(row)
      },
      handleProcessing(index, row) {
        console.log(row)
      },
      handleSizeChange() {

      },
      flipOver() {

      }
    },
    data() {
      return {
        pagination: {
          page: 1,
          limit: 10,
          total: 100
        }
      }
    }
  }
</script>

<style scoped>

</style>
