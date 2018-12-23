# detection
智能检测项目

增加了API-GATEWAY接口网关模块
增加了CENTRAL-PIVOT中心服务模块
增加了USER-MANAGEMENT用户角色权限模块
增加了SEWAGE污水服务模块

其中CENTRAL-PIVOT为后端微服务架构中心，业务逻辑的基点。
几乎所有从服务区监测点触发的业务都从此服务单元开始

# 基本说明
REGISTRATION-CENTER,所有服务注册中心，端口号：8082
API-GATEWAY,系统对外统一入口，端口号：8088
USER-MANAGEMENT,用户服务，端口号：8010-8019
CENTRAL-PIVOT,中心服务，端口号：8020-8029
SEWAGE-SERVICE,污水服务，端口号：8030-8039

# 开发指南
1. 导入数据库，sql文件夹下三个sql文件，分别为三个微服务模块的数据库。

2.前端运行：
cd front  // 进入front目录
npm install // 需要安装node-sass
npm run dev

3.后端运行
运行服务中心实例registration-center -> 运行API网关实例api-gateway
-> 运行其他业务微服务实例