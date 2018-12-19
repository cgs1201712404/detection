/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : monitor_user

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-18 11:01:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for data_permission
-- ----------------------------
DROP TABLE IF EXISTS `data_permission`;
CREATE TABLE `data_permission` (
  `id` varchar(255) NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `request_type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_permission
-- ----------------------------
INSERT INTO `data_permission` VALUES ('configuration:add', '新增', 'add', null, null);
INSERT INTO `data_permission` VALUES ('configuration:edit', '编辑', 'edit', null, null);
INSERT INTO `data_permission` VALUES ('configuration:remove', '删除', 'remove', null, null);
INSERT INTO `data_permission` VALUES ('daily:export', '导出', 'export', null, null);
INSERT INTO `data_permission` VALUES ('maintaining:edit', '编辑', 'edit', null, null);
INSERT INTO `data_permission` VALUES ('maintaining:export', '导出', 'export', null, null);
INSERT INTO `data_permission` VALUES ('monthly:export', '导出', 'export', null, null);
INSERT INTO `data_permission` VALUES ('processing:edit', '编辑', 'edit', null, null);
INSERT INTO `data_permission` VALUES ('processing:export', '导出', 'export', null, null);
INSERT INTO `data_permission` VALUES ('role:add', '新增', 'add', null, null);
INSERT INTO `data_permission` VALUES ('role:edit', '编辑', 'edit', null, null);
INSERT INTO `data_permission` VALUES ('role:grant', '分配权限', 'grant', null, null);
INSERT INTO `data_permission` VALUES ('role:remove', '删除', 'remove', null, null);
INSERT INTO `data_permission` VALUES ('surveillance:edit', '编辑', 'edit', null, null);
INSERT INTO `data_permission` VALUES ('surveillance:export', '导出', 'export', null, null);
INSERT INTO `data_permission` VALUES ('user:add', '新增', 'add', null, null);
INSERT INTO `data_permission` VALUES ('user:edit', '编辑', 'edit', null, null);
INSERT INTO `data_permission` VALUES ('user:remove', '删除', 'remove', null, null);

-- ----------------------------
-- Table structure for menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `menu_permission`;
CREATE TABLE `menu_permission` (
  `name` varchar(255) NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_permission
-- ----------------------------
INSERT INTO `menu_permission` VALUES ('analysis', '报表分析', '/analysis');
INSERT INTO `menu_permission` VALUES ('configuration', '报警配置', '/configuration');
INSERT INTO `menu_permission` VALUES ('control', '设备控制', '/control');
INSERT INTO `menu_permission` VALUES ('daily', '日报', '/daily');
INSERT INTO `menu_permission` VALUES ('history', '历史数据', '/history');
INSERT INTO `menu_permission` VALUES ('logger', '日志管理', '/logger');
INSERT INTO `menu_permission` VALUES ('maintaining', '设备维护', '/maintaining');
INSERT INTO `menu_permission` VALUES ('map', '地图监控', '/map');
INSERT INTO `menu_permission` VALUES ('monthly', '月报', '/monthly');
INSERT INTO `menu_permission` VALUES ('processing', '报警处理', '/processing');
INSERT INTO `menu_permission` VALUES ('realTime', '实时数据', '/realTime');
INSERT INTO `menu_permission` VALUES ('role', '角色权限管理', '/role');
INSERT INTO `menu_permission` VALUES ('surveillance', '视频监控', '/surveillance');
INSERT INTO `menu_permission` VALUES ('user', '用户管理', '/user');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('8aa7945367a7771c0167a7772a520000', '经理', '这是经理权限的角色');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` varchar(255) NOT NULL,
  `menuPermission_name` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe9unnvv5mcgmrypd3t5nvhd26` (`menuPermission_name`),
  KEY `FKqyvxw2gg2qk0wld3bqfcb58vq` (`role_id`),
  CONSTRAINT `FKe9unnvv5mcgmrypd3t5nvhd26` FOREIGN KEY (`menuPermission_name`) REFERENCES `menu_permission` (`name`),
  CONSTRAINT `FKqyvxw2gg2qk0wld3bqfcb58vq` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b230001', 'map', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b250002', 'realTime', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b260003', 'history', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b280004', 'control', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b2d0005', 'maintaining', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b300006', 'surveillance', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b330007', 'processing', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b370008', 'configuration', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b390009', 'daily', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b3b000a', 'monthly', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `role_menu` VALUES ('8aa7945367a7771c0167a7772b3c000b', 'analysis', '8aa7945367a7771c0167a7772a520000');

-- ----------------------------
-- Table structure for role_menu_datapermissions
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_datapermissions`;
CREATE TABLE `role_menu_datapermissions` (
  `RoleMenu_id` varchar(255) NOT NULL,
  `dataPermissions_id` varchar(255) NOT NULL,
  PRIMARY KEY (`RoleMenu_id`,`dataPermissions_id`),
  KEY `FKryialp4pf3nxpuk7xfatuicmm` (`dataPermissions_id`),
  CONSTRAINT `FKhsjwechqfeu1hfit54q9vp45n` FOREIGN KEY (`RoleMenu_id`) REFERENCES `role_menu` (`id`),
  CONSTRAINT `FKryialp4pf3nxpuk7xfatuicmm` FOREIGN KEY (`dataPermissions_id`) REFERENCES `data_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu_datapermissions
-- ----------------------------
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b370008', 'configuration:add');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b370008', 'configuration:edit');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b370008', 'configuration:remove');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b390009', 'daily:export');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b2d0005', 'maintaining:edit');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b2d0005', 'maintaining:export');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b3b000a', 'monthly:export');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b330007', 'processing:edit');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b330007', 'processing:export');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b300006', 'surveillance:edit');
INSERT INTO `role_menu_datapermissions` VALUES ('8aa7945367a7771c0167a7772b300006', 'surveillance:export');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `cell_phone` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('liucheng', '123456', '17671792752', '研发中心', '男', '刘成', ' 技术', '8aa7945367a7771c0167a7772a520000');
INSERT INTO `user` VALUES ('pengshijie', '123456', '18670687350', '研发中心', '男', '彭诗杰', ' 技术', '8aa7945367a7771c0167a7772a520000');
