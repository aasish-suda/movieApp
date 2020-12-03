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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `bookingid` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `showid` int(11) DEFAULT NULL,
  `moviename` varchar(45) NOT NULL,
  `theatrename` varchar(45) NOT NULL,
  `showdate` date NOT NULL,
  `showtime` time NOT NULL,
  `seatsbooked` int(11) NOT NULL,
  `totalamount` int(11) NOT NULL,
  `bookingstatus` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`bookingid`),
  KEY `showReference_idx` (`showid`),
  KEY `userReference_idx` (`username`),
  CONSTRAINT `showReference` FOREIGN KEY (`showid`) REFERENCES `shows` (`showid`),
  CONSTRAINT `userReference` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,'john',1,'Avengers','Carnival','2020-04-30','10:30:00',10,1000,'C'),(2,'john',1,'Avengers','Carnival','2020-04-30','10:30:00',10,1000,'C'),(11,'john',1,'Avengers','Carnival','2020-04-30','10:30:00',260,1200,'C'),(13,'john',10,'Avengers','New','2020-04-30','14:30:00',10,2500,'A'),(14,'john',10,'Avengers','New','2020-04-30','14:30:00',200,50000,'C'),(28,'john',10,'Avengers','New','2020-04-30','14:30:00',200,50000,'A'),(29,'john',27,'Avengers','New','2020-04-30','16:30:00',10,2500,'A'),(30,'john',27,'Avengers','New','2020-04-30','16:30:00',10,2500,'C'),(38,'john',1,'Avengers','Carnival','2020-04-30','10:30:00',5,600,'C'),(39,'john',1,'Avengers','Carnival','2020-04-30','10:30:00',10,1200,'C'),(40,'john',1,'Avengers','Carnival','2020-04-30','10:30:00',50,6000,'A'),(41,'john',1,'Avengers','Carnival','2020-04-30','10:30:00',5,600,'A'),(54,'john',1,'Top Gun','Carnival','2020-04-30','10:30:00',5,600,'C'),(61,'john',60,'Money Ball','MultiPlex','2020-05-26','14:30:00',200,20000,'C'),(62,'delvin',1,'Top Gun','Carnival','2020-04-30','10:30:00',5,600,'A'),(63,'delvin',60,'Money Ball','MultiPlex','2020-05-26','14:30:00',50,5000,'C'),(64,'delvin',60,'Money Ball','MultiPlex','2020-05-26','14:30:00',499,49900,'A'),(72,'john',71,'KGF','Yamuna','2020-05-28','10:30:00',5,550,'C'),(77,'aasu',76,'DDLJ','Central Movies','2020-05-20','10:30:00',10,1100,'C'),(78,'aasu',76,'DDLJ','Central Movies','2020-05-20','10:30:00',10,1100,'C'),(79,'aasu',71,'KGF','Yamuna','2020-05-28','10:30:00',200,22000,'C'),(80,'aasu',76,'DDLJ','Central Movies','2020-05-20','10:30:00',10,1100,'A'),(85,'lenovo',84,'Khoj','Kaveri','2020-05-28','10:30:00',5,750,'C'),(86,'lenovo',84,'Khoj','Kaveri','2020-05-28','10:30:00',100,15000,'A'),(92,'infy',91,'Second Show','Infosys','2020-05-27','11:00:00',50,5000,'C'),(100,'Holt',99,'The King','Aries Plex','2020-05-12','10:30:00',100,21000,'C'),(101,'Holt',99,'The King','Aries Plex','2020-05-12','10:30:00',200,42000,'C'),(102,'Holt',99,'The King','Aries Plex','2020-05-12','10:30:00',800,168000,'A'),(103,'john',1,'Top Gun','Carnival','2020-04-30','10:30:00',10,1200,'C'),(104,'john',1,'Top Gun','Carnival','2020-04-30','10:30:00',10,1200,'C'),(105,'john',1,'Top Gun','Carnival','2020-04-30','10:30:00',10,1200,'C'),(106,'john',1,'Top Gun','Carnival','2020-04-30','10:30:00',10,1200,'A'),(115,'gauri',114,'Bahubali','Sree Dhyna','2020-05-15','10:30:00',250,30000,'C');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-03 18:09:36
