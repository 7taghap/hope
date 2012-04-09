DROP table if EXIST `unit_type`;
CREATE TABLE  `redhorse`.`unit_type` (
  `unit_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`unit_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `unit_type` VALUES(1,'Volume','v');
INSERT INTO `unit_type` VALUES(2,'Weight','w');
INSERT INTO `unit_type` VALUES(3,'User','u');