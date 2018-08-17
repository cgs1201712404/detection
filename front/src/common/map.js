/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/6 16:09
 \* Description:  地图组件辅助js文件
 \*/

export default {
  loadAreaLogo(map, areas) {
    let markers = [];
    areas.forEach(function (area) {
      let marker = new BMap.Marker(new BMap.Point(area.log, area.lat));
      marker.setTitle(area.name);
      if (area.type === 'normal') {
        marker.setIcon(new BMap.Icon('../../static/icon/house_green.png', new BMap.Size(32, 32)));
      } else {
        marker.setIcon(new BMap.Icon('../../static/icon/house_red.png', new BMap.Size(32, 32)));
      }
      map.addOverlay(marker);// 将标注添加到地图中
      markers.push(marker);

    });
    return markers;
  }
}
