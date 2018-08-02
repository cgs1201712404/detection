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
  </div>
</template>

<script>
  export default {
    name: "Map",
    data() {
      return {
        loading: false
      }
    },
    methods: {
      initMap() {
        let map = new BMap.Map('map');
        // map.centerAndZoom('武汉', 12);
        map.centerAndZoom(new BMap.Point(114.2929, 30.5905), 12);
        map.enableScrollWheelZoom();
        // that.createFloatDiv(map);
        // mapUtil.createLeftButtonGroup(map, this);
        // if (currentCity) {
        //   mapUtil.drawBoundary(currentCity, map);
        // }
        // that.heatmapOverlay = that.initHeatMap(map, that.siteData);
        // that.loadSiteMarkersClusterer(map);
        // mapUtil.createRichMarker(map, that.siteData);
        // mapUtil.createFloatDiv(map);
        // map.setMapStyle({style:'googlelite'});
        return map;
      },
    },
    mounted() {
      this.initMap();
    }
  }
</script>

<style scoped>
  #allMap {
    height: 800px;
  }
</style>
