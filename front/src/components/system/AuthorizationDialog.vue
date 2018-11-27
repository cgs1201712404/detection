/**
\* Created with IntelliJ IDEA.
\* @author: 彭诗杰
\* @time: 2018/11/27 11:42
\* Description:
\*/
<template id="authorization-dialog">
  <el-dialog>
    <el-card shadow="never" v-for="menuPermission in currentRole.permissionGroup" :key="menuPermission.name">
      <div slot="header">
        <span>{{menuPermission.name}}</span>
        <el-checkbox style="float: right; padding: 3px 0"></el-checkbox>
      </div>
      <el-row>
        <el-checkbox-group>
          <el-checkbox v-for="dataPermission in menuPermission" :label="dataPermission.name"
                       :key="dataPermission.name">{{dataPermission.name}}</el-checkbox>
        </el-checkbox-group>
      </el-row>
    </el-card>
  </el-dialog>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "AuthorizationDialog",
    computed: {
      ...mapGetters([
        'roles',
        'roleDialog'
      ]),
    },
    data() {
      return {
        currentRole: this.roleDialog
      }
    },
    methods: {
      ...mapActions([
        'mockRoles'
      ]),
    }
  }
</script>

<style scoped>

</style>
