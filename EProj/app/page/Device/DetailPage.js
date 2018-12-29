import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    StatusBar,
    TouchableOpacity
} from 'react-native';
import IMNavBar from '../../common/IMNavBar'
import IconLeft from 'react-native-vector-icons/AntDesign'
import ToastUtil from "../../utils/ToastUtil";
export default class DetailPage extends Component {
    static navigationOptions = ({ navigation }) => ({
        header:null
    });
    constructor(props) {
        super(props);
        this.state = {
           users:[],
           UserVo:'',
            userName:'',
            code:'',
            name:''


        }

    }
    componentDidMount() {
       this.serviceArea()
    }
    //刷新数据
    onRefreshData =()=>{
        // alert('下拉刷新')
        fetch('http://localhost:8088/user-management/user/query/1.html?name=1&limit=10&page=1')
            .then((response) => response.json())
            .then((responseData) => {

             this.setState({
                 users:responseData.users
             })
            ToastUtil.showShort(this.state.users[0].userName);

            })
            .done()
    };
    //刷新数据
    serviceArea =()=>{

        fetch('http://localhost:8088/central-pivot/station/service_areas')
            .then((response) => response.json())
            .then((responseData) => {

                this.setState({
                    code:responseData.code,
                    name:responseData.name
                })
                ToastUtil.showShort(this.state.name)

            })
            .done()
    };
    // 返回左边按钮
    renderLeftItem() {
        return(
            <TouchableOpacity onPress={this.goBack}>
                <IconLeft
                    name={'left'}
                    size={25}
                    color={'gray'}
                    style={styles.navBarLeftItemStyle}
                />

            </TouchableOpacity>
        );
    }
    // 返回中间按钮
    renderTitleItem() {
        return(
            <Text style={styles.navBarTitleItemStyle}>单点监测</Text>
        );
    }
    // // 返回右边按钮
    // renderRightItem() {
    //     return(
    //         <TouchableOpacity
    //         >
    //             <Image source={require('../../image/lishi.png')} style={styles.navBarRightItemStyle} />
    //         </TouchableOpacity>
    //     );
    // }
    goBack=()=>{
        this.props.navigation.goBack();

    };
    render() {
        return (
            <View style={styles.container} >
                <StatusBar
                    animated={true} //指定状态栏的变化是否应以动画形式呈现。目前支持这几种样式：backgroundColor, barStyle和hidden
                    hidden={false}  //是否隐藏状态栏。
                    backgroundColor={'red'} //状态栏的背景色
                    translucent={true}//指定状态栏是否透明。设置为true时，应用会在状态栏之下绘制（即所谓“沉浸式”——被状态栏遮住一部分）。常和带有半透明背景色的状态栏搭配使用。
                    barStyle={'light-content'} // enum('default', 'light-content', 'dark-content')
                >
                </StatusBar>
                <IMNavBar
                    leftItem={() => this.renderLeftItem()}
                    titleItem={() => this.renderTitleItem()}

                />
                <Text style={styles.welcome} onPress={()=>{this.onclickBtn()}}>
                    设备详情页面（控制调参）
                </Text>

            </View>
        );
    }
    componentWillMount(){
        console.disableYellowBox = true;  //关闭警告提示

    }
    onclickBtn =() =>{
        this.props.navigation.navigate('News', { name: 'XXX' ,age:25})
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,

    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
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
        marginRight: 20
    },
    navBarRightItemStyle: {
        width:20,
        height:20,
        marginRight:15,
    },
});