import React,{Component} from 'react';
import {
    Text,
    View,
    Image,
    StyleSheet,
    AsyncStorage,
    Dimensions,
}from 'react-native';
const window = Dimensions.get('window');
import { NavigationActions } from 'react-navigation'
const  resetAction = NavigationActions.reset({
    index: 0,
    actions: [
        NavigationActions.navigate({routeName:'Tab'})//要跳转到的页面名字
    ]
});
const  resetLogin = NavigationActions.reset({
    index: 0,
    actions: [
        NavigationActions.navigate({routeName:'Login'})//要跳转到的页面名字
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
                <Image source={{
                    uri:'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527575081565&di=427ceb602b52565392ba0943b997f290&imgtype=0&src=http%3A%2F%2Fi3.sinaimg.cn%2Ftravel%2Ful%2F2009%2F0318%2FU3059P704DT20090318152814.jpg',
                    width:window.width,
                    height:window.height
                }}/>
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