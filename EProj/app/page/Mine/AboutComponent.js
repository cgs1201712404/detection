import React, {Component} from 'react';
import {
    Dimensions,
    Image,
    ListView,
    PixelRatio,
    StyleSheet,
    Text,
    View,
    ImageBackground
} from 'react-native';

import ParallaxScrollView from 'react-native-parallax-scroll-view';
import BouncingBalls from 'react-native-bouncing-ball'

export default class AboutComponent {
    /**
     * 这些参数可以根据自己的需要传递
     * 比如常见的我的，设置，关于等
     * @param props
     * @param updateState
     * @param flag
     * @param config
     */
    constructor(props, updateState, flag, config) {
        this.props = props;
        this.updateState = updateState;
        this.flag = flag;
        this.config = config;

    }

    /**
     * 配置ParallaxScrollView
     * @param params
     * @returns {{}}
     */
    renderParallaxScrollView(params) {
        let config = {};
        config.renderBackground = () => (
            <View key="background">
                <ImageBackground style={styles.ImageBack} source={require('../../image/background.jpg')}>
                    <BouncingBalls
                        amount={10}
                        animationDuration={5000}
                        minSpeed={30}
                        maxSpeed={200}
                        minSize={40}
                        maxSize={100}
                        imageBall={require('../../image/bouncing_ball.png')}
                    />
                </ImageBackground>
                <Image source={{
                    uri: params.bg_url,
                    width: window.width,
                    height: PARALLAX_HEADER_HEIGHT
                }}/>
                <View style={{
                    position: 'absolute',
                    top: 0,
                    width: window.width,
                    backgroundColor: 'rgba(0,0,0,0)',
                    height: PARALLAX_HEADER_HEIGHT
                }}/>
            </View>
        );

        config.renderForeground = () => (
            <View key="parallax-header" style={styles.parallaxHeader}>
                <Image style={styles.avatar} source={{
                    uri: params.author_img,
                    width: AVATAR_SIZE,
                    height: AVATAR_SIZE
                }}/>
                <Text style={styles.sectionSpeakerText}>
                    {params.title}
                </Text>
                <Text style={styles.sectionTitleText}>
                    {params.info}
                </Text>
            </View>
        );

        config.renderStickyHeader = () => (
            <View key="sticky-header" style={styles.stickySection}>
                <Text style={styles.stickySectionText}>{params.title}</Text>
            </View>
        );

        config.renderFixedHeader = () => (
            <View key="fixed-header" style={styles.fixedSection}>

            </View>
        );
        return config;
    }

    /**
     *
     * @param contentView
     * @param params
     * @returns {XML}
     */
    renderView(contentView, params) {
        this.RenderConfig = this.renderParallaxScrollView(params);
        return (
            <ParallaxScrollView
                headerBackgroundColor="#333"
                stickyHeaderHeight={STICKY_HEADER_HEIGHT}
                parallaxHeaderHeight={PARALLAX_HEADER_HEIGHT}
                backgroundSpeed={10}
                {...this.RenderConfig}>
                {contentView}
            </ParallaxScrollView>
        );
    }
}

const window = Dimensions.get('window');

const AVATAR_SIZE = 50;
const ROW_HEIGHT = 50;
const PARALLAX_HEADER_HEIGHT = 280;
const STICKY_HEADER_HEIGHT = 64;
const SCREEN_WIDTH = window.width;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'black'
    },
    ImageBack:{
        width: window.width,
        height: PARALLAX_HEADER_HEIGHT
    },
    background: {
        position: 'absolute',
        top: 0,
        left: 0,
        width: window.width,
        height: PARALLAX_HEADER_HEIGHT
    },
    stickySection: {
        flexDirection: 'row',
        alignItems: "center",
        height: 75,
        width: SCREEN_WIDTH,
        backgroundColor: "#8B9399",
        justifyContent: 'space-around'
    },
    stickySectionText: {
        color: 'white',
        fontSize: 20,
        margin: 10
    },
    fixedSection: {
        width: SCREEN_WIDTH,
        position: 'absolute',
        height: 70,
        // borderWidth: 1,
        // borderColor: "red",
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "space-between"

    },
    fixedSectionText: {
        color: '#999',
        fontSize: 20
    },
    parallaxHeader: {
        alignItems: 'center',
        flex: 1,
        flexDirection: 'column',
        paddingTop: 100
    },
    avatar: {
        height: 60,
        width: 60,
        borderRadius: 30,
        marginBottom: 10,

    },
    sectionSpeakerText: {
        color: 'white',
        fontSize: 18,
        paddingVertical: 5
    },
    sectionTitleText: {
        color: 'white',
        fontSize: 10,
        paddingVertical: 5
    },
    row: {
        overflow: 'hidden',
        paddingHorizontal: 10,
        height: ROW_HEIGHT,
        backgroundColor: 'white',
        borderColor: '#ccc',
        borderBottomWidth: 1,
        justifyContent: 'center'
    },
    rowText: {
        fontSize: 20
    },
    left: {
        flexDirection: "row",
        justifyContent: "flex-start",
        alignItems: "center"
    }
});
