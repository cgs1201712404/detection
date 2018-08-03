/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27 16:53
\* Description: 单点监测实时数据页面组件
\*/
<template>
  <el-row :gutter="20">
    <el-col :md="4" :xl="4">
      <search-bar>
      </search-bar>
    </el-col>
    <el-col :md="20" :xl="20">
      <el-row>
        <div><span>监测点：<b>{{serviceArea.name}}</b></span><span
          style="margin-left: 2em"> 详细地址：{{serviceArea.district.detail}}</span></div>
      </el-row>
      <el-row class="tab-row">
        <template>
          <el-tabs v-model="activeTab" type="card">
            <el-tab-pane label="污水类" name="sewage">
              <sewage-tab>
              </sewage-tab>
            </el-tab-pane>
            <el-tab-pane label="大气类" name="wasteGas">
              大气类
            </el-tab-pane>
            <el-tab-pane label="噪声类" name="noise">
              噪声类
            </el-tab-pane>
            <el-tab-pane label="固废类" name="solidWaste">
              固废类
            </el-tab-pane>
          </el-tabs>
        </template>
      </el-row>
    </el-col>
  </el-row>
</template>

<script>
  import SearchBar from "../SearchBar";
  import SewageTab from "../SewageTab";

  export default {
    name: "SinglePoint",
    components: {SewageTab, SearchBar},
    data: function () {
      return {
        activeTab: 'sewage'
      };
    },
    computed: {
      serviceArea() {
        return this.$store.state.serviceArea.area;
      }
    }
  }
</script>

<style scoped>
  .tab-row {
    margin-top: 2em;
  }
</style>
