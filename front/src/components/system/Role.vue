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
          <el-button type="danger" icon="el-icon-download" @click="batchRemoveRoles">批量删除</el-button>
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
      <el-table border :data="roles" @selection-change="selectionChange">
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
            <el-button size="small" type="danger" @click="removeRole(scope.$index,scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <authorization-dialog ref="auth">
      </authorization-dialog>
      <add-role-dialog>
      </add-role-dialog>
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
  import AddRoleDialog from "./AddRoleDialog";

  export default {
    name: "Role",
    components: {AddRoleDialog, AuthorizationDialog},
    computed: {
      ...mapGetters([
        'roles'
      ])
    },
    data() {
      return {
        selRoles: [],
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
        'setRoleDialog',
        'removeRoleAct',
        'removeRolesAct'
      ]),
      handleSizeChange() {

      },
      flipOver() {

      },
      grantPermissions(index, row) {
        this.setRoleDialog(row);
        this.$refs.auth.open();
      },
      removeRole(index, row) {
        this.$confirm('是否删除该角色?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.removeRoleAct(row);
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {

        });
      },
      batchRemoveRoles() {
        this.$confirm('确认批量删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          if (this.selRoles && this.selRoles.length === 0) {
            this.$message({type: 'warning', message: '请选择待删除角色!'});
          } else {
            this.removeRolesAct(this.selRoles);
            // this.selRoles = [];
            this.$message({type: 'success', message: '删除成功!'});
          }
        }).catch(() => {

        });
      },

      selectionChange(selection) {
        this.selRoles = selection;
      }
    },

    created() {
      this.mockRoles();
    }
  }
</script>

<style scoped>

</style>
