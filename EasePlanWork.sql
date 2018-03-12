/*
 Navicat MySQL Data Transfer

 Source Server         : NetEaseLearn_local
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : EasePlanWork

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 12/03/2018 14:34:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_commodity
-- ----------------------------
DROP TABLE IF EXISTS `t_commodity`;
CREATE TABLE `t_commodity` (
  `uid` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `owner_uid` int(11) DEFAULT NULL,
  `text` varchar(1050) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`,`version`) USING BTREE,
  KEY `user_uid` (`owner_uid`),
  KEY `commodityid` (`uid`),
  KEY `version` (`version`),
  CONSTRAINT `owner_id_fk` FOREIGN KEY (`owner_uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_commodity
-- ----------------------------
BEGIN;
INSERT INTO `t_commodity` VALUES (1, 1, 'Clothes', 'Clothes!', 200.00, 2, 'This is clothes.', 5, '/images/clothes_001.jpeg');
INSERT INTO `t_commodity` VALUES (1, 2, 'Clothes', 'Clothes!!', 108.50, 2, 'This is clothes 2.', 5, '/images/clothes_001.jpeg');
INSERT INTO `t_commodity` VALUES (1, 3, 'Clothes', 'Clothes!!!', 109.50, 2, 'This is clothes 3.', 5, '/images/clothes_001.jpeg');
INSERT INTO `t_commodity` VALUES (1, 4, 'Clothes', 'Clothes!!!!', 300.00, 2, 'This is clothes 3.', 5, '/images/clothes_001.jpeg');
INSERT INTO `t_commodity` VALUES (1, 5, 'Clothes', '2333', 3223.00, 2, 'qwertyui', 5, '/images/clothes_001.jpeg');
INSERT INTO `t_commodity` VALUES (1, 6, 'Clothes', '2333', 3223.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 7, 'Clothes', '2333', 3223.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 8, 'Clothes', '2333', 3223.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 9, 'Clothes', '2333', 3223.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 10, 'Clothes', '2333', 3223.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 11, 'Clothes', '2333', 3223.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 12, 'Clothes', '2333', 322.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 13, 'Clothes', '2333', 322.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (1, 14, 'Clothes', '2333', 322.00, 2, 'qwertyui', 5, '/images/clothes_002.jpeg');
INSERT INTO `t_commodity` VALUES (2, 1, 'Cup', 'Cup!', 50.40, 2, 'This is cup.', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 2, 'Cup', 'Cup!!', 50.60, 2, 'This is cup 2.', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 3, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 4, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 5, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 6, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 7, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 8, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 9, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 10, '1', '4', 5.00, 2, '7', 5, '/images/cup_001.jpg');
INSERT INTO `t_commodity` VALUES (2, 11, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 12, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 13, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 14, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 15, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 16, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 17, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 18, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 19, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 20, '1', '4', 5.00, 2, '7', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 21, 'Cup', 'Cup! new version!', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 22, 'Cup', 'Cup! new version!', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 23, 'Cup', 'Cup!! new new version', 50.60, 2, 'This is cup 2.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 24, 'Cup', 'Cup! new new', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 25, 'Cup', 'Cup! version25', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 26, 'Cup', 'Cup!', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 27, 'Cup', 'Cup!', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 28, 'Cup', 'Cup!', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 29, 'Cup', 'Cup! v29', 50.40, 2, 'This is cup.', 5, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 30, 'Cup', 'Cup!! v29', 50.60, 2, 'This is cup 2.', 0, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (2, 31, 'Cup', 'Cup!! v29', 50.60, 2, 'This is cup 2.新版本 试验', 0, '/images/cup_002.jpg');
INSERT INTO `t_commodity` VALUES (3, 1, '书书书', '这是一本书', 123.00, 2, '这是一本书的正文', 1, '/images/book_001.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `t_shoppingcart`;
CREATE TABLE `t_shoppingcart` (
  `user_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`commodity_id`),
  KEY `commodity_id_fk` (`commodity_id`),
  CONSTRAINT `commodity_id_fk` FOREIGN KEY (`commodity_id`) REFERENCES `t_commodity` (`uid`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shoppingcart
-- ----------------------------
BEGIN;
INSERT INTO `t_shoppingcart` VALUES (1, 3, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_trade
-- ----------------------------
DROP TABLE IF EXISTS `t_trade`;
CREATE TABLE `t_trade` (
  `batch_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `commodity_version` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `time_stamp` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`batch_id`,`commodity_id`),
  KEY `trade_commodity_version` (`commodity_version`),
  KEY `commodity_id_version_fk` (`commodity_id`,`commodity_version`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `buyer_id` FOREIGN KEY (`buyer_id`) REFERENCES `t_user` (`uid`),
  CONSTRAINT `commodity_id_version_fk` FOREIGN KEY (`commodity_id`, `commodity_version`) REFERENCES `t_commodity` (`uid`, `version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_trade
-- ----------------------------
BEGIN;
INSERT INTO `t_trade` VALUES (1, 1, 3, 1, 3, '2018-03-10 19:16:58');
INSERT INTO `t_trade` VALUES (1, 2, 2, 1, 2, '2018-03-10 19:16:58');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `usertype` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'buyer', '37254660e226ea65ce6f1efd54233424', b'0');
INSERT INTO `t_user` VALUES (2, 'seller', '981c57a5cfb0f868e064904b8745766f', b'1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
