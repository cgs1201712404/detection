/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/5/26
 \* Time: 11:55
 \* Description: 该文件用于记录常用的下拉框中等静态值
 \*/

export default {

  SUCCESS: 0,
  ERROR: 1,

  classifications: [
    {
      label: '污水类',
      value: 'sewage',
      factors: [
        {
          value: 'pH',
          label: 'PH'
        },
        {
          value: 'cod',
          label: 'COD'
        },
        {
          value: 'nH3N',
          label: '氨氮'
        },
        {
          value: 'tP',
          label: '总磷'
        },
        {
          value: 'oil',
          label: '水中油'
        },
        {
          value: 'flow',
          label: '流量'
        },
      ]
    },
    {
      label: '大气类',
      value: 'gas',
      factors: [
        {
          value: 'sD',
          label: '二氧化硫'
        },
        {
          value: 'nOZ',
          label: '二氧化氮'
        },
        {
          value: 'nO',
          label: '一氧化氮'
        },
        {
          value: 'tCM',
          label: '隧道一氧化碳'
        },
        {
          value: 'tSP',
          label: 'TSP（总悬浮物）'
        },
        {
          value: 'pM1',
          label: 'PM1'
        },
        {
          value: 'pM25',
          label: 'PM2.5'
        },
        {
          value: 'pM10',
          label: 'PM10'
        },
        {
          value: 'temperature',
          label: '温度'
        },
        {
          value: 'humidity',
          label: '湿度'
        },
        {
          value: 'atmPress',
          label: '大气压'
        },
        {
          value: 'windSpeed',
          label: '风速'
        },
        {
          value: 'rainfall',
          label: '降雨量'
        },
      ]
    },
    {
      label: '噪声类',
      value: 'noise',
      factors: [
        {
          value: 'intensity',
          label: '噪声强度'
        },
        {
          value: 'frequency',
          label: '噪声频率'
        },
      ]
    },
    {
      label: '固废类',
      value: 'solid',
      factors: [
        {
          value: 'capacity',
          label: '垃圾压缩池池容'
        }
      ]
    }
  ],

  cities: [
    {
      name: "武汉",
      counties: ["江岸", "江汉", "硚口", "汉阳", "武昌", "青山", "洪山", "东西湖",
        "汉南", "蔡甸", "江夏", "黄陂", "新洲"]
    },
    {
      name: "黄石",
      counties: ["黄石港", "西塞山", "下陆", "铁山", "阳新", "大冶"]
    },
    {
      name: "十堰",
      counties: ["茅箭", "张湾", "郧阳", "郧西", "竹山", "竹溪", "房", "丹江口"]
    },
    {
      name: "宜昌",
      counties: ["西陵", "伍家岗", "点军", "猇亭", "夷陵", "远安", "兴山", "秭归",
        "长阳", "五峰", "宜都", "当阳", "枝江"]
    },
    {
      name: "襄阳",
      counties: ["襄城", "樊城", "襄州", "南漳", "谷城", "保康", "老河口", "枣阳",
        "宜城"]
    },
    {
      name: "鄂州",
      counties: ["梁子湖", "华容", "鄂城"]
    },
    {
      name: "荆门",
      counties: ["东宝", "掇刀", "京山", "沙洋", "钟祥"]
    },
    {
      name: "孝感",
      counties: ["孝南", "孝昌", "大悟", "云梦", "应城", "安陆", "汉川"]
    },
    {
      name: "荆州",
      counties: ["沙市", "荆州", "公安", "监利", "江陵", "石首", "洪湖", "松滋"]
    },
    {
      name: "黄冈",
      counties: ["黄州", "团风", "红安", "罗田", "英山", "浠水", "蕲春", "黄梅", "麻城", "武穴"]
    },
    {
      name: "咸宁",
      counties: ["咸安", "嘉鱼", "通城", "崇阳", "通山", "赤壁"]
    },
    {
      name: "随州",
      counties: ["曾都", "随县", "广水"]
    },
    {
      name: "恩施",
      counties: ["恩施", "利川", "建始", "巴东", "宣恩", "咸丰", "来凤", "鹤峰"]
    },
    {
      name: "直辖县级",
      counties: ["仙桃", "潜江", "天门", "神农架林"]
    }
  ],

  defaultPermissionGroup: [
    {
      path: '/map',
      name: 'map',
      label: '地图监控',
      checked: true,
    },
    {
      path: '/realTime',
      name: 'realTime',
      label: '实时数据',
      checked: true,
    },
    {
      path: '/history',
      name: 'history',
      label: '历史数据',
      checked: true,
    },
    {
      path: '/control',
      name: 'control',
      label: '设备控制',
      checked: true,
    },
    {
      path: '/maintaining',
      name: 'maintaining',
      label: '设备维护',
      checked: true,
      permission: [{id: 'maintaining:edit', value: 'edit', label: '编辑', checked: true},
        {id: 'maintaining:export', value: 'export', label: '导出', checked: true}]
    },
    {
      path: '/surveillance',
      name: 'surveillance',
      label: '视频监控',
      checked: true,
      permission: [{id: 'surveillance:edit', value: 'edit', label: '编辑', checked: true},
        {id: 'surveillance:export', value: 'export', label: '导出', checked: true}]
    },
    {
      path: '/processing',
      name: 'processing',
      label: '报警处理',
      checked: true,
      permission: [{id: 'processing:edit', value: 'edit', label: '编辑', checked: true},
        {id: 'processing:export', value: 'export', label: '导出', checked: true}]
    },
    {
      path: '/configuration',
      name: 'configuration',
      label: '报警配置',
      checked: true,
      permission: [{id: 'configuration:remove', value: 'remove', label: '删除', checked: true},
        {id: 'configuration:add', value: 'add', label: '新增', checked: true},
        {id: 'configuration:edit', value: 'edit', label: '编辑', checked: true}]
    },
    {
      path: '/daily',
      name: 'daily',
      label: '日报',
      checked: true,
      permission: [{id: 'daily:export', value: 'export', label: '导出', checked: true}]
    },
    {
      path: '/monthly',
      name: 'monthly',
      label: '月报',
      checked: true,
      permission: [{id: 'monthly:export', value: 'export', label: '导出', checked: true}]
    },
    {
      path: '/analysis',
      name: 'analysis',
      label: '报表分析',
      checked: true,
    },
    {
      path: '/user',
      name: 'user',
      label: '用户管理',
      checked: false,
      permission: [{id: 'user:remove', value: 'remove', label: '删除', checked: false},
        {id: 'user:add', value: 'add', label: '新增', checked: false},
        {id: 'user:edit', value: 'edit', label: '编辑', checked: false}]
    },
    {
      path: '/role',
      name: 'role',
      label: '角色权限管理',
      checked: false,
      permission: [{id: 'role:remove', value: 'remove', label: '删除', checked: false},
        {id: 'role:add', value: 'add', label: '新增', checked: false},
        {id: 'role:edit', value: 'edit', label: '编辑', checked: false},
        {id: 'role:grant', value: 'grant', label: '分配权限', checked: false}]
    },
    {
      path: '/logger',
      name: 'logger',
      label: '日志管理',
      checked: false,
    }
  ]

}
