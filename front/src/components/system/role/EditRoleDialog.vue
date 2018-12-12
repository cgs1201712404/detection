/**
\* Created with WEBSTORM.
\* User: 彭诗杰
\* Date: 2018/12/2
\* Time: 17:18
\* Description: 编辑角色对话框组件
\*/
<template id="edit-role-dialog">
  <el-dialog :visible.sync="dialogVisible" title="编辑角色">
    <el-card shadow="never">
      <el-row>
        <el-form ref="form" v-model="role" label-width="6em" label-position="'left'">
          <el-form-item label="角色名称：">
            <el-input v-model="role.name"></el-input>
          </el-form-item>
          <el-form-item label="备注：">
            <el-input v-model="role.note"></el-input>
          </el-form-item>
        </el-form>
      </el-row>
    </el-card>
    <span slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="submit">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';
  import util from '../../../common/util';
  import role from "../../../store/modules/role";

  export default {
    name: "EditRoleDialog",
    computed: {
      ...mapGetters([
        'roleDialog'
      ]),
    },
    data() {
      return {
        dialogVisible: false,
        role: {
          roleName: '',
          note: ''
        }
      }
    },
    methods: {
      ...mapActions([
        'updateRole',
      ]),
      open() {
        this.dialogVisible = true;
        this.role = util.copyObject(this.roleDialog);
      },
      submit() {
        this.updateRole(this.role).then(result => {
          this.dialogVisible = false;
          this.$message.success({showClose: true, message: result.msg, duration: 4000})
        }).catch(error => this.$message.error({showClose: true, message: error, duration: 4000}))
      }
    }
  }
</script>

<style scoped lang="scss">

</style>
