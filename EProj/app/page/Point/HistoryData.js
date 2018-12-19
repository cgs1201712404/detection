import React, { Component } from 'react';
import {
    StyleSheet,
    View,
    ScrollView,
    Dimensions,
    Text
} from 'react-native';
import { Table, TableWrapper, Row ,Cell} from 'react-native-table-component';
import IMNavBar from '../../common/IMNavBar'
import Toast from '../../utils/ToastUtil'

const width = Dimensions.get("window").width/7;

export default class HistoryData extends Component {
    static navigationOptions = ({navigation}) => ({
        header: null
    });

    constructor(props) {
        super(props);
        this.state = {
            tableHead: ['序号', 'PH', 'COD', '氨氮', '总磷', '悬浮物', '时间'],
            widthArr: [width,width,width, width, width, width, width]
        }
    }
    // 返回中间按钮
    renderTitleItem() {
        return(
            <Text style={styles.titleText}>单点监测</Text>
        );
    }


    render() {
        const state = this.state;

        const tableData = [];
        for (let i = 0; i < 30; i += 1) {
            const rowData = [];
            for (let j = 0; j < 7; j += 1) {
                rowData.push(`${i}${j}`);
            }
            tableData.push(rowData);
        }

        return (
            <View style={styles.container}>
                <IMNavBar
                    // leftItem={() => this.renderLeftItem()}
                    titleItem={() => this.renderTitleItem()}
                    // rightItem={() => this.renderRightItem()}
                />
                <ScrollView horizontal={true}>
                    <View>
                        <Table borderStyle={{borderColor: '#C1C0B9'}}>
                            <Row data={state.tableHead} widthArr={state.widthArr} style={styles.header} textStyle={styles.text}/>
                        </Table>
                        <ScrollView style={styles.dataWrapper}>
                            <Table borderStyle={{borderColor: '#C1C0B9'}}>
                                {
                                    tableData.map((rowData, index) => (
                                        <Row
                                            key={index}
                                            data={rowData}
                                            widthArr={state.widthArr}
                                            style={[styles.row, index%2 && {backgroundColor: '#F7F6E7'}]}
                                            textStyle={styles.text}


                                        />

                                    ))
                                }
                            </Table>
                        </ScrollView>
                    </View>
                </ScrollView>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff'
    },
    header: {
        height: 50,
        backgroundColor: '#537791'
    },
    text: {
        textAlign: 'center',
        fontWeight: '100'
    },
    dataWrapper: {
        marginTop: -1
    },
    row: {
        height: 40,
        backgroundColor: '#FFFFFC'
    },
    row1: {
        flexDirection: 'row',
        backgroundColor: '#FFF'
    },
    titleText: {
        color: '#FFF',
        fontSize: 16,
    },

});