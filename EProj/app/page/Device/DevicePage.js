import React, { Component } from 'react';
import {
    StyleSheet,
    TouchableOpacity,
    Image,
    Text,
    View,
    FlatList,
    ActivityIndicator,
    StatusBar
} from 'react-native';
import IMNavBar from '../../common/IMNavBar'
import Picker from 'react-native-picker';
import area from './area.json';
import ToastUtil from "../../utils/ToastUtil";
import ListItem from '../../common/ListItem'
import MyButton from '../../common/MyButtonView'

export default class DevicePage extends Component{
    static navigationOptions = ({ navigation }) => ({
        header:null
    });
    constructor() {
        super();

        this.state = {
            pickedValue:'选择服务区',
            isRefreshing:true,
            isLoading:true,
            dataSource:[]
        };
        this.dataArr = [];
    }
    _renderItemView({item}){
        return(
            <ListItem
                image={item.image}
                title ={item.title}
            />

        )
    }
    componentDidMount() {
        this._fetchData();
    }
    _fetchData(){
        let formData =new FormData();
        formData.append("count","20");

        fetch('https://guangdiu.com/api/getlist.php',{
            method:'POST',
            headers:{},
            body:formData,
        })
            .then((response)=> response.json())
            .then((responseData)=>{

                    this.setState({
                        dataSource:responseData.data,
                        isLoading:false,
                        isRefreshing:false,
                    });

            })
            .done();

    }
    // 返回左边按钮
    renderLeftItem() {
        return(
            <TouchableOpacity>
                <Image source={require('../../image/one.png')} style={styles.navBarLeftItemStyle} />
            </TouchableOpacity>
        );
    }
    // 返回中间按钮
    renderTitleItem() {
        return(
            <TouchableOpacity onPress={this.showAreaPicker.bind(this)}>
                <Text style={styles.searchContent}>{this.state.pickedValue}</Text>
            </TouchableOpacity>
        );
    }
    // 返回右边按钮
    renderRightItem() {
        return(
            <TouchableOpacity
            >
                <Image source={require('../../image/one.png')} style={styles.navBarRightItemStyle} />
            </TouchableOpacity>
        );
    }
    createAreaData() {
        let data = [];
        let len = area.length;
        for(let i=0;i<len;i++){
            let city = [];
            for(let j=0,cityLen=area[i]['city'].length;j<cityLen;j++){
                let _city = {};
                _city[area[i]['city'][j]['name']] = area[i]['city'][j]['area'];
                city.push(_city);
            }

            let _data = {};
            _data[area[i]['name']] = city;
            data.push(_data);
        }
        return data;
    }
    //区域选择
    showAreaPicker() {
        Picker.init({
            pickerData: this.createAreaData(),
            pickerCancelBtnText:'取消',
            pickerConfirmBtnText:'确定',
            selectedValue: ['湖北', '武汉', '江汉区'],
            pickerBg:[245,245,245,1],
            onPickerConfirm: pickedValue => {
                console.log('area', pickedValue);
                ToastUtil.showShort(pickedValue)
                this.setState({
                    pickedValue:pickedValue
                })
            },
            onPickerCancel: pickedValue => {
                console.log('area', pickedValue);
            },
            onPickerSelect: pickedValue => {
                console.log('area', pickedValue);
            }
        });
        Picker.show();
    }
    _keyExtractor(item,index) {
        return index;
    }
   //刷新数据
    onRefreshData =()=>{
        // alert('下拉刷新')
        fetch('http://guangdiu.com/api/gethots.php')
            .then((response) => response.json())
            .then((responseData) => {

                this.setState({
                    dataSource:responseData.data,
                });


            })
            .done()
    };
    onEndReached = () =>{
        // alert('下拉刷新')
        fetch('http://guangdiu.com/api/gethots.php')
            .then((response) => response.json())
            .then((responseData) => {
                // 拼接数据
                this.dataArr = this.dataArr.concat(responseData.data);
                this.setState({
                    dataSource:this.dataArr,
                    isLoading:true
                });


            })
            .done()
    };
    // ListView尾部
    renderFooter() {
        return (
            <View style={{height: 50}}>
                <ActivityIndicator />

            </View>
        );
    }
    render(){
        return(
            <View style ={styles.container}>
                <StatusBar
                    animated={true} //指定状态栏的变化是否应以动画形式呈现。目前支持这几种样式：backgroundColor, barStyle和hidden
                    hidden={false}  //是否隐藏状态栏。
                    backgroundColor={'rgba(0,0,0,0)'} //状态栏的背景色
                    translucent={true}//指定状态栏是否透明。设置为true时，应用会在状态栏之下绘制（即所谓“沉浸式”——被状态栏遮住一部分）。常和带有半透明背景色的状态栏搭配使用。
                    barStyle={'light-content'} // enum('default', 'light-content', 'dark-content')
                >
                </StatusBar>
                {/*顶部导航样式*/}
                <IMNavBar
                    // leftItem={() => this.renderLeftItem()}
                    titleItem={() => this.renderTitleItem()}
                    // rightItem={() => this.renderRightItem()}
                />
                <FlatList
                    data={this.state.dataSource}
                    renderItem={this._renderItemView}
                    refreshing={this.state.isRefreshing}
                    onRefresh={()=>this.onRefreshData()}
                    onEndReached = {()=>this.onEndReached()}
                    onEndReachedThreshold = {0.5}
                    ListFooterComponent ={()=>this.renderFooter.bind(this)}
                    // initialNumToRender = {10}
                    keyExtractor={this._keyExtractor}

                />
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex:1,
        alignItems: 'center',
        backgroundColor: 'white',
    },

    navBarLeftItemStyle: {
        width:20,
        height:20,
        marginLeft:15,
    },
    navBarTitleItemStyle: {
        width:66,
        height:20,
    },
    navBarRightItemStyle: {
        width:20,
        height:20,
        marginRight:15,
    },
    searchContent: {
        color: '#FFF',
        fontSize: 16,
    }
});