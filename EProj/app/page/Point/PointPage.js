import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    Platform,
    TouchableOpacity
} from 'react-native';

import Echarts from 'native-echarts'
var Dimensions = require('Dimensions');
const {width} = Dimensions.get('window');
import IMNavBar from '../../common/IMNavBar';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';
export default class PointPage extends Component {
    static navigationOptions = ({navigation}) => ({
        header: null
    });

    constructor(props) {
        super(props);
        this.state = {
            PH: [2, 4, 7, 2, 2, 7, 13, 16],
            COD: [6, 9, 9, 2, 8, 7, 17, 18],


        }
    }

    render() {
        const option = {
            //点击某一个点的数据的时候，显示出悬浮窗
            tooltip: {
                trigger: 'axis'
            },
            //可以手动选择现实几个图标
            legend: {
                data: ['PH', 'COD']
            },
            //各种表格
            toolbox: {
                //改变icon的布局朝向
                //orient: 'vertical',
                show: true,
                showTitle: true,
                feature: {
                    //show是否显示表格，readOnly是否只读
                    dataView: {show: true, readOnly: false},
                    magicType: {
                        //折线图  柱形图    总数统计 分开平铺
                        type: ['line', 'bar', 'stack', 'tiled'],
                    },
                }
            },
            xAxis: [
                {
                    //就是一月份这个显示为一个线段，而不是数轴那种一个点点
                    boundaryGap: true,
                    type: 'category',
                    name: '时间',
                    data: ['8:00', '10:00', '12:00', '14:00', '16:00', '18:00', '20:00', '22:00'],
                    axisLine: {show: false},     //坐标轴
                    axisTick: [{    //坐标轴小标记
                        show: false
                    }],
                    axisLabel: {
                        textStyle: {
                            fontSize: '10'
                        }
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: 'PH值',
                    axisLine: {show: false},
                    axisTick: [{    //坐标轴小标记
                        show: false
                    }],
                }
            ],
            //图形的颜色组
            color: ['rgb(249,159,94)', 'rgb(67,205,126)', 'rgb(160,241,244)', 'rgb(168,47,47)'],
            //需要显示的图形名称，类型，以及数据设置
            series: [
                {
                    name: 'PH',
                    //默认显
                    type: 'line',
                    data: this.state.PH
                },
                {
                    name: 'COD',
                    type: 'line',
                    data: this.state.COD
                }
            ]
        };
        return (
            <View style={styles.container}>
                <IMNavBar
                    leftItem={()=>this.renderRightItem()}
                    titleItem={() => this.renderTitleItem()}
                    rightItem={()=> this.renderRightItem()}
                />
                <View style={styles.container}>

                    <Echarts option={option} height={300} width={width}/>
                </View>
            </View>
        );
    }

    componentWillMount() {
        console.disableYellowBox = true;  //关闭警告提示

    }

    // 返回中间按钮
    renderTitleItem() {
        return (
                <Text style={styles.titleContent}>数据</Text>
        );
    }
    renderRightItem(){
        return(
            <Icon name={'calendar'}
                  size={25}
                  color={'gray'}
            />
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,

    },
    titleContent: {
        color: '#FFF',
        fontSize: 18,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});