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
      <el-button type="text"><i class="icon iconfont icon-house128-green"></i>数据正常</el-button>
      <el-button type="text"><i class="icon iconfont icon-house128-red"></i>数据异常</el-button>
    </div>
  </div>
</template>

<script>
  import SearchBar from "./SearchBar";
  import mapUtil from "../common/map";

  export default {
    name: "Map",
    components: {SearchBar},
    data() {
      return {
        loading: false,
        map: null,
        markerLayers: [],
      }
    },
    methods: {
      initMap() {
        let map = new BMap.Map('map');
        // map.centerAndZoom('武汉', 12);
        map.centerAndZoom(new BMap.Point(114.2929, 30.5905), 12);
        map.enableScrollWheelZoom();
        // 在地图中加载服务区marker
        this.markerLayers = mapUtil.loadAreaLogo(map, this.serviceAreas);
        return map;
      },
      moveToArea(area) {
        if (this.map && area) {
          this.map.panTo(new BMap.Point(area.log, area.lat))
        }
      },
      getServiceAreas() {
        let params = {};
        this.$store.dispatch('getAreaList', params)
      },
    },
    computed: {
      serviceAreas() {
        return this.$store.state.serviceArea.areaList;
      }
    },
    mounted() {
      this.getServiceAreas();
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
