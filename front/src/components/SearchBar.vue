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
          v-model="searchInput">
        </el-input>
        <el-tree
          @node-click="nodeClicked"
          :data="serviceAreas"
          :filter-node-method="filterNode"
          :props="{
          children: 'children',
          label: 'label'
        }" ref="tree">
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
        searchInput: ''
      };
    },
    mounted() {
      this.getServiceAreas();
    },
    watch: {
      searchInput(val) {
        this.$refs.tree.filter(val);
      }
    },
    methods: {
      nodeClicked(nodeData, node, component) {
        if (node.isLeaf) {
          let area = this.getAreaByName(nodeData.label)
          this.$emit('findArea', area);
        }
      },
      getServiceAreas() {
        let params = {};
        this.$store.dispatch('getTreeList', params)
      },
      /**
       * 搜索框回调函数
       * @param value
       * @param data
       * @return {boolean}
       */
      filterNode(value, data) {
        if (typeof data.label !== 'undefined') {
          if (!value) return true;
          return data.id.indexOf(value) !== -1;
        }
        return false;
      },
      getAreaByName(name) {
        // 临时测试做法
        let params = {};
        this.$store.dispatch('getTreeList', params);
        return this.$store.state.serviceArea.areaList.find(function (area) {
          return area.name === name;
        })
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
