/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 16/04/2020 00:38:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '解忧杂货店', '东野圭吾', '电子工业出版社');
INSERT INTO `book` VALUES (2, '追风筝的人', '卡勒德·胡赛尼', '中信出版社');
INSERT INTO `book` VALUES (3, '人间失格', '太宰治', '作家出版社');
INSERT INTO `book` VALUES (4, '这就是二十四节气', '高春香', '电子工业出版社');
INSERT INTO `book` VALUES (5, '白夜行', '东野圭吾', '南海出版公司');
INSERT INTO `book` VALUES (6, '摆渡人', '克莱儿·麦克福尔', '百花洲文艺出版社');
INSERT INTO `book` VALUES (7, '暖暖心绘本', '米拦弗特毕', '湖南少儿出版社');
INSERT INTO `book` VALUES (8, '天才在左疯子在右', '高铭', '北京联合出版公司');
INSERT INTO `book` VALUES (9, '我们仨', '杨绛', '生活.读书.新知三联书店');
INSERT INTO `book` VALUES (10, '活着', '余华', '作家出版社');
INSERT INTO `book` VALUES (119, '时间的秩序', ' [意] 卡洛·罗韦利', '湖南科学技术出版社');
INSERT INTO `book` VALUES (120, '偷影子的人', ' [法] 马克·李维', '湖南文艺出版社');
INSERT INTO `book` VALUES (121, '在路上', '(美) 杰克·凯鲁亚克', '人民文学出版社');
INSERT INTO `book` VALUES (122, '呼吸', ' [美] 特德·姜', '译林出版社');
INSERT INTO `book` VALUES (123, '书店日记', '[英] 肖恩·白塞尔', '广西师范大学出版社');

SET FOREIGN_KEY_CHECKS = 1;
