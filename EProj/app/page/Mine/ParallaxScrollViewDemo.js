import React, {Component} from 'react';
import {
    Platform,
    StyleSheet,
    Text,
    View,
    TouchableOpacity,
    FlatList,
    Dimensions,
    AsyncStorage,
    BackHandler

} from 'react-native';
import Dialog, {
    DialogTitle,
    DialogContent,
    DialogButton,
    SlideAnimation,
    ScaleAnimation,
} from 'react-native-popup-dialog';
import AboutComponent from "./AboutComponent";
import MenuRow from '../../common/MenuRow'
import ToastUtil from '../../utils/ToastUtil'


type Props = {};
const width = Dimensions.get("window").width;



export default class ParallaxScrollViewDemo extends Component<Props> {
    static navigationOptions = ({ navigation }) => ({
        header:null
    });
    state={
        scaleAnimationDialog: false,
    };
    constructor(props) {
        super(props);
        this.aboutCommon = new AboutComponent(props, null, null, null);
    }
    goNews =() =>{
        this.props.navigation.navigate('News', { name: 'XXX' ,age:25})
    };
    loginOut = () =>{
        this.setState({
            scaleAnimationDialog: true,
        });
    };
        render() {
        let contentView = <View
            style={{
                backgroundColor: 'transparent',
                position: 'relative',
                flex: 1}}>

            <View style={{height: 10}} />
            <View style={{backgroundColor: '#ffffff'}}>
                <TouchableOpacity   style={{
                    justifyContent: 'center', alignItems: 'center',
                }} onPress={()=>{
                    this.goNews();
                    ToastUtil.showShort("我的消息")
                }}>
                <MenuRow leftIcon="email-outline" title="我的消息" border={false} rightIcon />
                </TouchableOpacity>
            </View>
            <View style={{height: 10}} />
            <View style={{backgroundColor: '#ffffff'}}>
               <TouchableOpacity   style={{
                   justifyContent: 'center', alignItems: 'center',
               }} onPress={()=>{ToastUtil.showShort("日志")}}>
                <MenuRow leftIcon="book" title="我的日志" rightIcon  />
               </TouchableOpacity>
                <TouchableOpacity   style={{
                    justifyContent: 'center', alignItems: 'center',
                }} onPress={()=>{ToastUtil.showShort("报警处理")}}>
                <MenuRow leftIcon="book" title="报警处理" rightIcon />
                </TouchableOpacity>
                <MenuRow leftIcon="headphones-box" title="设置" rightIcon border={false} />
            </View>
            <View style={{height: 10}} />
            <Text style={styles.textStyle} onPress={this.loginOut}>
                退出登录
            </Text>

            <Dialog
                onDismiss={() => {
                    this.setState({ scaleAnimationDialog: false });
                }}
                width={0.9}
                visible={this.state.scaleAnimationDialog}
                rounded
                dialogTitle={
                    <DialogTitle
                        title="你要确定退出登录吗"
                        style={{
                            backgroundColor: '#F7F7F8',
                        }}
                        hasTitleBar={false}
                        align="left"
                    />
                }
                actions={[
                    <DialogButton
                        text="取消"
                        onPress={() => {
                            this.setState({ scaleAnimationDialog: false });
                        }}
                        key="button-1"
                    />,
                    <DialogButton
                        text="确定"
                        onPress={() => {
                            AsyncStorage.removeItem('userId',function(err) {
                                if (err) {
                                    //console.log('__removeItem:'+err);
                                }
                                ToastUtil.showShort("退出登录");
                            });
                            this.setState({ scaleAnimationDialog: false });
                            BackHandler.exitApp();
                        }}
                        key="button-2"
                    />,
                ]}
            >

                <DialogContent
                    style={{
                        backgroundColor: '#F7F7F8',
                    }}
                >
                    <Text>你确定退出登录？</Text>
                </DialogContent>
            </Dialog>
        </View>;

        return this.aboutCommon.renderView(contentView, {
            "title": "昵称什么",
            "info": "这个人很懒，什么都没留下",
            "bg_url": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527575081565&di=427ceb602b52565392ba0943b997f290&imgtype=0&src=http%3A%2F%2Fi3.sinaimg.cn%2Ftravel%2Ful%2F2009%2F0318%2FU3059P704DT20090318152814.jpg",
            "author_img": "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=31220976,2327152167&fm=27&gp=0.jpg"
        })
    }

}
const styles = StyleSheet.create({
    textStyle:{
        fontSize:20,
        textAlign:'center',
        justifyContent: 'center',
        marginTop:30,
        color:'red'
    },

});
