/*
Navicat MySQL Data Transfer

Source Server         : connect
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : sgmopower

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-14 10:41:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(42) NOT NULL,
  `admpsw` varchar(255) DEFAULT NULL,
  `admname` varchar(255) NOT NULL,
  `admlevel` int(1) NOT NULL COMMENT '0 超级管理 1 普通管理',
  `stationid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for charger
-- ----------------------------
DROP TABLE IF EXISTS `charger`;
CREATE TABLE `charger` (
  `id` varchar(42) NOT NULL COMMENT 'chargerID',
  `stationid` varchar(42) DEFAULT NULL COMMENT 'stationID',
  `powerleft` float(30,5) DEFAULT NULL COMMENT 'powerLeft',
  `chargerstatus` varchar(255) DEFAULT NULL COMMENT '0 ?? 1 ??? 2 ??? ',
  `chargercapacity` float(30,5) DEFAULT NULL COMMENT 'chargerCapacity',
  `batterytype` varchar(255) DEFAULT NULL COMMENT 'batteryType',
  `deploydate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'deployDate',
  `manufacturer` varchar(255) DEFAULT NULL COMMENT 'manufacturer',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TbCharger';

-- ----------------------------
-- Records of charger
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(42) NOT NULL,
  `loginname` varchar(255) DEFAULT NULL COMMENT '登录名',
  `idcard` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `sex` int(1) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `loginpass` varchar(255) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `viplevel` int(1) DEFAULT '0' COMMENT '0-5等级，越来越高',
  `accountbalance` float(30,5) DEFAULT '0.00000' COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for deliver
-- ----------------------------
DROP TABLE IF EXISTS `deliver`;
CREATE TABLE `deliver` (
  `id` varchar(42) NOT NULL,
  `delivername` varchar(255) DEFAULT NULL,
  `deliverstatus` int(1) DEFAULT NULL COMMENT '0 空闲 1配送中 2 离岗',
  `deliverphone` int(11) DEFAULT NULL,
  `stationid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deliver
-- ----------------------------

-- ----------------------------
-- Table structure for orderform
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `id` varchar(42) NOT NULL,
  `userid` varchar(42) NOT NULL,
  `deliverid` varchar(42) DEFAULT NULL COMMENT '接单时间',
  `chargerid` varchar(42) DEFAULT NULL COMMENT '充电桩ID',
  `lng` float(15,8) DEFAULT NULL,
  `lat` float(15,8) DEFAULT NULL,
  `ordercost` float(30,5) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL COMMENT '下单时间',
  `powervalue` float(30,5) DEFAULT NULL,
  `arrivetime` datetime NOT NULL COMMENT '配送到达时间（实际）',
  `leavedtime` datetime DEFAULT NULL COMMENT '客户预约离开时间',
  `orderstatus` int(1) DEFAULT NULL COMMENT '订单状态（0 未接单 1已接单未配送 2已接单已配送 3已送达 4订单完成）',
  `commentorder` int(1) DEFAULT NULL COMMENT '评价（0 -4 ）',
  `contacttelnum` int(11) DEFAULT NULL COMMENT '客户联系电话',
  `locationdes` varchar(255) DEFAULT NULL COMMENT '下单地点描述',
  `licenseplate` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL COMMENT '其他说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `id` varchar(42) NOT NULL,
  `stationname` varchar(255) DEFAULT NULL,
  `lng` float(15,8) DEFAULT NULL,
  `lat` float(15,8) DEFAULT NULL,
  `stationlocation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('4028881e5e7dfbdd015e7e2336c00001', '高培站点', '116.34660339', '40.05209732', '北京市海淀区西小口路18');
INSERT INTO `station` VALUES ('4028881e5e7dfbdd015e7e2417760002', '昌盛站点', '116.38950348', '39.91004562', '北京市西城区北京昌盛大厦');
INSERT INTO `station` VALUES ('4028881e5e7dfbdd015e7e250eb70003', '北七家站点', '116.47193909', '40.13924026', '北京市昌平区未来城北二街');
