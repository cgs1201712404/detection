/**
\* Created with IntelliJ IDEA.
\* User: 彭诗杰
\* Date: 2018/7/27
\* Time: 8:52
\* Description: 智能检测主页组件
\*/
<template>
  <el-container>
    <el-header height="100px" class="header">
      <el-row class="topbar-wrap">
        <el-col :span="2" class="topbar-logo">
          <a href="/"><img src=""></a>
        </el-col>
        <el-col :span="4" class="topbar-title">
          <span style="font-size: 25px;color: #fff;">智能环保监控管理系统</span>
        </el-col>
      </el-row>
    </el-header>

    <el-container>
      <el-aside class="aside">
        <el-row class="nav-area">
          <!--导航菜单-->
          <el-menu router unique-opened>
            <template v-for="(item,index) in $router.options.routes" v-if="item.menuShow">
              <el-submenu v-if="!item.leaf" :index="index+''">
                <template slot="title"><i :class="item.iconCls"></i><span slot="title">&nbsp;{{item.label}}</span>
                </template>
                <el-menu-item v-for="term in item.children" :key="term.path" :index="term.path" v-if="term.menuShow"
                              :class="$route.path==term.path?'is-active':''">
                  <i :class="term.iconCls"></i><span slot="title">&nbsp;{{term.label}}</span>
                </el-menu-item>
              </el-submenu>
              <el-menu-item v-else-if="item.leaf&&item.children&&item.children.length" :index="item.children[0].path"
                            :class="$route.path==item.children[0].path?'is-active':''">
                <i :class="item.iconCls"></i><span slot="title">&nbsp;{{item.children[0].label}}</span>
              </el-menu-item>
            </template>
          </el-menu>
        </el-row>
      </el-aside>
      <el-main>
        <section class="content-container">
          <el-col :span="24">
            <router-view></router-view>
          </el-col>
        </section>
      </el-main>
    </el-container>
  </el-container>
</template>


<script>
  import {mapActions, mapGetters} from 'vuex';
  import authority from '../common/authority'

  export default {
    name: 'Home',
    computed: {
      ...mapGetters([
        'currentUser'
      ])
    },
    data() {
      return {
        currentNavIndex: '1'
      }
    },
    methods: {
      ...mapActions([
        'mockPermissionList',
      ]),
    },
    created() {
      /**
       *  1.通过后端获取当前用户权限列表数据
       *  2.根据权限列表数据渲染侧边栏菜单
       *  将路由列表中元素的menuShow属性设置为false，即为不显示
       */
      this.mockPermissionList();
      // 实际情况可能存在异步调用
      authority.renderHomeMenu(this);
      authority.navHook(this);
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
  .header {
    background: #00bfff;
    padding: 0;

    .topbar-wrap {
      height: 100%;
    }

    .topbar-logo {
      position: relative;
      top: 50%;
      transform: translateY(-50%);
    }

    .topbar-title {
      position: relative;
      top: 50%;
      transform: translateY(-50%);
    }

    .topbar-dropdown {
      position: relative;
      top: 50%;
      transform: translateY(-50%);

      .header-dropdown-menu {
        margin-left: 30px;
      }
    }
  }

  .aside {
    border-right: 1px gray solid;
    height: 800px;

    .user-area {
      background-color: gray;
      height: 100px;
    }
    .nav-area {
      text-align: center;
      margin-top: 3em;
    }
  }
</style>
