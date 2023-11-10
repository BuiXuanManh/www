-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.1.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for week1
DROP DATABASE IF EXISTS `week1`;
CREATE DATABASE IF NOT EXISTS `week1` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `week1`;

-- Dumping structure for table week1.account
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table week1.account: ~5 rows (approximately)
DELETE FROM `account`;
INSERT INTO `account` (`account_id`, `email`, `full_name`, `password`, `phone`, `status`) VALUES
	('khaibaby', 'bmanh7920@gmail.com', 'Manh Bui Xuan', '123', '0342036135', 1),
	('user1', 'user@mail', 'user no 1', '123', '031245115', 1),
	('user1safd', 'saA', 'fxaf', '123', 'F', 1),
	('user2', 'user2@mail', 'user no 2', '123', '4164531145', 1),
	('user3', 'user3@gmail', 'user no 3', '123', '1351551545', 1);

-- Dumping structure for table week1.grant_access
DROP TABLE IF EXISTS `grant_access`;
CREATE TABLE IF NOT EXISTS `grant_access` (
  `is_grant` tinyint(4) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `account_account_id` varchar(255) NOT NULL,
  `role_role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`account_account_id`,`role_role_id`),
  KEY `FKdgeegmy7hdemvyorei3fvbad0` (`role_role_id`),
  CONSTRAINT `FKdgeegmy7hdemvyorei3fvbad0` FOREIGN KEY (`role_role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKhvfc1ks3r4gm8st5a2touu4wn` FOREIGN KEY (`account_account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table week1.grant_access: ~8 rows (approximately)
DELETE FROM `grant_access`;
INSERT INTO `grant_access` (`is_grant`, `note`, `account_account_id`, `role_role_id`) VALUES
	(1, 'user access', 'khaibaby', 'role2'),
	(1, 'access admin', 'user1', 'role1'),
	(1, 'access user', 'user1', 'role2'),
	(1, 'user access', 'user1safd', 'role2'),
	(0, 'access admin', 'user2', 'role1'),
	(0, 'access', 'user2', 'role2'),
	(0, 'access admin', 'user3', 'role1'),
	(1, 'access user', 'user3', 'role2');

-- Dumping structure for table week1.log
DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginDate` datetime(6) DEFAULT NULL,
  `logoutDate` datetime(6) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `account_account_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb8exc54js02px5lrxc00kr6yv` (`account_account_id`),
  CONSTRAINT `FKb8exc54js02px5lrxc00kr6yv` FOREIGN KEY (`account_account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table week1.log: ~4 rows (approximately)
DELETE FROM `log`;
INSERT INTO `log` (`id`, `loginDate`, `logoutDate`, `note`, `account_account_id`) VALUES
	(1, '2023-11-10 13:02:43.264175', NULL, 'login', 'user1'),
	(2, '2023-11-10 22:15:45.166744', NULL, 'login', 'user2'),
	(3, NULL, '2023-11-10 22:16:02.441270', 'logout', 'user3'),
	(4, NULL, '2023-11-10 22:16:18.763623', 'logout', 'user3');

-- Dumping structure for table week1.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table week1.role: ~2 rows (approximately)
DELETE FROM `role`;
INSERT INTO `role` (`role_id`, `description`, `role_name`, `status`) VALUES
	('role1', 'admin role', 'ADMIN', 1),
	('role2', 'user role', 'USER', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
