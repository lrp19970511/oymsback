/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : oyms

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-10-28 17:23:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodName` varchar(255) DEFAULT NULL,
  `goodtype` varchar(255) DEFAULT NULL,
  `goodprice` float DEFAULT NULL,
  `goodnum` bigint(20) DEFAULT NULL,
  `gooddesc` varchar(255) DEFAULT NULL,
  `goodImgUrl` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('37', '的', '女装', '1', '1', '', '', '0', '2019-10-28 00:00:00');
INSERT INTO `goods` VALUES ('38', 'd', '女装', '1', '1', '', '', '0', '2019-10-28 00:00:00');
INSERT INTO `goods` VALUES ('39', '的', '女装', '1', '1', '', '', '0', '2019-10-28 02:28:01');
INSERT INTO `goods` VALUES ('40', 'd', '女装', '1', '1', '', '', '0', '2019-10-28 02:29:23');
INSERT INTO `goods` VALUES ('41', '等等', '女装', '1', '1', '', '', '0', '2019-10-28 10:30:53');
INSERT INTO `goods` VALUES ('42', '等等', '女装', '1', '1', '发', 'http://lrplt.cn-bj.ufileos.com/017a4207-7290-409c-948a-6f5e2c04494c.png?UCloudPublicKey=TOKEN_2e336c63-c95d-4ea9-b750-e8342bcd185f&Signature=OdTw5Ey8jVuz%2FVU7fnRtVTHyH%2B4%3D&Expires=1887589957', '0', '2019-10-28 10:32:38');
INSERT INTO `goods` VALUES ('43', 'd', '女装', '1', '1', '', '', '0', '2019-10-28 16:52:25');
INSERT INTO `goods` VALUES ('44', 'd', '女装', '2', '2', '', '', '0', '2019-10-28 16:54:24');
INSERT INTO `goods` VALUES ('45', 'd', '女装', '1', '1', '', '', '0', '2019-10-28 16:54:47');

-- ----------------------------
-- Table structure for `goodtype`
-- ----------------------------
DROP TABLE IF EXISTS `goodtype`;
CREATE TABLE `goodtype` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `good_type` varchar(255) NOT NULL,
  `sub_type` varchar(255) NOT NULL,
  `isdelete` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodtype
-- ----------------------------
INSERT INTO `goodtype` VALUES ('1', '衣服', '发', '1', null);
INSERT INTO `goodtype` VALUES ('2', '衣服', '发', '1', null);
INSERT INTO `goodtype` VALUES ('3', '帆帆帆帆', '多大', '1', null);
INSERT INTO `goodtype` VALUES ('4', '实打实打算', '阿凡达实打实', '1', null);
INSERT INTO `goodtype` VALUES ('5', '衣服', '衬衫', '0', null);
INSERT INTO `goodtype` VALUES ('6', '衣服', 'dd', '0', null);
INSERT INTO `goodtype` VALUES ('7', '衣服', 'ddss', '0', null);
INSERT INTO `goodtype` VALUES ('8', '衣服', 'ddssg', '0', null);
INSERT INTO `goodtype` VALUES ('9', '帽子', 'fff', '0', null);
INSERT INTO `goodtype` VALUES ('10', '帽子', 'dd', '0', null);
INSERT INTO `goodtype` VALUES ('11', '衣服', 'dddd', '0', null);
INSERT INTO `goodtype` VALUES ('12', '衣服', 'd', '0', '2019-10-28 16:54:53');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `userPassword` varchar(100) DEFAULT NULL,
  `userImg` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'admin', '12345678', 'http://lrplt.cn-bj.ufileos.com/2d2b52c6-77e0-4b9c-a697-851d09e1b88e.png?UCloudPublicKey=TOKEN_2e336c63-c95d-4ea9-b750-e8342bcd185f&Signature=Ps7cIwkUX9%2BomcLMwmVDYO7W3yc%3D&Expires=1887416181', '2019-10-26 00:00:00');
INSERT INTO `user` VALUES ('7', 'admi', '12345678', '', '2019-10-26 00:00:00');
INSERT INTO `user` VALUES ('8', 'adm', '12345678', 'http://lrplt.cn-bj.ufileos.com/ed0a5cf2-5022-4f50-a3d5-9903145861c4.png?UCloudPublicKey=TOKEN_2e336c63-c95d-4ea9-b750-e8342bcd185f&Signature=GE9hnm6sKs719BFBjaSPj1FCkOk%3D&Expires=1887420065', '2019-10-26 00:00:00');
INSERT INTO `user` VALUES ('9', 'fff', '12345678', '', '2019-10-28 16:50:54');
INSERT INTO `user` VALUES ('10', 'fff', '12345678', '', '2019-10-28 16:50:54');
INSERT INTO `user` VALUES ('11', '12345', '12345678', '', '2019-10-28 16:51:36');
INSERT INTO `user` VALUES ('12', '12357', '12345678', '', '2019-10-28 16:52:02');
