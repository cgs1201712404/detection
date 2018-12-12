/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* @time: 2018/11/27 11:42
\* Description:
\*/
<template id="authorization-dialog">
  <el-dialog :visible.sync="dialogVisible" title="权限分配">
    <el-row>
      <el-button type="text">分配权限</el-button>
      <el-button type="success" @click="selectAll">全选</el-button>
      <el-button type="warning" @click="unselectAll">全不选</el-button>
    </el-row>
    <el-row style="margin-top: 2em" v-for="menuPermission in currentRole.permissionGroup" :key="menuPermission.name">
      <el-col :span="6">
        <el-checkbox :label="menuPermission.label" v-model="menuPermission.checked" border></el-checkbox>
      </el-col>
      <el-col :span="18">

        <el-checkbox-button v-for="dataPermission in menuPermission.permission" :label="dataPermission.label"
                            :key="dataPermission.id" v-model="dataPermission.checked"></el-checkbox-button>

      </el-col>
    </el-row>
    <span slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="authSubmit">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
  import util from "../../../common/util";
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "AuthorizationDialog",
    computed: {
      ...mapGetters([
        'roles',
        'roleDialog'
      ]),
      currentRole() {
        return this.roleDialog;
      }
    },
    data() {
      return {
        dialogVisible: false,
      }
    },
    methods: {
      ...mapActions([
        'mockRoles',
        'submitAuthorization'
      ]),
      open() {
        this.dialogVisible = true
      },
      close() {
        this.dialogVisible = false
      },
      selectAll() {
        util.setPermissionGroupChecked(this.currentRole.permissionGroup, true)
      },
      unselectAll() {
        util.setPermissionGroupChecked(this.currentRole.permissionGroup, false)
      },
      /**
       * 权限分配提交
       */
      authSubmit() {
        this.submitAuthorization().then(result => {
          this.dialogVisible = false;
          this.$message.success({showClose: true, message: result.msg, duration: 4000})
        }).catch(error => this.$message.error({showClose: true, message: error, duration: 4000}))
      }
    },
    // created() {
    //   this.currentRole = this.roleDialog;
    // },
    // updated() {
    //   this.currentRole = this.roleDialog;
    // }
  }
</script>

<style scoped>
  .grant-box {
    padding-left: .8em;
  }
</style>
