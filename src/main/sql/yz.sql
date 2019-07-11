/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : yz

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2019-07-12 00:40:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `driver_information`
-- ----------------------------
DROP TABLE IF EXISTS `driver_information`;
CREATE TABLE `driver_information` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自动递增的唯一索引',
  `name` varchar(20) NOT NULL COMMENT '驾驶员姓名',
  `nationality` varchar(50) DEFAULT NULL COMMENT '驾驶员国籍',
  `phone_number` char(11) NOT NULL COMMENT '驾驶员手机号码',
  `marital_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '婚姻状态',
  `person_id` char(18) NOT NULL COMMENT '身份证号',
  `company` varchar(100) NOT NULL COMMENT '所属的公司',
  `sex` varchar(4) NOT NULL COMMENT '性别',
  `foreign_language_ability` varchar(50) DEFAULT NULL COMMENT '外语能力',
  `birthday` date NOT NULL COMMENT '出生日期',
  `education` varchar(20) DEFAULT NULL COMMENT '教育程度',
  `photo` varchar(200) NOT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver_information
-- ----------------------------
INSERT INTO `driver_information` VALUES ('1', '张四', '中国', '13508253588', '0', '513022199602016695', 'yz', '男', '好', '1996-01-21', '本科', 'E:\\ideaproject\\demo\\src\\main\\webapp\\driverImg\\8a9a55f6-f441-4d0e-9883-c949c4ce18d2.');
INSERT INTO `driver_information` VALUES ('101', '张山山', '中国', '13508253588', '0', '513022199602016697', 'yz', '女', 'good', '2019-06-25', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('102', '张山1', '中国', '13508253588', '1', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('103', '张山2', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '女', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('104', '张山3', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('105', '张山4', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('106', '张山5', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('107', '张山6', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('108', '张山7', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('109', '张山8', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('110', '张山9', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('111', '张山10', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('112', '张山11', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('113', '张山12', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('114', '张山13', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('115', '张山14', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('116', '张山15', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('117', '张山16', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('118', '张山17', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('119', '张山18', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('120', '张山19', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('121', '张山20', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('122', '张山21', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('123', '张山22', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('124', '张山23', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('125', '张山24', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('126', '张山25', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('127', '张山26', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('128', '张山27', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('129', '张山28', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('130', '张山29', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('131', '张山30', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('132', '张山31', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('133', '张山32', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('134', '张山33', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('135', '张山34', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('136', '张山35', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('137', '张山36', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('138', '张山37', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('139', '张山38', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('140', '张山39', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('141', '张山40', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('142', '张山41', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('143', '张山42', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('144', '张山43', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('145', '张山44', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('146', '张山45', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('147', '张山46', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('148', '张山47', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('149', '张山48', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('150', '张山49', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('151', '张山50', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('152', '张山51', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('153', '张山52', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('154', '张山53', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('155', '张山54', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('156', '张山55', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('157', '张山56', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('158', '张山57', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('159', '张山58', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('160', '张山59', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('161', '张山60', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('162', '张山61', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('163', '张山62', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('164', '张山63', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('165', '张山64', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('166', '张山65', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('167', '张山66', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('168', '张山67', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('169', '张山68', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('170', '张山69', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('171', '张山70', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('172', '张山71', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('173', '张山72', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('174', '张山73', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('175', '张山74', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('176', '张山75', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('177', '张山76', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('178', '张山77', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('179', '张山78', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('180', '张山79', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('181', '张山80', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('182', '张山81', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('183', '张山82', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('184', '张山83', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('185', '张山84', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('186', '张山85', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('187', '张山86', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('188', '张山87', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('189', '张山88', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('190', '张山89', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('191', '张山90', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('192', '张山91', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('193', '张山92', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('194', '张山93', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('195', '张山94', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('196', '张山95', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('197', '张山96', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('198', '张山97', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('199', '张山98', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('200', '张山99', '中国', '13508253588', '0', '513022XXXXXXXXX', 'yz', '男', 'good', '2019-06-27', '本科', 'c:\\');
INSERT INTO `driver_information` VALUES ('211', 'rwer', 'rwer', 'rewrewrewr', '0', 'rwerwerwer', 'rwe', '男', 'rew', '1996-01-31', 'rew', 'D:\\demo\\src\\main\\webapp\\driverImg\\79d53e74-0763-4871-9add-1edbcd33f076.');
INSERT INTO `driver_information` VALUES ('212', 'zxc', '12345', 'zxc', '0', 'xcv', '1234', '男', '234', '1666-01-04', '234', 'D:\\demo\\src\\main\\webapp\\driverImg\\713caa05-4761-47d7-9c39-e119fb9c2f8c.jpg');
INSERT INTO `driver_information` VALUES ('213', '1234', '2345', 'qwerty', '0', '123', '23454', '男', '324354', '1996-01-31', '234354', 'D:\\demo\\src\\main\\webapp\\driverImg\\745e666c-7d48-4988-bcb4-f43da226869f.');
INSERT INTO `driver_information` VALUES ('214', '张飞飞', '中国', '13508253588', '0', '513022199602016691', 'yz', '女', '', '1999-09-08', '', 'D:\\demo\\src\\main\\webapp\\driverImg\\ce346160-5e03-43df-96b4-8c06eb1ce9f7.');
INSERT INTO `driver_information` VALUES ('215', '正则', '正则', '13508253588', '0', '513022199602016694', 'yz', '男', '', '1996-01-31', '', 'D:\\demo\\src\\main\\webapp\\driverImg\\3b69c04a-2eab-432e-8e39-bf6c3046da7a.');
INSERT INTO `driver_information` VALUES ('216', '孙鹏', '中国', '18288888888', '0', '555555199308125235', '撒AS', '女', '', '2019-06-29', 'SDASD', 'D:\\demo\\src\\main\\webapp\\driverImg\\a9c50f96-0368-400e-92d7-17b6d2266ca4.');
INSERT INTO `driver_information` VALUES ('217', '寅个人', '中国', '18288888888', '0', '555555199912307896', '打算', '男', '', '2019-06-30', '阿萨德', 'D:\\demo\\src\\main\\webapp\\driverImg\\7d5c4afc-37fc-40be-9077-dfdc0eccb7ff.');

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('218');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'user');
INSERT INTO `role` VALUES ('3', 'other');

-- ----------------------------
-- Table structure for `url`
-- ----------------------------
DROP TABLE IF EXISTS `url`;
CREATE TABLE `url` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) NOT NULL COMMENT '请求的路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of url
-- ----------------------------
INSERT INTO `url` VALUES ('1', '/admin');
INSERT INTO `url` VALUES ('2', '/user');
INSERT INTO `url` VALUES ('3', '/login');

-- ----------------------------
-- Table structure for `url_role`
-- ----------------------------
DROP TABLE IF EXISTS `url_role`;
CREATE TABLE `url_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) NOT NULL COMMENT '请求路径，对应url表',
  `role` varchar(20) NOT NULL COMMENT '角色名称，对应角色表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of url_role
-- ----------------------------
INSERT INTO `url_role` VALUES ('2', '/admin', 'admin');
INSERT INTO `url_role` VALUES ('3', '/user', 'user');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_info_id` int(11) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, '123456', 'root', 'admin');
INSERT INTO `user` VALUES ('2', null, '123456', 'zfd', 'admin');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名，对应用户表',
  `role` varchar(20) NOT NULL COMMENT '角色，对应role表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'root', 'ROLE_admin');
INSERT INTO `user_role` VALUES ('2', 'zfd', 'user');
