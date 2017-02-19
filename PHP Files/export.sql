/*
SQLyog Ultimate v12.09 (32 bit)
MySQL - 5.6.35 : Database - ankit77r_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ankit77r_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ankit77r_db`;

/*Table structure for table `acception` */

DROP TABLE IF EXISTS `acception`;

CREATE TABLE `acception` (
  `accpt_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `isAccept` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`accpt_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `acception` */

insert  into `acception`(`accpt_id`,`user_id`,`isAccept`) values (1,122,1),(2,122,1),(3,122,1),(4,122,1);

/*Table structure for table `signup` */

DROP TABLE IF EXISTS `signup`;

CREATE TABLE `signup` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `mobileNumber` varchar(30) DEFAULT NULL,
  `merriageId` varchar(10) DEFAULT NULL,
  `deviceId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `Unique` (`deviceId`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `signup` */

insert  into `signup`(`user_id`,`name`,`mobileNumber`,`merriageId`,`deviceId`) values (20,'om','123','12','145'),(19,'om','123','12','1');

/*Table structure for table `userWishes` */

DROP TABLE IF EXISTS `userWishes`;

CREATE TABLE `userWishes` (
  `w_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `message` varchar(1500) DEFAULT NULL,
  `marriage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`w_id`)
) ENGINE=MEMORY AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `userWishes` */

insert  into `userWishes`(`w_id`,`user_id`,`message`,`marriage_id`) values (1,122,'fdjdnfg fngjd fjndfjngj dfjdfnjf fjdgndjfgnjdfg',12),(2,122,'fdjdnfg fngjd fjndfjngj dfjdfnjf fjdgndjfgnjdfg kfngkmk ffks sdjfsdfk  fsjdfjskdfj kf skdjfks kds ksd fkjdskf  kdfkjsdkfjkds skdljfkdsj fkdsf   kfj sdfj fjdkj kfsdk skdk  fksdkf jdskfjs',12),(3,12,'message',10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
