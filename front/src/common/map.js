/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/6 16:09
 \* Description:  地图组件辅助js文件
 \*/

export default {
  /**
   * 初始化服务区的logo 标识
   * @param map
   * @param areas
   * @returns {{normal: Array, alarm: Array}}
   */
  initAreaLogo(map, areas) {
    let normalMarkers = [];
    let alarmMarkers = [];
    areas.forEach(function (area) {
      let marker = new BMap.Marker(new BMap.Point(area.log, area.lat));
      marker.setTitle(area.name);
      // 允许覆盖物在map.clearOverlays方法中被清除
      marker.enableMassClear();
      if (area.type === 'normal') {
        marker.setIcon(new BMap.Icon('../../static/icon/house_green.png', new BMap.Size(32, 32)));
        normalMarkers.push(marker);
      } else {
        marker.setIcon(new BMap.Icon('../../static/icon/house_red.png', new BMap.Size(32, 32)));
        alarmMarkers.push(marker);
      }
      map.addOverlay(marker);// 将标注添加到地图中
    });
    return {normal: normalMarkers, alarm: alarmMarkers};
  }
}
