import React,{Component} from "react";
import {
    StyleSheet,
    View,
    Dimensions,
    Platform,
    Image,
    Text,
    TouchableOpacity
} from "react-native";
import PropTypes from 'prop-types';

const {width,height} =Dimensions.get('window');

export default class ListItem extends Component{
    static propTypes ={
        image:PropTypes.string,
        title:PropTypes.string,
    };
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            isOn:true,
            state:'状态:开启',
            stateColor:'green'
        };
    }
    render(){
        return(
            <View style ={styles.cellStyle}>
                {/* 左边图片 */}
                <Image source={require('./timg.jpg')} style={styles.imageStyle}/>
                {/* 中间 */}
                <View style={styles.centerViewStyle}>
                    {/* 标题 */}
                    <View>
                        <Text numberOfLines={3} style={styles.titleStyle}>设备名称:污水类设备</Text>
                    </View>

                    {/* 详情 */}
                    <View style={styles.detailViewStyle}>
                        {/* 平台 */}
                        <Text style={styles.detailMallStyle}>污水类</Text>
                        <TouchableOpacity onPress={() => {
                            if (this.state.isOn){
                                this.setState({
                                    state:'状态:关闭',
                                    isOn:false,
                                    stateColor:'red'
                                })
                            } else {
                                this.setState({
                                    state:'状态:开启',
                                    isOn:true,
                                    stateColor:'green'
                                })
                            }
                        }
                        }>
                        <Text style={{color:this.state.stateColor,fontSize:11}} >{this.state.state}</Text>
                        </TouchableOpacity>
                        {/* 时间 + 来源 */}
                        <Text style={styles.timeStyle}>2018-12</Text>
                    </View>

                </View>

            </View>
        );
    }

}
const styles = StyleSheet.create({
    container: {
        flexDirection:'row',//从左往右
        alignItems:'center',//侧轴居中
        justifyContent:'space-between',
        backgroundColor:'white',
        height:120,
        borderBottomWidth:0.5,
        borderBottomColor:'gray',
        marginLeft:15

    },
    centerViewStyle: {
        height:90,
        justifyContent:'space-around',
    },
    cellStyle: {
        flexDirection:'row',//从左往右
        alignItems:'center',//侧轴居中
        justifyContent:'space-between',//弹性盒子元素均匀分布
        backgroundColor:'white',
        height:120,
        width:width-10,
        borderBottomWidth:0.5,
        borderBottomColor:'gray',
        padding: 10,
        paddingVertical: 20,
        marginLeft: 5,
        marginRight: 5,
        marginVertical: 3,
        borderColor: '#dddddd',
        borderStyle: null,
        borderWidth: 0.5,
        borderRadius: 2,
        shadowColor: 'gray',
        elevation: 2
    },
    imageStyle:{
        width:80,
        height:80
    },
    titleStyle:{
        width:width*0.65
    },
    arrowStyle:{
        width:15,
        height:15,
        marginRight:30
    },
    detailViewStyle: {
        flexDirection:'row',
        justifyContent:'space-between',
        alignItems:'center'
    },
    detailMallStyle: {
        fontSize:11,
        color:'green',
    },
    timeStyle: {
        fontSize:11,
        color:'gray',
    },
});