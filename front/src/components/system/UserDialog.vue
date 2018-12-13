/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* @date: 2018/12/13
\* @time: 15:13
\* Description: 新增/编辑用户信息对话框
\*/
<template id="user-dialog">
  <el-dialog :visible.sync="dialogVisible" title="添加用户">
    <el-card shadow="never">
      <el-row>
        <el-form ref="userForm" :model="userForm" label-width="6em" label-position="'left'">
          <el-row>
            <el-col>
              <el-form-item prop="userName" label="用户名："
                            :rules="{required: true, message: '用户名不能为空', trigger: 'blur'}">
                <el-input v-model="userForm.userName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="password" label="密码："
                            :rules="{required: true, message: '密码不能为空', trigger: 'blur'}">
                <el-input v-model="userForm.password"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="name" label="姓名："
                            :rules="{required: true, message: '姓名不能为空', trigger: 'blur'}">
                <el-input v-model="userForm.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="性别：">
                <el-input v-model="userForm.gender"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="手机：">
                <el-input v-model="userForm.cellPhone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="部门：">
                <el-input v-model="userForm.department"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="职务：">
                <el-input v-model="userForm.position"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <el-row v-loading="loading" element-loading-text="正在加载">
          <el-button type="text">分配角色</el-button>
          <el-row style="margin-top: 2em">
            <el-radio-group v-model="userForm.roleVo.id">
              <el-radio v-for="idName in idNames" :key="idName.id" :label="idName.id" border>{{idName.name}}</el-radio>
            </el-radio-group>
          </el-row>
        </el-row>
      </el-row>
    </el-card>
    <span slot="footer">
    <el-button @click="cancel('userForm')">取 消</el-button>
    <el-button type="primary" @click="submitUser('userForm')">确 定</el-button>
  </span>
  </el-dialog>
</template>
<script>
  import {mapActions, mapGetters} from 'vuex';
  import util from '../../common/util'

  export default {
    name: "UserDialog",
    props: ['contextOp'],
    computed: {
      ...mapGetters([
        'idNames'
      ])
    },
    data() {
      return {
        loading: false,
        dialogVisible: false,
        userForm: {
          userName: '',
          password: '',
          name: '',
          gender: '',
          cellPhone: '',
          department: '',
          position: '',
          roleVo: {
            id: ''
          }
        }
      }
    },
    methods: {
      ...mapActions([
        'getAllRoles',
        'addUserAct'
      ]),
      cancel(userForm) {
        this.$refs[userForm].resetFields();
        this.dialogVisible = false;
      },
      submitUser(userForm) {

        // 表单验证
        this.$refs[userForm].validate((valid) => {
          if (valid) {
            console.log(this.userForm)
            this.addUserAct(this.userForm).then(result => {
              this.dialogVisible = false;
              this.$message({type: 'success', message: result.msg});
            }).catch(error => {
              this.$message({type: 'error', message: error.toString()});
            })
          } else {
            return false;
          }
        });
      },
      open(user) {
        this.dialogVisible = true;
        if (user) {
          this.userForm = util.copyObject(user);
          this.setRoleId(this.idNames[0].id);
        }
      },
      setRoleId(roleId) {
        this.userForm.roleVo.id = roleId;
      },
      initComp() {
        this.loading = true;
        this.getAllRoles({}).then(() => {
          if (this.idNames && this.idNames.length > 0) {
            this.setRoleId(this.idNames[0].id);
          }
          this.loading = false;
        }).catch(error => {
          this.loading = false;
          this.$message({type: 'error', message: error.toString()});
        })
      }
    },
    mounted() {
      this.initComp()
    }
  }
</script>

<style scoped>

</style>
