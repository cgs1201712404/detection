/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/31 10:22
\* Description: 通过地区查询服务区栏
\*/
<template id="search-bar">
  <div>
    <el-card shadow="never" style="width: 100%">
      <div slot="header">
        <span>选择位置</span>
      </div>
      <div>
        <el-input
          placeholder="按服务区名称查询"
          v-model="input">
        </el-input>
        <el-tree
          :data="serviceAreas"
          :props="{
          children: 'children',
          label: 'label'
        }"
          default-expand-all>
        </el-tree>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "searchBar",
    data: function () {
      return {
        input: ''
      };
    },
    mounted() {
      this.getServiceAreas();
    },
    methods: {
      getServiceAreas() {
        let params = {};
        this.$store.dispatch('getTreeList', params)
      }
    },
    computed: {
      serviceAreas() {
        return this.$store.state.serviceArea.areaTreeList;
      }
    }
  }
</script>

<style scoped>

</style>
