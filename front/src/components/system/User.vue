/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 17:25
\* Description: 用户管理组件
\*/
<template>
  <el-row>
    <el-row style="margin-top: 2em">
      <el-form :inline="true">
        <el-form-item>
          <el-button type="success" icon="el-icon-circle-plus-outline">添加用户</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" icon="el-icon-download">批量删除</el-button>
        </el-form-item>
        <el-form-item style="margin-left: 2em">
          <el-input placeholder="请输入用户姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search">查询</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="table-row">
      <el-table border :data="users">
        <el-table-column
          type="index">
        </el-table-column>
        <el-table-column
          prop="userName"
          label="用户名">
        </el-table-column>
        <el-table-column
          prop="password"
          label="密码">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名">
        </el-table-column>
        <el-table-column
          prop="gender"
          label="性别">
        </el-table-column>
        <el-table-column
          prop="phone"
          label="手机">
        </el-table-column>
        <el-table-column
          prop="department"
          label="部门">
        </el-table-column>
        <el-table-column
          prop="position"
          label="职务">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="small" type="success">编辑</el-button>
            <el-button size="small" type="danger">删除</el-button>
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
    name: "User",
    computed: {
      ...mapGetters([
        'users'
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
        'mockUsers'
      ]),
      handleSizeChange() {

      },
      flipOver() {

      }
    },
    created() {
      this.mockUsers();
    }
  }
</script>

<style scoped>

</style>
