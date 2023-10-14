-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.1.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table week5.address: ~8 rows (approximately)
REPLACE INTO `address` (`add_id`, `city`, `country`, `number`, `street`, `zipcode`) VALUES
	(1, '1', 1, '0352443324', 'Nguyen Van Bao', '13234'),
	(2, 'HN', 1, '0324343432', 'Nguyen Van Bao', '24234'),
	(3, 'GL', 4, '0324343432', 'Nguyen Van Bao', '24234'),
	(6, 'HCM', 1, '0324343432', 'Nguyen Van Bao', '24234'),
	(7, 'HCM', 258, '0324343432', 'Nguyen Van Bao', '24234'),
	(8, 'HCM', 258, '0324343432', 'Nguyen Van Bao', '24234'),
	(9, 'HCM', 258, '0324343432', 'Nguyen Van Bao', '24234'),
	(10, 'HCM', 258, '0324343432', 'Nguyen Van Bao', '24234');

-- Dumping data for table week5.candidate: ~2 rows (approximately)
REPLACE INTO `candidate` (`can_id`, `dob`, `email`, `full_name`, `phone`, `address`) VALUES
	(1, '2002-12-01', 'bmanh7920@gmail.com', 'Khai Baby', '0342036135', 8),
	(2, '2002-11-22', 'bmanh7920@gmail.com', 'Manh Bui Xuan', '0342036135', 10);

-- Dumping data for table week5.candidate_skill: ~0 rows (approximately)

-- Dumping data for table week5.company: ~1 rows (approximately)
REPLACE INTO `company` (`com_id`, `about`, `email`, `comp_name`, `phone`, `web_url`, `address`) VALUES
	(1, 'company baby', 'baby@mail', 'baby', '034525', 'baby.com', 6);

-- Dumping data for table week5.experience: ~0 rows (approximately)

-- Dumping data for table week5.job: ~2 rows (approximately)
REPLACE INTO `job` (`job_id`, `job_desc`, `job_name`, `company`, `salary`) VALUES
	(1, 'java fresher in 1 year, at least 1 years experence', 'java fresher', 1, '10-12 tr'),
	(2, 'java junior for 3 years, at least 2 years experence', 'java junior', 1, '20-25 tr');

-- Dumping data for table week5.job_skill: ~0 rows (approximately)

-- Dumping data for table week5.skill: ~0 rows (approximately)

-- Dumping data for table week5.users: ~2 rows (approximately)
REPLACE INTO `users` (`user_name`, `pass_word`, `role`) VALUES
	('khaibaby', 'manh2002', NULL),
	('manh2002', 'manh2002', NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
