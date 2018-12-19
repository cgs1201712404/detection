import React, { Component } from 'react'
import {
    Image,
    StyleSheet,
    TouchableOpacity,
    View ,
    Text,
    StatusBar,
    Alert
} from 'react-native'
import { MapView, Location } from 'react-native-baidumap-sdk'
import icon from './ic_my_location.png'
import { Initializer } from 'react-native-baidumap-sdk'
import IMNavBar from '../../common/IMNavBar'


Initializer.init('m9PdoLcLriSn5YlxOfAMC27xBdt17TO2');

const style = StyleSheet.create({
    textStyle:{
        fontSize:15
    },
    searchContent: {
        color: '#FFF',
        fontSize: 16,
    },
    textTab:{
        flexDirection: 'row',
        height:50,
        backgroundColor:'orange',
        marginTop:0
    },
  button: {
    position: 'absolute', //绝对定位
    right: 16,
    bottom: 16,
    backgroundColor: '#fff',
    borderRadius: 40,
    elevation: 2,
  },
  icon: {
    width: 24,
    height: 24,
    margin: 12,
    tintColor: '#616161',
  },
});

export default class MapViewExample extends Component {
    static navigationOptions = ({ navigation }) => ({
        header:null
    });

  state = {};
    onStatusChange = status => {
        this.status = status;
        this.cluster.update(status)
    };

    onPress = cluster => {
        this.mapView.setStatus({
            center: cluster.coordinate,
            zoomLevel: this.status.zoomLevel + 1,
        }, 500)
    };

    markers = Array(100).fill(0).map((_, i) => ({
        coordinate: {
            latitude: 30.5 + Math.random(),
            longitude: 114 + Math.random(),
        },
        extra: { key: `Marker${i}`+'服务区'},
    }));

    renderMarker = item => (
        <MapView.Marker
            selected
            title={item.extra.key}
            coordinate={item.coordinate}
            onPress={() => Alert.alert('服务区')}
            onCalloutPress={() => this.goPoint()}


        />
    );
    goPoint =() =>{
        this.props.navigation.navigate('Point')
    };
  async componentDidMount() {
    await Location.init();
    Location.setOptions({ gps: true });
    this.listener = Location.addLocationListener(location => {
      this.setState({ location });
        console.log(location)
    });
    Location.start()

  }
    // 返回中间按钮
    renderTitleItem() {
        return(
            <Text style={style.searchContent}>地图监测</Text>
        );
    }
  componentWillUnmount() {
    Location.stop();
    this.listener.remove()
  }

  location = () => this.mapView.setStatus({ center: this.state.location }, 1000)

  render() {
      const props = {
          ref: ref => this.mapView = ref,
          style: StyleSheet.absoluteFill,
          onStatusChange: this.onStatusChange,
      };

      return (
      <View style={StyleSheet.absoluteFill}>
          <StatusBar
              animated={true} //指定状态栏的变化是否应以动画形式呈现。目前支持这几种样式：backgroundColor, barStyle和hidden
              hidden={false}  //是否隐藏状态栏。
              backgroundColor={'rgba(0,0,0,0)'} //状态栏的背景色
              translucent={true}//指定状态栏是否透明。设置为true时，应用会在状态栏之下绘制（即所谓“沉浸式”——被状态栏遮住一部分）。常和带有半透明背景色的状态栏搭配使用。
              barStyle={'light-content'} // enum('default', 'light-content', 'dark-content')
          >
          </StatusBar>
          <MapView {...props}
                   zoomLevel={12}
                   center={{
                       latitude: 30.516932,
                       longitude: 114.379333,
                   }}
                   location={this.state.location}
                   locationEnabled
                   zoomControlsDisabled>
              <MapView.Cluster
                  onPress={this.onPress}
                  ref={ref => this.cluster = ref}
                  markers={this.markers}
                  renderMarker={this.renderMarker}
              />
          </MapView>
          <IMNavBar
              titleItem={() => this.renderTitleItem()}
          />
        <View style={style.button}>
          <TouchableOpacity onPress={this.location}>
            <Image style={style.icon} source={icon} />
          </TouchableOpacity>
        </View>

      </View>
    )
  }
}
