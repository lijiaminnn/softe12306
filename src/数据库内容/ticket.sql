/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : ticket

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-03 12:39:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for checi
-- ----------------------------
DROP TABLE IF EXISTS `checi`;
CREATE TABLE `checi` (
  `TrainCode` varchar(10) NOT NULL,
  `StartStation` varchar(10) CHARACTER SET utf8 NOT NULL,
  `ArriveStation` varchar(10) CHARACTER SET utf8 NOT NULL,
  `StartTime` varchar(10) NOT NULL,
  `ArriveTime` varchar(10) NOT NULL,
  `UseTime` varchar(10) CHARACTER SET utf8 NOT NULL,
  `TicketNum` int(11) NOT NULL,
  `TicketPrice` decimal(10,1) NOT NULL,
  `date` char(10) NOT NULL,
  PRIMARY KEY (`TrainCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of checi
-- ----------------------------
INSERT INTO `checi` VALUES ('D2187', '南京', '杭州', '12:50', '14:30', '1小时40分钟', '89', '71.0', '2018-12-31');
INSERT INTO `checi` VALUES ('D2222', '杭州', '南京', '07:42', '09:37', '1小时55分钟', '98', '71.0', '2018-12-30');
INSERT INTO `checi` VALUES ('D3125', '南京', '杭州', '06:37', '10:09', '3小时32分钟', '89', '128.0', '2019-12-30');
INSERT INTO `checi` VALUES ('D3135', '南京', '杭州', '08:09', '12:12', '4小时03分钟', '82', '167.0', '2019-01-01');
INSERT INTO `checi` VALUES ('D656', '杭州', '南京', '08:10', '09:59', '1小时49分钟', '79', '95.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G1', '北京', '上海', '09:00', '13:28', '4小时28分钟', '98', '553.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G10', '上海', '北京', '10:00', '14:28', '4小时28分钟', '79', '553.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G102', '上海', '北京', '06:26', '12:29', '6小时03分钟', '100', '553.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G105', '北京', '上海', '07:20', '13:08', '5小时48分钟', '86', '553.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G110', '上海', '北京', '07:28', '13:38', '6小时10分钟', '68', '553.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G115', '北京', '上海', '09:20', '15:09', '5小时49分钟', '55', '553.0', '2019-01-01');
INSERT INTO `checi` VALUES ('G121', '北京', '上海', '10:20', '16:25', '6小时05分钟', '86', '553.0', '2019-01-02');
INSERT INTO `checi` VALUES ('G1224', '杭州', '南京', '08:31', '09:53', '1小时22分钟', '89', '117.5', '2019-01-01');
INSERT INTO `checi` VALUES ('G126', '上海', '北京', '11:05', '17:05', '6小时00分钟', '89', '553.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G129', '北京', '上海', '12:10', '17:56', '5小时45分钟', '89', '553.0', '2019-01-02');
INSERT INTO `checi` VALUES ('G135', '北京', '上海', '13:05', '18:59', '5小时54分钟', '89', '553.0', '2019-01-01');
INSERT INTO `checi` VALUES ('G1379', '南京', '杭州', '07:38', '09:28', '1小时50分钟', '58', '117.5', '2019-12-30');
INSERT INTO `checi` VALUES ('G138', '上海', '北京', '13:39', '19:28', '5小时59分钟', '69', '553.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G143', '北京', '上海', '07:50', '13:12', '5小时22分钟', '89', '553.0', '2019-01-01');
INSERT INTO `checi` VALUES ('G146', '上海', '北京', '14:52', '20:48', '5小时56分钟', '78', '553.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G150', '上海', '北京', '16:05', '22:00', '5小时55分钟', '98', '553.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G1503', '南京', '杭州', '08:32', '09:56', '1小时24分钟', '89', '117.5', '2018-12-31');
INSERT INTO `checi` VALUES ('G158', '上海', '北京', '17:34', '23:29', '5小时55分钟', '89', '553.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G164', '杭州', '北京', '13:41', '19:53', '6小时12分钟', '100', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G166', '杭州', '北京', '15:12', '20:58', '5小时46分钟', '89', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G1665', '南京', '杭州', '09:08', '10:48', '1小时40分钟', '89', '117.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G1672', '杭州', '南京', '10:36', '11:57', '1小时21分钟', '96', '117.5', '2019-01-01');
INSERT INTO `checi` VALUES ('G168', '杭州', '北京', '11:39', '18:13', '6小时34分钟', '62', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G1731', '南京', '杭州', '11:20', '12:43', '1小时23分钟', '89', '117.5', '2019-01-01');
INSERT INTO `checi` VALUES ('G18', '上海', '北京', '18:00', '22:36', '4小时36分钟', '76', '553.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G1862', '杭州', '南京', '07:14', '08:36', '1小时22分钟', '89', '117.5', '2018-12-31');
INSERT INTO `checi` VALUES ('G1874', '杭州', '南京', '07:08', '08:41', '1小时33分钟', '56', '117.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G19', '南京', '杭州', '11:36', '12:38', '1小时12分钟', '89', '117.5', '2018-12-31');
INSERT INTO `checi` VALUES ('G20', '杭州', '北京', '07:48', '12:20', '4小时32分钟', '100', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G254', '杭州', '南京', '06:37', '08:14', '1小时37分钟', '100', '117.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G32', '杭州', '北京', '13:00', '17:39', '4小时39分钟', '65', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G34', '杭州', '北京', '07:01', '13:03', '6小时2分钟', '100', '538.8', '2018-12-25');
INSERT INTO `checi` VALUES ('G36', '杭州', '北京', '09:05', '14:53', '5小时48分钟', '99', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G38', '杭州', '北京', '11:34', '18:09', '6小时35分钟', '89', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G40', '杭州', '北京', '19:00', '23:23', '4小时23分钟', '100', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G411', '北京', '上海', '11:20', '17:25', '6小时05分钟', '56', '553.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G42', '杭州', '北京', '09:24', '16:08', '6小时44分钟', '76', '626.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G44', '杭州', '北京', '16:15', '23:08', '6小时53分钟', '75', '626.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G46', '杭州', '北京', '09:50', '15:43', '5小时53分钟', '86', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G5', '北京', '上海', '07:00', '11:40', '4小时40分钟', '100', '558.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G56', '杭州', '北京', '12:46', '18:53', '6小时07分钟', '96', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G58', '杭州', '北京', '08:50', '14:43', '5小时53分钟', '100', '538.5', '2018-12-25');
INSERT INTO `checi` VALUES ('G6', '上海', '北京', '07:00', '11:38', '4小时38分钟', '89', '558.0', '2018-12-30');
INSERT INTO `checi` VALUES ('G60', '杭州', '北京', '15:43', '21:29', '5小时46分钟', '80', '538.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G7505', '南京', '杭州', '07:13', '09:54', '2小时41分钟', '59', '208.5', '2019-12-30');
INSERT INTO `checi` VALUES ('G7564', '杭州', '南京', '08:34', '11:43', '3小时09分钟', '89', '216.0', '2018-12-31');
INSERT INTO `checi` VALUES ('G7599', '南京', '杭州', '09:32', '12:03', '2小时31分钟', '69', '208.5', '2018-12-31');
INSERT INTO `checi` VALUES ('G7605', '南京', '杭州', '09:57', '11:30', '1小时33分钟', '75', '117.5', '2019-01-01');
INSERT INTO `checi` VALUES ('G7681', '南京', '杭州', '10:13', '11:41', '1小时28分钟', '75', '117.5', '2018-12-31');
INSERT INTO `checi` VALUES ('G7686', '杭州', '南京', '06:50', '08:25', '1小时35分钟', '69', '117.5', '2018-12-30');
INSERT INTO `checi` VALUES ('G9466', '杭州', '南京', '09:43', '11:07', '1小时24分钟', '78', '117.5', '2019-01-01');
INSERT INTO `checi` VALUES ('K117', '衢州', '杭州', '08:42', '12:09', '3小时27分钟', '100', '41.5', '2018-12-25');

-- ----------------------------
-- Table structure for dingdan
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan` (
  `id` int(11) NOT NULL,
  `traincode` varchar(10) NOT NULL,
  `startstation` varchar(10) CHARACTER SET utf8 NOT NULL,
  `arrivestation` varchar(10) CHARACTER SET utf8 NOT NULL,
  `starttime` varchar(10) NOT NULL,
  `arrivetime` varchar(10) NOT NULL,
  `username` varchar(10) CHARACTER SET utf8 NOT NULL,
  `idcard` varchar(19) NOT NULL,
  `ticketprice` decimal(10,1) NOT NULL,
  `Date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
INSERT INTO `dingdan` VALUES ('1', 'G34', '杭州', '北京', '08:50', '14:43', 'first', '123456789987654321', '538.5', '2018-12-25');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(10) CHARACTER SET utf8 NOT NULL,
  `password` varchar(10) NOT NULL,
  `realname` varchar(10) CHARACTER SET utf8 NOT NULL,
  `telNumber` char(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `IDCard` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('first', '123456', '小李', '13123456789', '111@qq.com', '123456789987654321');
INSERT INTO `user` VALUES ('second', '123456', '小张', '13223456789', '222@qq.com', '123456789123456789');
INSERT INTO `user` VALUES ('Kate', '125845', '王五', '15478596351', '57895@qq.com', '332586974452145896');
INSERT INTO `user` VALUES ('小聪', '111111', '张三', '15428973551', '314659@qq.com', '316254826149768341');
INSERT INTO `user` VALUES ('111', '111111', '李四', '18134596475', '56523165@qq.com', '459317199801015987');
INSERT INTO `user` VALUES ('james', '124578', '詹姆斯', '15789562462', '55565481@qq.com', '358947199601016658');
INSERT INTO `user` VALUES ('旺旺', '2541', '陈王', '15556165451', '125478935@163.com', '462565199706086521');
INSERT INTO `user` VALUES ('星星', '25686ghj', '王星', '13595452265', '256825646@163.com', '555615198606171452');
INSERT INTO `user` VALUES ('小花', '123xiaohua', '张花花', '18215122153', '41214561@qq.com', '125652196805195621');
INSERT INTO `user` VALUES ('yiyi', '111yiyi', '钱一', '13664989628', '5486515151@qq.com', '364814199507162652');
INSERT INTO `user` VALUES ('蝴蝶', 'hudie481', '胡霞', '13486215455', '2514125@163.com', '155646200301015653');
INSERT INTO `user` VALUES ('迷糊', 'mihuah81', '胡咋', '18654561225', '516456232@qq.com', '565523199902168486');
INSERT INTO `user` VALUES ('滑稽', 'huaji1852', '肖长', '13455525615', '15515465@qq.com', '156621199906252155');
INSERT INTO `user` VALUES ('jhjk', 'judh562', '局牛', '13565655656', '56156115@qq.com', '156564200101019223');
INSERT INTO `user` VALUES ('sede', '562ds22', '成点击', '13655695165', '564651125@qq.com', '355612195811016521');
INSERT INTO `user` VALUES ('bob', '56sd2', 'Bob', '13465158226', '1541251@qq.com', '345155199911120262');
INSERT INTO `user` VALUES ('white', 'whitenj562', '怀特', '13448565556', '4784551@qq.com', '354566199908062155');
INSERT INTO `user` VALUES ('地脚线', 'dijiao556', '沈无', '13852155565', '5621651@qq.com', '311561199901012652');
INSERT INTO `user` VALUES ('及得', 'jide6232', '史诗', '13565566565', '621561211@qq.com', '211521199806052356');
INSERT INTO `user` VALUES ('妞妞', '233215', '牛翠花', '13486521552', '2312333662@qq.com', '554103199909091523');
INSERT INTO `user` VALUES ('花蛤', '5123', '张贴', '15152111332', '5322321@qq.com', '346651199705062156');
INSERT INTO `user` VALUES ('xhsh', 'hxh2155', '张丹', '18315561216', '15421353@qq.com', '315621199909092523');
INSERT INTO `user` VALUES ('的八仙城', '5656112', '郑旺', '18116556216', '215231551@qq.com', '356561199707071523');
INSERT INTO `user` VALUES ('可爱', '216216', '李可爱', '13562156212', '156212312@qq.com', '356521199909095213');
INSERT INTO `user` VALUES ('机智', '2655622', '李机智', '13648562326', '2355616@qq.com', '315625198605051635');
INSERT INTO `user` VALUES ('哗哗哗', 'huahauahu2', '朱华', '13485962654', '561465612@qq.com', '121202199909090514');
INSERT INTO `user` VALUES ('小丽', '123456', '吴丽', '13598762985', '5456518486@qq.com', '359876199901012589');
