/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date:  2018/7/27
\* Description: 地图展示组件
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
      :fullscreen="true"
      @open="gaugeDialogOpen">
      <div slot="title">
        <el-row>
          <el-col :offset="1" :md="3" :xl="3">
            <h4>{{currentArea.name}}</h4>
          </el-col>
          <el-col :md="20" :xl="20">
            <el-select v-model="sewageSystem.name">
              <el-option v-for="item in currentArea.systems" :key="item.systemCode" :value="item.name"
                         :label="item.name">
              </el-option>
            </el-select>
          </el-col>
        </el-row>
      </div>
      <el-tabs v-model="activeTab" type="card" @tab-click="dialogTabClicked">
        <el-tab-pane label="污水类" name="sewage">
          <el-col :md="8" :xl="8" v-for="factor in sewageSystem.factors" :key="factor.code">
            <gauge :value="factor.latest.value" :label="factor.name" ref="sewage"></gauge>
          </el-col>
        </el-tab-pane>
        <el-tab-pane label="大气类" name="wasteGas">
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.sD" label="二氧化硫" ref="gaugeSD"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.nOZ" label="二氧化氮" ref="gaugeNOZ"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.nO" label="一氧化氮" ref="gaugeNO"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.tCM" label="隧道一氧化碳" ref="gaugeTCM"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.tSP" label="TSP（总悬浮物）" ref="gaugeTSP"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.pM1" label="PM1" ref="gaugePM1"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.pM25" label="PM25" ref="gaugePM25"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.pM10" label="PM10" ref="gaugePM10"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.temperature" label="温度" ref="gaugeTemp"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.humidity" label="湿度" ref="gaugeHum"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.atmPress" label="大气压" ref="gaugeAtm"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.windSpeed" label="风速" ref="gaugeWind"></gauge>
          </el-col>
          <el-col :md="6" :xl="6">
            <gauge :value="gasLatest.rainfall" label="降雨量" ref="gaugeRain"></gauge>
          </el-col>
        </el-tab-pane>
        <el-tab-pane label="噪声类" name="noise">
          <el-col :md="12" :xl="12">
            <gauge :value="noiseLatest.intensity" label="噪声强度" ref="gaugeInte"></gauge>
          </el-col>
          <el-col :md="12" :xl="12">
            <gauge :value="noiseLatest.frequency" label="噪声频率" ref="gaugeFreq"></gauge>
          </el-col>
        </el-tab-pane>
        <el-tab-pane label="固废类" name="solid">
          <el-col :md="12" :xl="12">
            <gauge :value="solidLatest.capacity" label="垃圾压缩池池容" ref="gaugeCap"></gauge>
          </el-col>
        </el-tab-pane>
      </el-tabs>
      <span slot="footer" class="dialog-footer">
    <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
    <el-button type="primary" @click="dialogVisible = false">关 闭</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import SearchBar from "../SearchBar";
  import mapUtil from "../../common/map";
  import util from '../../common/util';
  import Gauge from "./Gauge";
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "Map",
    components: {Gauge, SearchBar},
    computed: {
      ...mapGetters([
        'area',
      ]),
      serviceAreas() {
        return this.$store.state.serviceArea.areaList;
      },
      // currentArea() {
      //   return this.$store.state.serviceArea.area;
      // },
      sewageLatest() {
        return this.$store.state.sewage.latest;
      },
      gasLatest() {
        return this.$store.state.wasteGas.latest;
      },
      noiseLatest() {
        return this.$store.state.noise.latest;
      },
      solidLatest() {
        return this.$store.state.solid.latest;
      }
    },
    data() {
      return {
        currentArea: {},
        sewageSystem: {},
        dialogVisible: false,
        loading: false,
        activeTab: 'sewage',
        map: null,
        // 地图上logo标识层形式为{normal: Array, alarm: Array}
        markerLayers: {},
      }
    },
    methods: {
      ...mapActions([
        'initAreaListAndTreeAct',
        'getSewageSystemsAct',
        'getSystemFactorsAct',
        'getFactorLatestValueAct'
      ]),
      async fillSystemLatestValue(area, system) {
        let factors = [];
        try {
          let factPageVo = await this.getSystemFactorsAct({sewageId: area.sewageId, systemCode: system.systemCode});
          for (let factor of factPageVo.factorVos) {
            factor.latest = await this.getFactorLatestValueAct({
              sewageId: area.sewageId, systemCode: system.systemCode,
              factorCode: factor.code
            });
            factors.push(factor)
          }
        } catch (err) {
          return err
        }
        return factors;
      },
      /**
       * 对话框open回调
       */
      gaugeDialogOpen() {
        if (this.$refs.sewage) {
          this.$refs.sewage.forEach(item => {
            item.refreshGauge();
          })
        }
      },
      initPage() {
        this.initAreaListAndTreeAct().then(() => {
          this.setArea(this.area);
        }).catch(error => {
          console.error(error);
          this.$message({type: 'error', message: error.toString()});
        })
      },
      initMap() {
        let map = new BMap.Map('map');
        map.centerAndZoom(new BMap.Point(114.2929, 30.5905), 12);
        map.enableScrollWheelZoom();
        // 在地图中加载服务区marker
        this.markerLayers = mapUtil.initAreaLogo(this, map, this.serviceAreas);
        return map;
      },
      moveToArea(area) {
        if (this.map && area) {
          this.map.panTo(new BMap.Point(area.lon, area.lat))
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
      setArea(area) {
        this.currentArea = util.copyObject(this.area);
        this.getSewageSystemsAct(this.currentArea).then(systems => {
          this.currentArea.systems = systems;
          this.setMapSystem(systems[0]);
        });
        this.getSewageLatest();
        this.getGasLatest();
        this.getNoiseLatest();
        this.getSolidLatest();
        this.$store.dispatch('setCurrentArea', area)
      },

      setMapSystem(system) {
        this.sewageSystem = system;
        this.map = this.initMap();
        this.fillSystemLatestValue(this.currentArea, this.sewageSystem).then(factors => {
          // 设置当前系统因子和因子的最新值
          this.sewageSystem.factors = factors;
          // 根据系统因子设置计量器的参数值，在加载过程中设置
          this.loadGauge()
        }).catch(error => {
          console.error(error)
        })
      },
      /**
       * 加载计量器仪表盘
       */
      loadGauge() {
//        console.log(this.$refs);
      },
      getSewageLatest() {
        let params = {};
        this.$store.dispatch('getSewageLatest', params)
      },
      getGasLatest() {
        let params = {};
        this.$store.dispatch('getGasLatest', params)
      },
      getNoiseLatest() {
        let params = {};
        this.$store.dispatch('getNoiseLatest', params)
      },
      getSolidLatest() {
        let params = {};
        this.$store.dispatch('getSolidLatest', params)
      },
      //以下为事件回调函数
      dialogTabClicked(tab) {
        if (tab && tab.name === 'wasteGas') {
          this.$refs.gaugeSD.refreshGauge();
          this.$refs.gaugeNOZ.refreshGauge();
          this.$refs.gaugeNO.refreshGauge();
          this.$refs.gaugeTCM.refreshGauge();
          this.$refs.gaugeTSP.refreshGauge();
          this.$refs.gaugePM1.refreshGauge();
          this.$refs.gaugePM25.refreshGauge();
          this.$refs.gaugePM10.refreshGauge();
          this.$refs.gaugeTemp.refreshGauge();
          this.$refs.gaugeHum.refreshGauge();
          this.$refs.gaugeAtm.refreshGauge();
          this.$refs.gaugeWind.refreshGauge();
          this.$refs.gaugeRain.refreshGauge();
        } else if (tab && tab.name === 'noise') {
          this.$refs.gaugeInte.refreshGauge();
          this.$refs.gaugeFreq.refreshGauge();
        } else if (tab && tab.name === 'solid') {
          this.$refs.gaugeCap.refreshGauge();
        }
      }
    },
    mounted() {
      this.initPage();
    }
  }
</script>

<style scoped lang="scss">
  #allMap {
    height: 800px;
  }

  .search-div {
    position: absolute;
    left: 20em;
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
