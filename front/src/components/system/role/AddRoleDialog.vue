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
        <el-form ref="form" v-model="roleForm" label-width="6em" label-position="'left'">
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
            <!--<el-checkbox-group v-model="menuPermission.permission">-->
            <el-checkbox-button v-for="dataPermission in menuPermission.permission" :label="dataPermission.label"
                                :key="dataPermission.value" v-model="dataPermission.checked"></el-checkbox-button>
            <!--</el-checkbox-group>-->
          </el-col>
        </el-row>
      </el-row>
    </el-card>
    <span slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
  import CONSTANTS from '../../../common/constants'
  import util from "../../../common/util";

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
      open() {
        this.dialogVisible = true;
      },
      selectAll() {
        util.setPermissionGroupChecked(this.roleForm.permissionGroup, true)
      },
      unselectAll() {
        util.setPermissionGroupChecked(this.roleForm.permissionGroup, false)
      },

    }
  }
</script>

<style scoped lang="scss">

</style>
