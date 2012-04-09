/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50161
Source Host           : localhost:3306
Source Database       : redhorse

Target Server Type    : MYSQL
Target Server Version : 50161
File Encoding         : 65001

Date: 2012-04-02 09:54:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product_dtl`
-- ----------------------------
DROP TABLE IF EXISTS `redhorse.product_dtl`;
CREATE TABLE `redhorse.product_dtl` (
  `product_dtl_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `price` double NOT NULL,
  `price_type` int(11) DEFAULT NULL,
  `qty_on_hand` float DEFAULT NULL,
  `selling_qty` float DEFAULT NULL,
  `sug_price` double DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `status_status_id` int(11) DEFAULT NULL,
  `unitConversion_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_dtl_id`),
  KEY `FKA71C728C30D82E06` (`status_status_id`),
  KEY `FKA71C728C13E734E1` (`product_id`),
  KEY `FKA71C728CBC781C33` (`unitConversion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product_dtl
-- ----------------------------
