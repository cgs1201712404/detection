import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
} from 'react-native';

export default class MapPage extends Component {
    static navigationOptions = ({ navigation }) => ({
        header:null
    });

    render() {
        return (
            <View style={styles.container}>

                <Text style={styles.welcome} >
                    map
                </Text>

            </View>
        );
    }
    componentWillMount(){
        console.disableYellowBox = true;  //关闭警告提示

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
