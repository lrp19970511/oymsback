/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : oyms

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-30 02:25:31
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

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
INSERT INTO `goods` VALUES ('46', 'rrr', '女装', '2', '2', '', '', '0', '2019-10-29 08:55:37');
INSERT INTO `goods` VALUES ('47', 'dd', '女装', '1', '1', '', '', '0', '2019-10-29 10:06:23');
INSERT INTO `goods` VALUES ('48', 'f', '女装', '1', '1', '', 'http://lrplt.cn-bj.ufileos.com/1b0d60a5-63a4-4c90-a6c4-4e07e588e18a.png?UCloudPublicKey=TOKEN_2e336c63-c95d-4ea9-b750-e8342bcd185f&Signature=LhmwUoY%2BuqiBuXDh9FuHI40keRk%3D&Expires=1887677061', '0', '2019-10-29 10:46:39');
INSERT INTO `goods` VALUES ('49', 'd', '女装', '1', '1', '', '', '0', '2019-10-29 14:44:18');
INSERT INTO `goods` VALUES ('50', '1', '女装', '1', '1', '', '', '0', '2019-10-29 16:18:54');

-- ----------------------------
-- Table structure for `goodtype`
-- ----------------------------
DROP TABLE IF EXISTS `goodtype`;
CREATE TABLE `goodtype` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `cname` varchar(255) NOT NULL,
  `isdelete` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `goodtype_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `parenttype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodtype
-- ----------------------------
INSERT INTO `goodtype` VALUES ('19', '8', 'dd', '0', '2019-10-30 01:43:04');
INSERT INTO `goodtype` VALUES ('20', '1', '发', '0', '2019-10-30 01:46:31');
INSERT INTO `goodtype` VALUES ('21', '1', '发给', '0', '2019-10-30 01:46:40');
INSERT INTO `goodtype` VALUES ('22', '9', 'f\'d\'d', '0', '2019-10-30 02:23:01');

-- ----------------------------
-- Table structure for `parenttype`
-- ----------------------------
DROP TABLE IF EXISTS `parenttype`;
CREATE TABLE `parenttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) NOT NULL,
  `isdelete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pname` (`pname`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parenttype
-- ----------------------------
INSERT INTO `parenttype` VALUES ('1', '衣服', '0');
INSERT INTO `parenttype` VALUES ('2', '帽子', '0');
INSERT INTO `parenttype` VALUES ('3', '鞋子', '0');
INSERT INTO `parenttype` VALUES ('5', 'ddd', '0');
INSERT INTO `parenttype` VALUES ('6', 'sss', '0');
INSERT INTO `parenttype` VALUES ('8', '方法', '0');
INSERT INTO `parenttype` VALUES ('9', '分发给', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员');
INSERT INTO `role` VALUES ('2', '普通管理员');
INSERT INTO `role` VALUES ('3', '普通用户');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'admin', '12345678', 'http://lrplt.cn-bj.ufileos.com/2d2b52c6-77e0-4b9c-a697-851d09e1b88e.png?UCloudPublicKey=TOKEN_2e336c63-c95d-4ea9-b750-e8342bcd185f&Signature=Ps7cIwkUX9%2BomcLMwmVDYO7W3yc%3D&Expires=1887416181', '2019-10-26 00:00:00');
INSERT INTO `user` VALUES ('7', 'admi', '12345678', '', '2019-10-26 00:00:00');
INSERT INTO `user` VALUES ('8', 'adm', '12345678', 'http://lrplt.cn-bj.ufileos.com/ed0a5cf2-5022-4f50-a3d5-9903145861c4.png?UCloudPublicKey=TOKEN_2e336c63-c95d-4ea9-b750-e8342bcd185f&Signature=GE9hnm6sKs719BFBjaSPj1FCkOk%3D&Expires=1887420065', '2019-10-26 00:00:00');
INSERT INTO `user` VALUES ('9', 'fff', '12345678', '', '2019-10-28 16:50:54');
INSERT INTO `user` VALUES ('11', '12345', '12345678', '', '2019-10-28 16:51:36');
INSERT INTO `user` VALUES ('12', '12357', '12345678', '', '2019-10-28 16:52:02');
INSERT INTO `user` VALUES ('13', 'admi1', '12345678', '', '2019-10-29 09:10:50');
INSERT INTO `user` VALUES ('14', 'adm1', '12345678', '', '2019-10-29 09:12:49');
