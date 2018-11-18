/**
 \* Created with IntelliJ IDEA.
 \* @author: 彭诗杰
 \* @time: 2018/11/15 10:53
 \* Description: 前端权限控制组件，权限逻辑封装在此JS文件中
 \*/

export default {
  /**
   * 根据权限渲染home侧边菜单
   * @param context
   */
  renderHomeMenu(context) {
    let routes = context.$router.options.routes;
    if (context.currentUser && context.currentUser.privilegeGroup) {
      for (let firstRoute of routes) {
        for (let secondRoute of firstRoute.children) {
          for (let privilege of context.currentUser.privilegeGroup) {
            if (secondRoute.name === privilege.name) {
              secondRoute.menuShow = true;
              firstRoute.menuShow = true;
            }
          }
        }
      }
    }
  },
  /**
   * 权限导航钩子
   * @param home home组件
   */
  navHook(home) {
    home.$router.beforeEach((to, from, next) => {
      setDataPermission(home.$router, home.currentUser.privilegeGroup);
      let isPermission = false;
      home.currentUser.privilegeGroup.forEach((permission) => {
        if (permission.path === to.fullPath) {
          isPermission = true
        }
      });
      if (!isPermission) {
        /**
         * 需要闵一设计用户没有访问权限的界面
         */
        next({path: "/error/401", replace: true})
      } else {
        next();
      }
    })
  }
}

/**
 * 设置数据级权限，将权限permission数据插入到路由表中
 * @param router 路由
 * @param permissionGroup 权限组数据
 */
function setDataPermission(router, permissionGroup) {
  for (let element of permissionGroup) {
    let routeItem = router.match(element.path);
    if (routeItem) {
      // 将返回的所有数据都存到路由的meta信息中
      routeItem.meta.permission = element.permission;
    }
  }
}




