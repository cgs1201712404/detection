/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date:  2018/7/27
\* Description:
\*/
<template>
  <div v-loading="loading" element-loading-text="正在加载地图">
    <div id="allMap" style=" width: 100%">
      <el-col id="map"
              style="height:100%;width: 100%">
      </el-col>
    </div>
    <div class="search-div">
      <search-bar @findArea="moveToArea">
      </search-bar>
    </div>
    <div class="area-logo-div">
      <el-button type="text" @click="showNormal"><i class="icon iconfont icon-house128-green"></i>数据正常</el-button>
      <el-button type="text" @click="showAlarm"><i class="icon iconfont icon-house128-red"></i>数据异常</el-button>
    </div>
    <!-- Gauge dialog -->
    <el-dialog
      :title="currentArea.name"
      :visible.sync="dialogVisible"
      width="60%">
      <el-tabs v-model="activeTab" type="card" @tab-click="dialogTabClicked">
        <el-tab-pane label="污水类" name="sewage">
          <el-col :md="8" :xl="8">
            <gauge :value="sewageLatest.pH" label="PH"></gauge>
          </el-col>
          <el-col :md="8" :xl="8">
            <gauge :value="sewageLatest.cod" label="cod"></gauge>
          </el-col>
          <el-col :md="8" :xl="8">
            <gauge :value="sewageLatest.nH3N" label="nH3N"></gauge>
          </el-col>
          <el-col :md="8" :xl="8">
            <gauge :value="sewageLatest.tP" label="tP"></gauge>
          </el-col>
          <el-col :md="8" :xl="8">
            <gauge :value="sewageLatest.oil" label="oil"></gauge>
          </el-col>
          <el-col :md="8" :xl="8">
            <gauge :value="sewageLatest.flow" label="flow"></gauge>
          </el-col>
        </el-tab-pane>
        <el-tab-pane label="大气类" name="wasteGas">
        </el-tab-pane>
        <el-tab-pane label="噪声类" name="noise">
        </el-tab-pane>
        <el-tab-pane label="固废类" name="solid">
        </el-tab-pane>
      </el-tabs>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import SearchBar from "../SearchBar";
  import mapUtil from "../../common/map";
  import Gauge from "./Gauge";

  export default {
    name: "Map",
    components: {Gauge, SearchBar},
    data() {
      return {
        dialogVisible: false,
        loading: false,
        activeTab: 'sewage',
        map: null,
        // 地图上logo标识层形式为{normal: Array, alarm: Array}
        markerLayers: {},
      }
    },
    methods: {
      initMap() {
        let map = new BMap.Map('map');
        // map.centerAndZoom('武汉', 12);
        map.centerAndZoom(new BMap.Point(114.2929, 30.5905), 12);
        map.enableScrollWheelZoom();
        // 在地图中加载服务区marker
        this.markerLayers = mapUtil.initAreaLogo(this, map, this.serviceAreas);
        return map;
      },
      moveToArea(area) {
        if (this.map && area) {
          this.map.panTo(new BMap.Point(area.log, area.lat))
        }
      },
      showNormal() {
        let that = this;
        this.markerLayers.alarm.forEach(function (marker) {
          that.map.removeOverlay(marker);
        });
        this.markerLayers.normal.forEach(function (marker) {
          that.map.addOverlay(marker);
        });
      },
      showAlarm() {
        let that = this;
        this.markerLayers.normal.forEach(function (marker) {
          that.map.removeOverlay(marker);
        });
        this.markerLayers.alarm.forEach(function (marker) {
          that.map.addOverlay(marker);
        });
      },
      //  以下为state数据初始化函数
      getServiceAreas() {
        let params = {};
        this.$store.dispatch('getAreaList', params)
      },
      getSewageLatest() {
        let params = {};
        this.$store.dispatch('getSewageLatest', params)
      },
      setCurrentArea(area) {
        this.$store.dispatch('setArea', area)
      },
      //以下为事件回调函数
      dialogTabClicked() {

      }
    },
    computed: {
      serviceAreas() {
        return this.$store.state.serviceArea.areaList;
      },
      currentArea() {
        return this.$store.state.serviceArea.area;
      },
      sewageLatest() {
        return this.$store.state.sewage.latest;
      }
    },
    mounted() {
      this.getServiceAreas();
      this.getSewageLatest();
      this.map = this.initMap();
    }
  }
</script>

<style scoped lang="scss">
  #allMap {
    height: 800px;
  }

  .search-div {
    position: absolute;
    left: 25em;
    top: 10em;
    width: 18em;
    background: #FFFFFF;
    font-size: 0.9em;
    -moz-opacity: 0.8;
    opacity: 0.8;
  }

  .area-logo-div {
    position: absolute;
    right: 3em;
    bottom: 3em;
    background: #FFFFFF;
    border: 1px solid;
    border-radius: 10px;
    -moz-opacity: 0.8;
    opacity: 0.8;
  }
</style>
