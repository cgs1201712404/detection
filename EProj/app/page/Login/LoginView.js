import React, {Component} from 'react';
import {
    StyleSheet,
    TouchableOpacity,
    Text,
    View,
    StatusBar,
    Image,
    Platform,
    Keyboard,
    AsyncStorage,
    PermissionsAndroid,
    ToastAndroid
} from 'react-native';
import {checkMobile} from "../../utils/CheckUitls";
import {fetchRequest} from "../../utils/FetchUtil";
import ToastUtil from "../../utils/ToastUtil";
import MyTextInputWithIcon from "../../common/MyTextInputWithIcon";
import {
    isIphoneX,
    zAppBarHeight,
    zdp,
    zsp,
    zStatusBarHeight,
    zWidth,
} from "../../utils/ScreenUtil";
import {cusColors} from "../../utils/cusColors";
import ZText from "../../common/ZText";
import MyButtonView from "../../common/MyButtonView";
import {KeyboardAwareScrollView} from "react-native-keyboard-aware-scroll-view";
import {NavigationActions} from "react-navigation";


const Dimensions = require('Dimensions');
const {width, height} = Dimensions.get('window');
const  resetLogin = NavigationActions.reset({
    index: 0,
    actions: [
        NavigationActions.navigate({routeName:'Tab'})//要跳转到的页面名字
    ]
});
export default class LoginView extends Component {
    static navigationOptions = {
        header: null
    };
    constructor() {
        super();

        this.state = {
            data: '',
            phone: '',
            password: '',
        };
        this._onPress = this._onPress.bind(this);
    }

    async componentDidMount() {
        try {
            const granted = await PermissionsAndroid.request(
                PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION,
                {
                    //第一次请求拒绝后提示用户你为什么要这个权限
                    'title': '我要地址查询权限',
                    'message': '没权限我不能工作，同意就好了'
                }
            );

            if (granted === PermissionsAndroid.RESULTS.GRANTED) {
                this.show("你已获取了地址查询权限")
            } else {
                this.show("获取地址查询失败")
            }
        } catch (err) {
            this.show(err.toString())
        }
    }

    static defaultProps = {
        onPress: null
    };

    _onPress() {
        Keyboard.dismiss();

        if (!checkMobile(this.state.phone)) {
            return;
        }

        let formData = new FormData();
        formData.append('phone', this.state.phone);
        formData.append('password', this.state.password);
        fetchRequest('Login', 'POST', formData)
            .then(res => {
                    console.log(res);
                    console.log(res.data);

                    if (res.respCode === 200 && !this.state.isLoading) {
                        console.log(res.data);


                    } else {
                        ToastUtil.showShort(res.respMsg);
                    }
                }
            ).catch(err => {
            console.log(err);
            ToastUtil.showShort(err);
        });
    }


    render() {
        return (
            <KeyboardAwareScrollView style={{flex: 1, width: zWidth, backgroundColor: 'white'}}
                                     behavior="padding"
                                     resetScrollToCoords={{x: 0, y: 0}}
                                     contentContainerStyle={{
                                         justifyContent: 'flex-start',
                                         alignItems: 'center'
                                     }}
                                     scrollEnabled={false}
                                     showsVerticalScrollIndicator={false}
                                     keyboardShouldPersistTaps={'always'}>
                <View style={{
                    flex: 1,
                    marginTop: Platform.OS === 'ios' ? -zStatusBarHeight : 0,
                    justifyContent: 'flex-start',
                    alignItems: 'center'
                }}>
                    <Image source={{uri: isIphoneX() ? 'login_bg_x' : 'login_bg'}}
                           resizeMode={'cover'}
                           style={{
                               width: width,
                               height: height,
                               position: 'absolute'
                           }}/>
                    <View style={{justifyContent: 'center', alignItems: 'center'}}>
                    </View>
                    <View
                        style={{flex: 1, alignItems: 'center'}}>
                        <Image source={require('./logo2.png')}
                               style={{
                                   width: zdp(140),
                                   height: zdp(80),
                                   marginTop: zAppBarHeight + zdp(20)
                               }}
                               resizeMode={'contain'}/>

                    </View>
                </View>
                <MyTextInputWithIcon
                    style={{marginTop: zdp(160)}}
                    maxLength={11}
                    placeholder={'请输入手机号'}
                    keyboardType={'numeric'}
                    iconName={'login_phone'}
                    defaultValue={this.state.phone}
                    onChangeText={text => {
                        this.setState({
                            phone: text
                        })
                    }}
                />

                <MyTextInputWithIcon
                    secureTextEntry={true}
                    placeholder={'密码登录'}
                    defaultValue={this.state.password}
                    // keyboardType={'email-address'}
                    iconName={'login_psw'}
                    onChangeText={text => {
                        this.setState({
                            password: text
                        })
                    }}
                />

                <MyButtonView style={{width: width / 1.3, marginTop: zdp(75.5)}} modal={1}
                              title={'登 录'}
                              onPress={
                                  this.pressMain}/>
                <View style={styles.wtf}>
                    <TouchableOpacity activeOpacity={0.9}
                                      style={{
                                          justifyContent: 'center', alignItems: 'center',
                                          padding: zdp(5)
                                      }}
                                      onPress={
                                          this.pressMain
                                      }
                    >
                        <ZText parentStyle={{marginLeft: zdp(40)}} content={'验证码登录'}
                               fontSize={zsp(16)} color={cusColors.text_secondary}
                               textAlign={'center'}/>
                    </TouchableOpacity>
                    <TouchableOpacity activeOpacity={0.9}
                                      style={{
                                          justifyContent: 'center', alignItems: 'center',
                                          padding: zdp(5)
                                      }}

                    >
                        <ZText parentStyle={{marginRight: zdp(40)}} content={'忘记密码?'}
                               fontSize={zsp(16)} color={cusColors.text_secondary}
                               textAlign={'center'}/>
                    </TouchableOpacity>
                </View>
                <View style={{
                    justifyContent: 'center',
                    alignItems: 'center',
                    flexDirection: 'row',
                    padding: zdp(5),
                    marginTop: zdp(40)
                }}>
                </View>
            </KeyboardAwareScrollView>

        );
    }

    show(data) {
        ToastAndroid.show(data,ToastAndroid.SHORT)
    }
    pressMain = () => {
        let userInfo={
            phone:this.props.phone,
            password:this.props.password,
            token:'login'
        };
        AsyncStorage.setItem('userId',JSON.stringify(userInfo),function(err){
            if (err){
                ToastUtil.showShort(err);
                return;
            }
        });
        // this.props.navigate('Tab');
        this.props.navigation.dispatch(resetLogin);
    };
    async requestLocationPermission() {
        try {
            const granted = await PermissionsAndroid.request(
                PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION,
                {
                    //第一次请求拒绝后提示用户你为什么要这个权限
                    'title': '我要地址查询权限',
                    'message': '没权限我不能工作，同意就好了'
                }
            );

            if (granted === PermissionsAndroid.RESULTS.GRANTED) {
                this.show("你已获取了地址查询权限")
            } else {
                this.show("获取地址查询失败")
            }
        } catch (err) {
            this.show(err.toString())
        }
    }


}
const styles = StyleSheet.create({
    text: {
        color: 'white',
        backgroundColor: 'transparent',
    },
    wtf: {
        marginTop: zdp(15),
        top: zdp(5),
        width: width,
        flexDirection: 'row',
        justifyContent: 'space-around',
    },
});

