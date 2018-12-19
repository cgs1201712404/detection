import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    StatusBar
} from 'react-native';

export default class DetailPage extends Component {
    static navigationOptions = ({ navigation }) => ({
        header:null
    });


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
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
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
});