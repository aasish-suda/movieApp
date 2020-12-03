-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: app
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(25) NOT NULL,
  `password` varchar(45) NOT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `phone` varchar(10) NOT NULL,
  `role` varchar(1) NOT NULL DEFAULT 'U',
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('aas','aas','aas','9048453204','U'),('aasish','suda','aasish@abc.com','1234567891','U'),('Aasu','aasu','aasu@abc.com','6238474752','U'),('admin','admin','amin@abc.com','1234567895','A'),('Bhau','bahu','bahu@abc.com','9564845320','U'),('delvin','aas','del@abc.com','1234567891','U'),('denson','denson','denson@gmail.com','9454532045','U'),('di','di','di@di.com','9546895235','U'),('dim','di','di','1234567891','U'),('don','don','don','1234567895','U'),('gauri','gauri','gauri@abc.com','9048453204','U'),('Holt','holt','holt@abc.vpm','6238493787','U'),('infy','infy','infy@abc.com','9578542144','U'),('john','john','john@abc.com','1234567891','U'),('kem','kem','kem@kem.com','1234567895','U'),('kim','kin','kim','1234567895','U'),('kishor','kishor','kishor@abc.com','9545620145','U'),('lenovo','len','len@abc.com','9048453204','U'),('ram','ram','ravi@gmail.com','1234567891','U'),('Venu','venu','venu@abc.com','9846685228','U'),('vinoth','vin','vin@aabc.com','9568524565','U');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-03 18:09:41
