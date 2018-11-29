/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 17:25
\* Description: 角色权限管理组件
\*/
<template>
  <el-row>
    <el-row style="margin-top: 2em">
      <el-form :inline="true">
        <el-form-item>
          <el-button type="success" icon="el-icon-circle-plus-outline">添加角色</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" icon="el-icon-download">批量删除</el-button>
        </el-form-item>
        <el-form-item style="margin-left: 2em">
          <el-input placeholder="请输入角色名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search">查询</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="table-row">
      <el-table border :data="roles">
        <el-table-column
          type="selection">
        </el-table-column>
        <el-table-column
          type="index">
        </el-table-column>
        <el-table-column
          prop="roleName"
          label="角色名称">
        </el-table-column>
        <el-table-column
          prop="note"
          label="备注">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="small" type="warning" @click="grantPermissions(scope.$index,scope.row)">分配权限</el-button>
            <el-button size="small" type="success">编辑</el-button>
            <el-button size="small" type="danger">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <authorization-dialog ref="auth">
      </authorization-dialog>
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
  import AuthorizationDialog from "./AuthorizationDialog";

  export default {
    name: "Role",
    components: {AuthorizationDialog},
    computed: {
      ...mapGetters([
        'roles'
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
        'mockRoles',
        'setRoleDialog'
      ]),
      handleSizeChange() {

      },
      flipOver() {

      },
      grantPermissions(index, row) {
        console.log(row);
        // this.setRoleDialog(row);
        this.$refs.auth.open();
      }
    },
    created() {
      this.mockRoles();
    }
  }
</script>

<style scoped>

</style>
