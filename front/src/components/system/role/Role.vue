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
          <el-button type="success" icon="el-icon-circle-plus-outline" @click="addRole">添加角色</el-button>
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
    <el-row class="table-row" v-loading="loading" element-loading-text="正在加载">
      <el-table border :data="roles" @selection-change="selectionChange">
        <el-table-column
          type="selection">
        </el-table-column>
        <el-table-column
          type="index">
        </el-table-column>
        <el-table-column
          prop="name"
          label="角色名称">
        </el-table-column>
        <el-table-column
          prop="note"
          label="备注">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="small" type="warning" @click="grantPermissions(scope.$index,scope.row)">分配权限</el-button>
            <el-button size="small" type="success" @click="editRole(scope.$index,scope.row)">编辑</el-button>
            <el-button size="small" type="danger" @click="removeRole(scope.$index,scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <authorization-dialog ref="auth">
      </authorization-dialog>
      <add-role-dialog ref="addDialog">
      </add-role-dialog>
      <edit-role-dialog ref="editDialog">
      </edit-role-dialog>
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
  import EditRoleDialog from "./EditRoleDialog";

  export default {
    name: "Role",
    components: {EditRoleDialog, AddRoleDialog, AuthorizationDialog},
    computed: {
      ...mapGetters([
        'roles'
      ])
    },
    data() {
      return {
        loading: false,
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
        'getAllRolesPaging',
        'setRoleDialog',
        'removeRoleAct',
        'removeRolesAct'
      ]),
      handleSizeChange() {

      },
      flipOver() {

      },
      grantPermissions(index, row) {
        this.setRoleDialog(row).then(msg => {
          this.$refs.auth.open();
        }).catch(error => {
          this.$message({type: 'error', message: error.toString()});
        })
      },
      editRole(index, row) {
        this.setRoleDialog(row).then(result => {
          this.$refs.editDialog.open();
        }).catch(error => {
          this.$message({type: 'error', message: error.toString()});
        })
      },
      removeRole(index, row) {
        this.$confirm('是否删除该角色?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.removeRoleAct(row).then(result => {
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
          }).catch(error => {
            this.$message({
              type: 'error',
              message: error.toString()
            });
          })
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
            this.removeRolesAct(this.selRoles).then(result => {
              this.$message({type: 'success', message: '删除成功!'});
            }).catch(error => {
              this.$message({
                type: 'error',
                message: error.toString()
              });
            })
          }
        }).catch(() => {

        });
      },
      /**
       * 新建角色按钮回调函数
       */
      addRole() {
        this.$refs.addDialog.open();
      },

      selectionChange(selection) {
        this.selRoles = selection;
      },
      compInit() {
        this.loading = true;
        this.getAllRolesPaging({
          page: this.pagination.page,
          limit: this.pagination.limit
        }).then(result => {
          this.loading = false;
          this.pagination.total = result.total;
        }).catch(err => {
          this.loading = false;
          this.$message({type: 'error', message: err.toString()});
        })
      }
    },
    created() {
      this.compInit();
    }
  }
</script>

<style scoped>

</style>
