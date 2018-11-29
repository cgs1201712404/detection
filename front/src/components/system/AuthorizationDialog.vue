/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* @time: 2018/11/27 11:42
\* Description:
\*/
<template id="authorization-dialog">
  <el-dialog :visible.sync="dialogVisible" title="权限分配">
    <el-card shadow="never" v-for="menuPermission in wholePermissions" :key="menuPermission.name">
      <div slot="header">
        <span>{{menuPermission.label}}</span>
        <el-checkbox style=" padding: 3px 0"></el-checkbox>
      </div>
      <el-row>
        <el-checkbox-group>
          <el-checkbox v-for="dataPermission in menuPermission.permission" :label="dataPermission.label"
                       :key="dataPermission.value">{{dataPermission.label}}
          </el-checkbox>
        </el-checkbox-group>
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
    },
    data() {
      return {
        dialogVisible: false,
        // state roleDialog的临时变量
        currentRole: this.roleDialog
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
    created() {
      this.initWholePermissions();
      this.currentRole = this.roleDialog;
    },
    updated() {
      this.currentRole = this.roleDialog;
    }
  }
</script>

<style scoped>

</style>
