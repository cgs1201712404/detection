import React,{ Component } from 'react';
import {
    Image,
    StyleSheet,
    Text,
} from 'react-native';
import { StackNavigator, TabNavigator, TabBarBottom ,SwitchNavigator} from 'react-navigation';
import Map from './page/Map/map-view'
import Mine from './page/Mine/ParallaxScrollViewDemo'
import Device from './page/Device/DevicePage'
import Point from './page/Point/PointPage'
import News from './page/Mine/NewsPage'
import FontAwesome from 'react-native-vector-icons/FontAwesome';
import Login from './page/Login/LoginView'
import Splash from './page/Login/SplashScreen'
import Dialog from './test/Per'

import {BackHandler, ToastAndroid} from "react-native";
export default class RootScene extends Component {

    componentWillMount() {
        BackHandler.addEventListener('hardwareBackPress', this.onBackAndroid);
    }

    componentWillUnmount() {
        BackHandler.removeEventListener('hardwareBackPress', this.onBackAndroid);
    }

    onBackAndroid = () => {
        if (this.lastBackPressed && this.lastBackPressed + 2000 >= Date.now()) {
            //最近2秒内按过back键，可以退出应用。
            BackHandler.exitApp();
            return false;
        }
        this.lastBackPressed = Date.now();
        ToastAndroid.show('再按一次退出应用', ToastAndroid.SHORT);
        // return true;
        return true;
    };
    render() {
        return (
            <Navigator

                onNavigationStateChange={

                    (prevState, currentState) => {
                        // 只要切换tab,push,pop,这里一定走
                        console.log(prevState);
                        console.log(currentState);

                    }
                }
            />
        );
    }
}
const Tab = TabNavigator({
        Device: {
            screen: Device,
            navigationOptions:{
                tabBarLabel: '设备',
                tabBarIcon: ({ focused, tintColor }) => (
                    <FontAwesome
                        name={'home'}
                        size={20}
                        color={tintColor}
                    />
                )
            }
        },
        Map: {
            screen: Map,
            navigationOptions: ({ navigation }) => ({
                tabBarLabel: '地图',
                tabBarIcon: ({ focused, tintColor }) => (
                    <FontAwesome
                        name={'map-marker'}
                        size={20}
                        color={tintColor}
                    />
                )
            }),
        },
        Point: {
            screen: Dialog,
            navigationOptions: ({ navigation }) => ({
                tabBarLabel: '图表',
                tabBarIcon: ({ focused, tintColor }) => (
                    <FontAwesome
                        name={'star'}
                        size={20}
                        color={tintColor}
                    />
                )
            }),
        },
        Mine: {
            screen: Mine,
            navigationOptions: ({ navigation }) => ({
                tabBarLabel: '我的',
                tabBarIcon: ({ focused, tintColor }) => (
                    <FontAwesome
                        name={'user'}
                        size={20}
                        color={tintColor}
                    />
                )
            }),
        },

    },
    {
        tabBarComponent: TabBarBottom,
        tabBarPosition: 'bottom',
        swipeEnabled: false,
        animationEnabled: false,
        lazy: true,
        //返回按钮是否会导致tab切换到初始tab页？ 如果是，则设置为initialRoute，否则为none。 缺省为initialRoute。
        backBehavior: 'none',
        tabBarOptions: {
            //当前选中的tab bar的文本颜色和图标颜色
            activeTintColor: '#4BC1D2',
            //当前未选中的tab bar的文本颜色和图标颜色
            inactiveTintColor: '#000000',
            //是否显示tab bar的图标，默认是false
            showIcon: true,
            //showLabel - 是否显示tab bar的文本，默认是true
            showLabel: true,
            //是否将文本转换为大小，默认是true
            upperCaseLabel: false,
            //material design中的波纹颜色(仅支持Android >= 5.0)
            pressColor: '#788493',
            //按下tab bar时的不透明度(仅支持iOS和Android < 5.0).
            pressOpacity: 0.8,
            //tab bar的样式
            style: {
                backgroundColor: '#fff',
                paddingBottom: 1,
                borderTopWidth: 0.2,
                paddingTop: 1,
                borderTopColor: '#ccc',
            },
            //tab bar的文本样式
            labelStyle: {
                fontSize: 11,
                margin: 1
            },
            tabStyle: {
                height: 45
            },
            //tab 页指示符的样式 (tab页下面的一条线).
            indicatorStyle: {height: 0},
        },

    });
const Navigator = StackNavigator({
    welcome:{
        screen:Splash,
    },
    Login:{
        screen:Login,
    },
    Tab: {
        screen: Tab,
    },
    News:{
        screen:News,
    },

});

