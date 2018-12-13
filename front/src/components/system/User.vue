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
          <el-button type="success" icon="el-icon-circle-plus-outline" @click="addUser">添加用户</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" icon="el-icon-download" @click="batchRemoveUsers">批量删除</el-button>
        </el-form-item>
        <el-form-item style="margin-left: 2em">
          <el-input placeholder="请输入用户姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search">查询</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="table-row" v-loading="loading" element-loading-text="正在加载">
      <el-table border :data="users" @selection-change="selUsersChange">
        <el-table-column
          type="selection">
        </el-table-column>
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
          prop="cellPhone"
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
            <el-button size="small" type="success" @click="editUser(scope.$index,scope.row)">编辑</el-button>
            <el-button size="small" type="danger" @click="removeUser(scope.$index,scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <user-dialog ref="userDialog" :contextOp="contextOp">
      </user-dialog>
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
  import UserDialog from "./UserDialog";

  export default {
    name: "User",
    components: {UserDialog},
    computed: {
      ...mapGetters([
        'users'
      ])
    },
    data() {
      return {
        contextOp: 'add',
        loading: false,
        selUsers: [],
        pagination: {
          page: 1,
          limit: 10,
          total: 100
        }
      }
    },
    methods: {
      ...mapActions([
        'getAllUsersPaging',
        'removeUserAct',
        'removeUsersAct'
      ]),
      handleSizeChange() {

      },
      flipOver() {

      },
      selUsersChange(selection) {
        this.selUsers = selection;
      },
      addUser() {
        this.contextOp = 'add';
        this.$refs.userDialog.open();
      },
      removeUser(index, row) {
        this.$confirm('是否删除该用户?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.removeUserAct(row);
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {

        });
      },
      batchRemoveUsers() {
        this.$confirm('确认批量删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          if (this.selUsers && this.selUsers.length === 0) {
            this.$message({type: 'warning', message: '请选择待删除用户!'});
          } else {
            this.removeUsersAct(this.selUsers);
            this.selUsers = [];
            this.$message({type: 'success', message: '删除成功!'});
          }
        }).catch(() => {

        });
      },
      editUser(index, row) {
        this.contextOp = 'edit';
        this.$refs.userDialog.open(row);
      },
      initComp() {
        this.loading = true;
        this.getAllUsersPaging({}).then(result => {
          this.loading = false;
        }).catch(error => {
          this.loading = false;
          this.$message({type: 'error', message: error.toString()});
        })
        // this.mockUsers();
      }
    },
    created() {
      this.initComp();
    }
  }
</script>

<style scoped>

</style>
