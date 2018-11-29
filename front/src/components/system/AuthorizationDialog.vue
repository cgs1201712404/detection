/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* @time: 2018/11/27 11:42
\* Description:
\*/
<template id="authorization-dialog">
  <el-dialog :visible.sync="dialogVisible" title="权限分配">
    <el-card shadow="never" v-for="menuPermission in currentRole.permissionGroup" :key="menuPermission.name">
      <div slot="header">
        <span>{{menuPermission.label}}</span>
        <el-checkbox v-model="menuPermission.checked"></el-checkbox>
      </div>
      <el-row>
        <el-checkbox class="grant-box" v-for="dataPermission in menuPermission.permission" :label="dataPermission.label"
                     :key="dataPermission.value" v-model="dataPermission.checked">
        </el-checkbox>
      </el-row>
    </el-card>
    <span slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "AuthorizationDialog",
    computed: {
      ...mapGetters([
        'roles',
        'roleDialog',
        'wholePermissions'
      ]),
      // state roleDialog的临时变量
      // currentRole: this.roleDialog
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
        'initWholePermissions'
      ]),
      open() {
        this.dialogVisible = true
      },
      close() {
        this.dialogVisible = false
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
