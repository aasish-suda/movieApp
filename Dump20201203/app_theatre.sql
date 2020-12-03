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
-- Table structure for table `theatre`
--

DROP TABLE IF EXISTS `theatre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theatre` (
  `theatreid` int(11) NOT NULL,
  `theatrename` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `movieid` int(11) DEFAULT NULL,
  `seatcapacity` int(11) NOT NULL,
  PRIMARY KEY (`theatreid`),
  KEY `moviereference_idx` (`movieid`),
  CONSTRAINT `movieReference` FOREIGN KEY (`movieid`) REFERENCES `movie` (`movieid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatre`
--

LOCK TABLES `theatre` WRITE;
/*!40000 ALTER TABLE `theatre` DISABLE KEYS */;
INSERT INTO `theatre` VALUES (2,'Carnival','Karyavattom',120,1,250),(3,'PVR-MOT','MOT',250,3,250),(8,'PVR-Kochi','Kochi',250,3,200),(9,'New','Trivandrum',250,3,260),(57,'Imax','Trivandrum',150,36,250),(59,'MultiPlex','Mysore',100,58,500),(68,'Yamuna','Attingal',110,67,250),(74,'Central Movies','Trivandrum',110,73,500),(82,'Kaveri','Trivandrum',150,81,500),(89,'Infosys','Mysore',100,88,250),(98,'Aries Plex','Trivandrum',210,94,800),(109,'New Theatre','Trivandrum',180,107,425),(113,'Sree Dhyna','Trivandrum',120,112,500),(117,'Sree Dhanya Screen 2','Trivandrum',110,67,250);
/*!40000 ALTER TABLE `theatre` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-03 18:09:42
