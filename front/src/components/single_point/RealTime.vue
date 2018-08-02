/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 16:53
\* Description: 单点监测实时数据页面组件
\*/
<template>
  <el-container>
    <el-col :span="6">
      <search-bar>
      </search-bar>
    </el-col>
    <el-col :span="18">

    </el-col>
  </el-container>
</template>

<script>
  import SearchBar from "../SearchBar";

  export default {
    name: "SinglePoint",
    components: {SearchBar}
  }
</script>

<style scoped>

</style>
