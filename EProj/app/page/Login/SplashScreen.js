import React,{Component} from 'react';
import {
    Text,
    View,
    Image,
    StyleSheet,
    AsyncStorage,
    Dimensions,
    StatusBar
}from 'react-native';
const window = Dimensions.get('window');
import { NavigationActions } from 'react-navigation'
const  resetAction = NavigationActions.reset({
    index: 0,
    actions: [
        NavigationActions.navigate({routeName:'Tab'})//要跳转到的页面名字
    ]
});
export default class SplashScreen extends Component{
    static navigationOptions = ({ navigation }) => ({
        header:null
    });

    // 组件加载完成
    componentDidMount() {
        setTimeout(this.onApp.bind(this),1500);
    }
    onApp(){
        AsyncStorage.getItem('userId',(error,result)=>{
            const userInfo =  JSON.parse(result) ;
            if (userInfo!==null){
                if (userInfo.token!=null){
                    this.props.navigation.dispatch(resetAction);
                } else {
                    this.props.navigation.navigate('Login');
                }
            } else {
                this.props.navigation.navigate('Login');
            }

        });
    }
    render(){
        return(
            <View style={styles.container}>
                <StatusBar
                    animated={true} //指定状态栏的变化是否应以动画形式呈现。目前支持这几种样式：backgroundColor, barStyle和hidden
                    hidden={false}  //是否隐藏状态栏。
                    backgroundColor={'rgba(0,0,0,0)'} //状态栏的背景色
                    translucent={true}//指定状态栏是否透明。设置为true时，应用会在状态栏之下绘制（即所谓“沉浸式”——被状态栏遮住一部分）。常和带有半透明背景色的状态栏搭配使用。
                    barStyle={'light-content'} // enum('default', 'light-content', 'dark-content')
                >
                </StatusBar>
                <Image source={require('../../image/background.jpg')}/>
            </View>
        )

    };
}
const styles =StyleSheet.create({
    container: {
        flex:1,
        backgroundColor:'red'
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});