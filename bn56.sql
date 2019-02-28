/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : bn56

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2018-04-17 21:11:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='超级管理员';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `t_bj`
-- ----------------------------
DROP TABLE IF EXISTS `t_bj`;
CREATE TABLE `t_bj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bjName` varchar(100) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='班级';

-- ----------------------------
-- Records of t_bj
-- ----------------------------
INSERT INTO `t_bj` VALUES ('1', '一班');
INSERT INTO `t_bj` VALUES ('2', '二班');

-- ----------------------------
-- Table structure for `t_gg`
-- ----------------------------
DROP TABLE IF EXISTS `t_gg`;
CREATE TABLE `t_gg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `pic` varchar(100) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `showDate` datetime DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='公告';

-- ----------------------------
-- Records of t_gg
-- ----------------------------
INSERT INTO `t_gg` VALUES ('1', '今天要下雨', 'upload/20180417/152396819165888.jpg', '今天要下雨今天要下雨今天要下雨今天要下雨', '2018-04-17 00:00:00');

-- ----------------------------
-- Table structure for `t_kc`
-- ----------------------------
DROP TABLE IF EXISTS `t_kc`;
CREATE TABLE `t_kc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kcName` varchar(100) DEFAULT NULL COMMENT '课程名称',
  `ls` varchar(100) DEFAULT NULL COMMENT '任课老师',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='课程';

-- ----------------------------
-- Records of t_kc
-- ----------------------------
INSERT INTO `t_kc` VALUES ('1', '数学课', '王校长');

-- ----------------------------
-- Table structure for `t_ksxx`
-- ----------------------------
DROP TABLE IF EXISTS `t_ksxx`;
CREATE TABLE `t_ksxx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) DEFAULT NULL COMMENT '学生',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `pic` varchar(100) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `showDate` datetime DEFAULT NULL COMMENT '考试日期',
  `ksdd` varchar(100) DEFAULT NULL COMMENT '考试地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='考试地点';

-- ----------------------------
-- Records of t_ksxx
-- ----------------------------
INSERT INTO `t_ksxx` VALUES ('1', '1', '2018秋季考试', 'upload/20180417/152396847564580.jpg', '2018秋季考试2018秋季考试2018秋季考试2018秋季考试', '2018-04-19 00:00:00', '2018秋季考试');

-- ----------------------------
-- Table structure for `t_ptadmin`
-- ----------------------------
DROP TABLE IF EXISTS `t_ptadmin`;
CREATE TABLE `t_ptadmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码 ',
  `ptadminName` varchar(100) DEFAULT NULL COMMENT '姓名',
  `age` varchar(100) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='教务人员';

-- ----------------------------
-- Records of t_ptadmin
-- ----------------------------
INSERT INTO `t_ptadmin` VALUES ('1', 'jw1', '111', '王老师', '12', '男', '13811111111');
INSERT INTO `t_ptadmin` VALUES ('2', 'jw2', '111', '李老师', '22', '男', '13811111111');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码 ',
  `studentName` varchar(100) DEFAULT NULL COMMENT '姓名',
  `bjId` int(11) DEFAULT NULL COMMENT '班级',
  `age` varchar(100) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `qq` varchar(100) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `pic` varchar(100) DEFAULT NULL COMMENT '头像',
  `xh` varchar(100) DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='学生';

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'x1', '111', '小明', '1', '22', '男', '13811111111', '1111', '111@qq.com', 'upload/20180417/152396827555788.jpg', '111');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码 ',
  `teacherName` varchar(100) DEFAULT NULL COMMENT '姓名',
  `age` varchar(100) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `pic` varchar(100) DEFAULT NULL COMMENT '头像',
  `xh` varchar(100) DEFAULT NULL COMMENT '工号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='老师';

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', 't1', '111', '黑老师', '22', '男', '13811111111', 'upload/20180417/152396830061695.jpg', '222');

-- ----------------------------
-- Table structure for `t_xk`
-- ----------------------------
DROP TABLE IF EXISTS `t_xk`;
CREATE TABLE `t_xk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ckId` int(11) DEFAULT NULL COMMENT '课程',
  `studnetId` int(11) DEFAULT NULL COMMENT '学生',
  `cj` varchar(100) DEFAULT NULL COMMENT '成绩',
  `status` varchar(100) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='学生选课';

-- ----------------------------
-- Records of t_xk
-- ----------------------------
INSERT INTO `t_xk` VALUES ('1', '1', '1', '99', '完成');
