/*
Navicat MySQL Data Transfer

Source Server         : Ronin
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : bussystem

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-03-24 17:07:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `busNO` varchar(255) NOT NULL COMMENT '汽车编号',
  `bustype` varchar(255) DEFAULT NULL COMMENT '汽车车型',
  `buydate` date DEFAULT NULL COMMENT '购买时间',
  `usedate` date DEFAULT NULL COMMENT '使用时间',
  `seatnum` int(255) DEFAULT NULL COMMENT '汽车座位数量',
  `TV` varchar(255) DEFAULT NULL COMMENT '有无电视',
  `aircondition` varchar(255) DEFAULT NULL COMMENT '有无空调',
  `busmemo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`busNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES ('04f00461-eb5d-4359-ac94-dddac4005a2a', '大型', '2017-03-01', '2017-03-14', '50', '是', '是', 'rtyiurit');
INSERT INTO `bus` VALUES ('578aa3ec-0d86-45be-957a-3efebb29fb1d', '大型', '2017-03-03', '2017-03-17', '75', '是', '是', '123');
INSERT INTO `bus` VALUES ('96d24cbd-91ca-4467-b5ec-41d873f38c21', '小型', '2008-12-13', '2009-02-23', '35', '是', '否', '啦啦啦啦');
INSERT INTO `bus` VALUES ('eba06668-8302-4466-92fd-a9edf84cdcdf', '中型', '2017-04-05', '2017-05-06', '65', '是', '是', '顶顶顶顶');

-- ----------------------------
-- Table structure for busline
-- ----------------------------
DROP TABLE IF EXISTS `busline`;
CREATE TABLE `busline` (
  `buslineNO` varchar(255) NOT NULL COMMENT '线路编号',
  `busNO` varchar(255) NOT NULL COMMENT '汽车编号',
  `departcity` varchar(255) DEFAULT NULL COMMENT '起始城市',
  `arrivalcity` varchar(255) DEFAULT NULL COMMENT '到达城市',
  `departdate` time DEFAULT NULL COMMENT '发车时间',
  `arrivaldate` time DEFAULT NULL COMMENT '到达时间',
  `buslinememo` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`buslineNO`,`busNO`),
  KEY `buslineNO` (`buslineNO`),
  KEY `3` (`busNO`),
  CONSTRAINT `3` FOREIGN KEY (`busNO`) REFERENCES `bus` (`busNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of busline
-- ----------------------------
INSERT INTO `busline` VALUES ('4b453356-4c75-414c-a9b8-0a2d0358af5a', 'eba06668-8302-4466-92fd-a9edf84cdcdf', '昆明', '西藏', '05:07:00', '22:46:00', '路远');
INSERT INTO `busline` VALUES ('a6a1f886-1741-44ca-97b2-8f72ff4e4436', '04f00461-eb5d-4359-ac94-dddac4005a2a', '10栋', '北区', '10:00:00', '11:00:00', '66699');
INSERT INTO `busline` VALUES ('d1e60666-3c1c-4624-93ac-8bafff53752e', '96d24cbd-91ca-4467-b5ec-41d873f38c21', '吉安', '南昌', '05:50:00', '11:34:00', 'qwerqwerqwer');

-- ----------------------------
-- Table structure for busticket
-- ----------------------------
DROP TABLE IF EXISTS `busticket`;
CREATE TABLE `busticket` (
  `ticketNO` varchar(255) NOT NULL COMMENT '车票编号',
  `buslineNO` varchar(255) NOT NULL COMMENT '线路编号',
  `departcity` varchar(255) DEFAULT NULL COMMENT '出发城市',
  `arrivalcity` varchar(255) DEFAULT NULL COMMENT '到达城市',
  `ticketbuydate` date DEFAULT NULL COMMENT '购票日期',
  `ticketusedate` date DEFAULT NULL COMMENT '使用日期',
  `departtime` time DEFAULT NULL COMMENT '发车时间',
  `arrivaltime` time DEFAULT NULL COMMENT '到达时间',
  `ticketprice` double(10,2) DEFAULT NULL COMMENT '车票价格',
  `ticketmemo` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ticketNO`,`buslineNO`),
  KEY `1` (`buslineNO`),
  CONSTRAINT `1` FOREIGN KEY (`buslineNO`) REFERENCES `busline` (`buslineNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of busticket
-- ----------------------------
INSERT INTO `busticket` VALUES ('2380b898-2e04-4812-881d-db8918e5e139', '4b453356-4c75-414c-a9b8-0a2d0358af5a', '昆明', '西藏', '2017-03-01', '2018-03-31', '05:07:00', '22:46:00', '324.00', '222222111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` varchar(255) NOT NULL COMMENT '管理员编号',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `permission` varchar(5) NOT NULL COMMENT '管理员权限',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00852993-5821-4e55-b064-a71f60a329f8', 'admin', 'admin', '普通管理员');
INSERT INTO `user` VALUES ('6662a850-913e-407a-a647-9f0f6a73c769', 'Ronin', '59233', '超级管理员');
INSERT INTO `user` VALUES ('68852c19-c30e-41e3-a0dc-7c25cc009b92', '高威', '1234567', '普通管理员');
INSERT INTO `user` VALUES ('ba27b64b-4258-4ac2-bcc5-51dca10fc813', '杨涛', 'yangtaosb', '普通管理员');
INSERT INTO `user` VALUES ('ec3f82a3-e3af-437c-adf7-f3abca370086', 'qwer', '1234567', '普通管理员');
