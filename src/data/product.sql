/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50161
Source Host           : localhost:3306
Source Database       : redhorse

Target Server Type    : MYSQL
Target Server Version : 50161
File Encoding         : 65001

Date: 2012-04-02 09:47:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `redhorse.product`;
CREATE TABLE `redhorse.product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `imgfile` varchar(255) DEFAULT NULL,
  `product_desc` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` int(11) DEFAULT NULL,
  `shelf` varchar(255) DEFAULT NULL,
  `total_qty_on_hand` float DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `unit_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKED8DCCEF3D841368` (`unit_type`),
  KEY `FKED8DCCEF58CB7292` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product
-- ----------------------------
