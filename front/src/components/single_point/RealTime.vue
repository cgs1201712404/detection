import waste_gas from "../../store/modules/waste_gas";
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
          <el-tabs v-model="activeTab" type="card" @tab-click="tabClicked">
            <el-tab-pane label="污水类" name="sewage">
              <sewage-tab>
              </sewage-tab>
            </el-tab-pane>
            <el-tab-pane label="大气类" name="wasteGas">
              <waste-gas-tab ref="wasteGas">
              </waste-gas-tab>
            </el-tab-pane>
            <el-tab-pane label="噪声类" name="noise">
              <noise-tab ref="noise">
              </noise-tab>
            </el-tab-pane>
            <el-tab-pane label="固废类" name="solid">
              <solid-tab ref="solid">
              </solid-tab>
            </el-tab-pane>
          </el-tabs>
        </template>
      </el-row>
    </el-col>
  </el-row>
</template>

<script>
  import SearchBar from "../SearchBar";
  import SewageTab from "./real_time/SewageTab";
  import WasteGasTab from "./real_time/WasteGasTab";
  import NoiseTab from "./real_time/NoiseTab";
  import SolidTab from "./real_time/SolidTab";

  export default {
    name: "SinglePoint",
    components: {SolidTab, NoiseTab, WasteGasTab, SewageTab, SearchBar},
    data: function () {
      return {
        activeTab: 'sewage'
      };
    },
    methods: {
      tabClicked(tab) {
        if (tab && tab.name === 'wasteGas') {
          this.$refs.wasteGas.refreshGasChart();
        } else if (tab && tab.name === 'noise') {
          this.$refs.noise.refreshNoiseChart();
        } else if (tab && tab.name === 'solid') {
          this.$refs.solid.refreshSolidChart();
        }
      }
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
