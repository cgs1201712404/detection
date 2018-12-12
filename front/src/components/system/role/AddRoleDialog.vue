/**
\* Created with WEBSTORM.
\* User: 彭诗杰
\* Date: 2018/12/1
\* Time: 0:46
\* Description: 添加角色对话框组件
\*/
<template id="add-role-dialog">
  <el-dialog :visible.sync="dialogVisible" title="添加角色">
    <el-card shadow="never">
      <el-row>
        <el-form ref="addRoleForm" v-model="roleForm" label-width="6em" label-position="'left'">
          <el-form-item label="角色名称：">
            <el-input v-model="roleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="备注：">
            <el-input v-model="roleForm.note"></el-input>
          </el-form-item>
        </el-form>
        <el-row>
          <el-button type="text">分配权限</el-button>
          <el-button type="success" @click="selectAll">全选</el-button>
          <el-button type="warning" @click="unselectAll">全不选</el-button>
        </el-row>
        <el-row style="margin-top: 2em" v-for="menuPermission in roleForm.permissionGroup" :key="menuPermission.name">
          <el-col :span="6">
            <el-checkbox :label="menuPermission.label" v-model="menuPermission.checked" border></el-checkbox>
          </el-col>
          <el-col :span="18">
            <el-checkbox-button v-for="dataPermission in menuPermission.permission" :label="dataPermission.label"
                                :key="dataPermission.id" v-model="dataPermission.checked"></el-checkbox-button>
          </el-col>
        </el-row>
      </el-row>
    </el-card>
    <span slot="footer">
    <el-button @click="cancel('addRoleForm')">取 消</el-button>
    <el-button type="primary" @click="submitRole('addRoleForm')">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
  import CONSTANTS from '../../../common/constants'
  import util from "../../../common/util";
  import {mapActions} from 'vuex';

  export default {
    name: "AddRoleDialog",
    computed: {},
    data() {
      return {
        dialogVisible: false,
        roleForm: {
          name: '',
          note: '',
          permissionGroup: CONSTANTS.defaultPermissionGroup
        }
      }
    },
    methods: {
      ...mapActions([
        'addRoleAct',
      ]),
      open() {
        this.dialogVisible = true;
      },
      selectAll() {
        util.setPermissionGroupChecked(this.roleForm.permissionGroup, true)
      },
      unselectAll() {
        util.setPermissionGroupChecked(this.roleForm.permissionGroup, false)
      },
      submitRole(fromName) {
        this.addRoleAct(this.roleForm).then(result => {
          this.dialogVisible = false;
          this.$message({type: 'success', message: result.msg});
          this.resetForm(fromName)
        }).catch(error => {
          this.$message({type: 'error', message: error.toString()});
        })
      },
      cancel(formName) {
        this.dialogVisible = false;
        this.resetForm(formName)
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.roleForm.name = '';
        this.roleForm.note = ''
      }
    }
  }
</script>

<style scoped lang="scss">

</style>
