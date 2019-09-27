/*
Navicat MySQL Data Transfer

Source Server         : gaoxiong
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : db_account

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-09-27 12:00:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_tbl
-- ----------------------------
DROP TABLE IF EXISTS `account_tbl`;
CREATE TABLE `account_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_tbl
-- ----------------------------
INSERT INTO `account_tbl` VALUES ('1', '1001', '5380');
INSERT INTO `account_tbl` VALUES ('2', '1002', '10000');
INSERT INTO `account_tbl` VALUES ('3', '1003', '9730');
INSERT INTO `account_tbl` VALUES ('4', '1004', '9680');
INSERT INTO `account_tbl` VALUES ('5', '1005', '9550');
INSERT INTO `account_tbl` VALUES ('6', '1006', '9490');
INSERT INTO `account_tbl` VALUES ('7', '1007', '9405');
INSERT INTO `account_tbl` VALUES ('8', '1008', '9320');
INSERT INTO `account_tbl` VALUES ('9', '1009', '9235');
INSERT INTO `account_tbl` VALUES ('10', '1010', '9150');
INSERT INTO `account_tbl` VALUES ('11', '1011', '9065');
INSERT INTO `account_tbl` VALUES ('12', '1012', '8980');

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=248 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
