/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : monitor_sewage

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-18 11:01:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for history_data
-- ----------------------------
DROP TABLE IF EXISTS `history_data`;
CREATE TABLE `history_data` (
  `id` varchar(255) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `value` decimal(19,2) DEFAULT NULL,
  `factor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKawi99mm0x2qinf3i7bcx7w6jv` (`factor_id`),
  CONSTRAINT `FKawi99mm0x2qinf3i7bcx7w6jv` FOREIGN KEY (`factor_id`) REFERENCES `monitor_factor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history_data
-- ----------------------------

-- ----------------------------
-- Table structure for monitor_factor
-- ----------------------------
DROP TABLE IF EXISTS `monitor_factor`;
CREATE TABLE `monitor_factor` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `max_value` decimal(19,2) DEFAULT NULL,
  `min_value` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sensor_id` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `sewageArea_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKay6m4729brk9iqj7150tam6nl` (`sewageArea_code`),
  CONSTRAINT `FKay6m4729brk9iqj7150tam6nl` FOREIGN KEY (`sewageArea_code`) REFERENCES `sewage_area` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monitor_factor
-- ----------------------------
INSERT INTO `monitor_factor` VALUES ('8aa7945367bb85490167bb8557720000', 'pH', '9.00', '6.00', 'PH', '001', null, 'JZ000000000001');
INSERT INTO `monitor_factor` VALUES ('8aa7945367bb85490167bb8557b80001', 'cod', '60.00', null, 'COD', '011', 'mg/L', 'JZ000000000001');
INSERT INTO `monitor_factor` VALUES ('8aa7945367bb85490167bb8558020002', 'nH3N', '15.00', null, '氨氮', '060', 'mg/L', 'JZ000000000001');
INSERT INTO `monitor_factor` VALUES ('8aa7945367bb85490167bb8558330003', 'tP', '0.50', null, '总磷', '101', 'mg/L', 'JZ000000000001');
INSERT INTO `monitor_factor` VALUES ('8aa7945367bb85490167bb85584c0004', 'sS', '70.00', null, '悬浮物', '003', 'mg/L', 'JZ000000000001');
INSERT INTO `monitor_factor` VALUES ('8aa7945367bb85490167bb8558650005', 'flow', null, null, '流量', 'B01', 'l/s', 'JZ000000000001');

-- ----------------------------
-- Table structure for realtime_data
-- ----------------------------
DROP TABLE IF EXISTS `realtime_data`;
CREATE TABLE `realtime_data` (
  `id` varchar(255) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `value` decimal(19,2) DEFAULT NULL,
  `factor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcg4qkefrbq9arifpevhkq8fpj` (`factor_id`),
  CONSTRAINT `FKcg4qkefrbq9arifpevhkq8fpj` FOREIGN KEY (`factor_id`) REFERENCES `monitor_factor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of realtime_data
-- ----------------------------

-- ----------------------------
-- Table structure for sewage_area
-- ----------------------------
DROP TABLE IF EXISTS `sewage_area`;
CREATE TABLE `sewage_area` (
  `code` varchar(255) NOT NULL,
  `lat` decimal(19,2) DEFAULT NULL,
  `lon` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sewage_area
-- ----------------------------
INSERT INTO `sewage_area` VALUES ('JZ000000000001', '30.71', '114.05', '东西湖废水监测点', null, null, null);
