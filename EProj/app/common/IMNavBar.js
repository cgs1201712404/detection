/*
 * 共用的头部bar
 **/
import React,{Component} from "react";
import {
    StyleSheet,
    View,
    Dimensions,
    Platform
} from "react-native";
import PropTypes from 'prop-types';
const {width,height} =Dimensions.get('window');

export default class IMNavBar extends Component{
    static propTypes ={
        leftItem:PropTypes.func,
        titleItem:PropTypes.func,
        rightItem:PropTypes.func,
    };

    /*左边*/
    renderLeftItem(){
        if (this.props.leftItem ===undefined) return;
        return this.props.leftItem();
    }
    // 中间
    renderTitleItem() {
        if (this.props.titleItem === undefined) return;
        return this.props.titleItem();
    }
    // 右边
    renderRightItem() {
        if (this.props.rightItem === undefined) return;
        return this.props.rightItem();
    }
    render(){
        return(
            <View style ={styles.container}>
                {/* 左边 */}
                <View>
                    {this.renderLeftItem()}
                </View>
                {/* 中间 */}
                <View>
                    {this.renderTitleItem()}
                </View>
                {/* 右边 */}
                <View>
                    {this.renderRightItem()}
                </View>
            </View>
        );
    }
}
const styles = StyleSheet.create({
    container: {
        width:width,
        height:Platform.OS === 'ios' ? 64:70,
        backgroundColor:'#8B9399',
        flexDirection:'row', //方向
        justifyContent:'space-between',
        alignItems:'center',
        paddingTop:Platform.OS === 'ios' ? 30 : 25,
    }
});