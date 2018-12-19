import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    Platform,
    TouchableOpacity,
    Image,
    PixelRatio,
    ScrollView
} from 'react-native';
import Echarts from 'native-echarts'
var Dimensions = require('Dimensions');
import IMNavBar from '../../common/IMNavBar'

const {width} = Dimensions.get('window');

export default class GMChart extends Component{
    static navigationOptions = ({navigation}) => ({
        header: null
    });
    constructor(props){
        super(props);
        this.state ={
            PH:[5, 5, 5, 5, 5, 5, 5, 5],
            COD: [9, 9, 9, 9, 9, 7, 9, 9],
            AD:[12, 12, 12, 12, 12, 18, 12, 12],
            LIN:[3, 3, 3, 3, 3, 3,3,3],
            XF:[8, 8, 8, 8, 8, 8,8,8],
        }
    }
    // 返回左边按钮
    renderLeftItem() {
        return(
            <TouchableOpacity>
                <Image source={require('../../image/rili.png')} style={styles.navBarLeftItemStyle} />
            </TouchableOpacity>
        );
    }
    // 返回中间按钮
    renderTitleItem() {
        return(
            <Text style={styles.navBarTitleItemStyle}>单点监测</Text>
        );
    }
    // 返回右边按钮
    renderRightItem() {
        return(
            <TouchableOpacity onPress={()=>{this.goHistory()}}
            >
                <Image source={require('../../image/lishi.png')} style={styles.navBarRightItemStyle} />
            </TouchableOpacity>
        );
    }
    goHistory =() =>{
        this.props.navigation.navigate('History')
    };
    render() {

        const option = {
            //点击某一个点的数据的时候，显示出悬浮窗
            tooltip : {
                trigger: 'axis'
            },
            //可以手动选择现实几个图标
            legend: {
                data:['PH','COD','氨氮','总磷','悬浮物'],
            },
            //各种表格
            toolbox: {
                //改变icon的布局朝向
                orient: 'row',
                show : true,
                showTitle:true,
                feature : {
                    //show是否显示表格，readOnly是否只读
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        //折线图  柱形图    总数统计 分开平铺
                        type: ['line', 'bar','stack','tiled'],
                    },
                }
            },
            xAxis : [
                {
                    //就是一月份这个显示为一个线段，而不是数轴那种一个点点
                    boundaryGap:true,
                    type : 'category',
                    name : '时间',
                    data : ['8:00','10:00','12:00','14:00','16:00','18:00','20:00','22:00'],
                    axisLine:{show:false},     //坐标轴
                    axisTick:[{    //坐标轴小标记
                        show:false
                    }],
                    axisLabel: {
                        textStyle: {
                            fontSize: '10'
                        }
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    name : '值',
                    axisLine:{show:false},
                    axisTick:[{    //坐标轴小标记
                        show:false
                    }],
                }
            ],
            //图形的颜色组
            color:['rgb(249,159,94)','rgb(67,205,126)','rgb(168,47,47)','rgb(160,201,144)','rgb(68,147,47)'],
            //需要显示的图形名称，类型，以及数据设置
            series : [
                {
                    name:'PH',
                    //默认显
                    type:'line',
                    data:this.state.PH
                },
                {
                    name:'COD',
                    type:'line',
                    data:this.state.COD
                },
                {
                    name:'氨氮',
                    type:'line',
                    data:this.state.AD
                },
                {
                    name:'总磷',
                    type:'line',
                    data:this.state.LIN
                },
                {
                    name:'悬浮物',
                    type:'line',
                    data:this.state.XF
                }
            ]
        };
        return (
            <View style={styles.container}>
                <IMNavBar
                    leftItem={() => this.renderLeftItem()}
                    titleItem={() => this.renderTitleItem()}
                    rightItem={()=>this.renderRightItem()}
                />
                <ScrollView>
                <View style={[styles.containerTop,styles.sbu_red,styles.topRadius]}>
                    <View style={[styles.item,styles.center]}>
                        <Text style={styles.fontTitle}>基本信息</Text>
                    </View>
                    <View style={styles.viewLine}/>
                    <View style={[styles.item,styles.lineLeftRightTop]}>
                        <View style={[styles.center,styles.flex,styles.lineCenter]}>
                            <Text style={styles.font}>所在城市：武汉</Text>
                        </View>
                    </View>
                    <View style={styles.item}>
                        <View style={[styles.center,styles.flex,styles.lineCenter]}>
                            <Text style={styles.font}>监测对象：地表水</Text>
                        </View>
                    </View>
                    <View style={styles.item}>
                        <View style={[styles.center,styles.flex,styles.lineCenter]}>
                            <Text style={styles.font}>水质项目：三级</Text>
                        </View>
                    </View>
                </View>
                <View style={[styles.containerCenter,styles.sbu_red]}>
                <Echarts option={option} height={300} width={width-10} />
                </View>
                    <View style={[styles.containerBottom,styles.sbu_red,styles.bottomRadius]}>
                        <View style={[styles.item,styles.center]}>
                            <Text style={styles.fontTitle}>最近监测结果</Text>
                        </View>
                        <View style={styles.viewLine}/>
                        <View style={[styles.item,styles.lineLeftRightTop]}>
                            <View style={[styles.center,styles.flex,styles.lineCenter]}>
                                <Text style={styles.font}>数据时间：2018/12/18</Text>
                            </View>
                        </View>
                        <View style={styles.item}>
                            <View style={[styles.center,styles.flex,styles.lineCenter]}>
                                <Text style={styles.font}>水质类别：二类</Text>
                            </View>
                        </View>
                        <View style={styles.item}>
                            <View style={[styles.center,styles.flex,styles.lineCenter]}>
                                <Text style={styles.font}>超标项：PH</Text>
                            </View>
                        </View>
                    </View>
                </ScrollView>
            </View>
        );
    }
}
const styles = StyleSheet.create({

    container: {
        flex:1,
    },

    containerTop:{
        marginTop:5,
        marginLeft:5,
        marginRight:5,
        height:150,
        flexDirection:'column',
        padding:2,
    },
    containerBottom:{
        marginTop:5,
        marginLeft:5,
        marginRight:5,
        marginBottom:5,
        height:150,
        flexDirection:'column',
        padding:2,
    },
    containerCenter:{
        marginTop:5,
        marginLeft:5,
        marginRight:5,
        height:300,
        flexDirection:'column',
        padding:2,
    },
    topRadius:{
        borderTopLeftRadius:5,
        borderTopRightRadius:5
    },
    bottomRadius:{
        borderBottomLeftRadius:5,
        borderBottomRightRadius:5
    },
    sbu_red:{
        backgroundColor: '#FFFFFF',
        borderColor:'#FA6778',
    },
    item:{
        flex:1,
        height:80,
        marginLeft:10
    },
    lineLeftRight:{
        borderLeftWidth:1/PixelRatio.get(),
        borderRightWidth:1/PixelRatio.get(),
        borderColor:'#fff'
    },
    lineLeftRightTop:{
        borderLeftWidth:1/PixelRatio.get(),
        borderRightWidth:1/PixelRatio.get(),
        borderColor:'#fff',
        marginTop:10
    },
    lineCenter:{
        borderBottomWidth:1/PixelRatio.get(),
        borderColor:'#fff'
    },
    center:{
        justifyContent:'center',

    },
    fontTitle:{
        color:'#ccc',
        fontSize:18,
    },
    viewLine:{
        height:1,
        backgroundColor:'#cccccc',

    },
    font:{
        color:'#000',
        fontSize:16,
    },
    titleView:{
        height:Platform.OS=='ios'?64:44,
        paddingTop:Platform.OS=='ios'?14:0,
        backgroundColor:'#ff6400',
        justifyContent: 'center',
        alignItems: 'center',
    },
    title:{
        color:'white',
        fontSize:20,
        textAlign:'center',
    },
    titleText: {
        color: '#FFF',
        fontSize: 16,
    },
    navBarLeftItemStyle: {
        width:20,
        height:20,
        marginLeft:15,
    },
    navBarTitleItemStyle: {
        width:66,
        height:20,
        color: '#FFF',
        fontSize: 16,
    },
    navBarRightItemStyle: {
        width:20,
        height:20,
        marginRight:15,
    },

});
AppRegistry.registerComponent('GMChart', () => GMChart);
