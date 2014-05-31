CREATE DATABASE  IF NOT EXISTS `data_vision_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `data_vision_db`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: data_vision_db
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activitylogs`
--

DROP TABLE IF EXISTS `activitylogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activitylogs` (
  `ACTIVITYLOGS_ID` bigint(20) NOT NULL,
  `COMMAND` varchar(255) DEFAULT NULL,
  `ISGRANTED` bit(1) DEFAULT NULL,
  `TIMESTAMP` date DEFAULT NULL,
  `USER` varchar(255) DEFAULT NULL,
  `FIXTURENAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ACTIVITYLOGS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitylogs`
--

LOCK TABLES `activitylogs` WRITE;
/*!40000 ALTER TABLE `activitylogs` DISABLE KEYS */;
INSERT INTO `activitylogs` VALUES (1,'stop','','2014-05-31','user1','Light'),(2,'stop','','2014-05-31','user1','Light'),(3,'stop','','2014-05-31','user1','Light'),(4,'stop','','2014-05-31','user1','Light'),(5,'stop','','2014-05-31','user1','Light'),(6,'turnOn','','2014-05-31','user1','Light'),(7,'turnOff','','2014-05-31','user1','Light'),(8,'turnOn','','2014-06-01',NULL,NULL),(9,'turnOff','','2014-06-01',NULL,'Light'),(10,'turnOff','','2014-06-01',NULL,NULL),(11,'turnOn','','2014-06-01',NULL,'Light'),(12,'turnOff','','2014-06-01','salem',NULL),(13,'turnOn','','2014-06-01','edin','Light'),(14,'turnOn','','2014-06-01','melika',NULL),(15,'turnOn','','2014-06-01','enes','Light'),(16,'turnOn','','2014-06-01','rijad',NULL),(17,'turnOn','','2014-06-01','adnan','Light'),(18,'turnOn','','2014-06-01','adnan',NULL),(19,'turnOn','','2014-06-01','adnan','Light'),(20,'turnOn','','2014-06-01','rijad',NULL);
/*!40000 ALTER TABLE `activitylogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devicename`
--

DROP TABLE IF EXISTS `devicename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devicename` (
  `DEVICENAME_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DEVICENAME_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devicename`
--

LOCK TABLES `devicename` WRITE;
/*!40000 ALTER TABLE `devicename` DISABLE KEYS */;
INSERT INTO `devicename` VALUES (1,'graySockets'),(2,'Light'),(3,'Air');
/*!40000 ALTER TABLE `devicename` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devicetype`
--

DROP TABLE IF EXISTS `devicetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devicetype` (
  `TYPE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devicetype`
--

LOCK TABLES `devicetype` WRITE;
/*!40000 ALTER TABLE `devicetype` DISABLE KEYS */;
INSERT INTO `devicetype` VALUES (1,'LIGHT'),(2,'AIR_CONDITION'),(3,'CO2'),(4,'TEMPERATURE');
/*!40000 ALTER TABLE `devicetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventlogs`
--

DROP TABLE IF EXISTS `eventlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventlogs` (
  `EVENTLOGS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DEVICE_NAME` varchar(255) DEFAULT NULL,
  `DEVICE_TYPE` varchar(255) DEFAULT NULL,
  `EVENT_MESSAGE` varchar(255) DEFAULT NULL,
  `TIMESTAMP` datetime DEFAULT NULL,
  `VALUE` double DEFAULT NULL,
  `ACTIVITY_LOGS` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`EVENTLOGS_ID`),
  KEY `FK_847r861kad04lgpc8sqxhx5ml` (`ACTIVITY_LOGS`),
  CONSTRAINT `FK_847r861kad04lgpc8sqxhx5ml` FOREIGN KEY (`ACTIVITY_LOGS`) REFERENCES `activitylogs` (`ACTIVITYLOGS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=665 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventlogs`
--

LOCK TABLES `eventlogs` WRITE;
/*!40000 ALTER TABLE `eventlogs` DISABLE KEYS */;
INSERT INTO `eventlogs` VALUES (1,'graySockets','LIGHT_EVENT','turnOff','2014-05-01 16:00:00',0,1),(2,'Light','LIGHT_EVENT','turnOn','2014-05-01 17:00:00',1,2),(3,'graySockets','LIGHT_EVENT','turnOff','2014-05-01 18:00:00',0,3),(4,'Light','LIGHT_EVENT','turnOn','2014-05-01 19:00:00',1,1),(5,'graySockets','LIGHT_EVENT','turnOn','2014-05-01 20:00:00',1,2),(6,'Light','LIGHT_EVENT','turnOff','2014-05-01 21:00:00',0,3),(7,'graySockets','LIGHT_EVENT','turnOn','2014-05-01 22:00:00',1,4),(8,'Light','LIGHT_EVENT','turnOn','2014-06-01 00:00:00',1,1),(9,'graySockets','LIGHT_EVENT','turnOn','2014-06-01 01:00:00',1,2),(10,'Light','LIGHT_EVENT','turnOff','2014-06-01 02:00:00',0,3),(11,'graySockets','LIGHT_EVENT','turnOff','2014-06-01 03:00:00',0,1),(12,'Light','LIGHT_EVENT','turnOn','2014-06-01 04:00:00',1,2),(13,'Light','LIGHT_EVENT','turnOff','2014-06-01 05:00:00',0,3),(14,'Light','LIGHT_EVENT','turnOn','2014-06-01 06:00:00',1,1),(15,'Light','LIGHT_EVENT','turnOff','2014-06-01 07:00:00',0,2),(16,'graySockets','LIGHT_EVENT','turnOn','2014-06-01 08:00:00',1,1),(17,'Light','LIGHT_EVENT','turnOn','2014-06-01 09:00:00',1,2),(18,'graySockets','LIGHT_EVENT','turnOff','2014-06-01 10:00:00',0,3),(19,'Light','LIGHT_EVENT','turnOn','2014-06-01 11:00:00',1,1),(20,'graySockets','LIGHT_EVENT','turnOff','2014-06-01 12:00:00',0,2),(21,'Light','LIGHT_EVENT','turnOn','2014-06-01 13:00:00',1,3),(22,'graySockets','LIGHT_EVENT','turnOn','2014-06-01 14:00:00',1,1),(23,'Light','LIGHT_EVENT','turnOff','2014-06-01 15:00:00',0,2),(24,'graySockets','LIGHT_EVENT','turnOff','2014-06-01 16:00:00',0,1),(25,'Light','LIGHT_EVENT','turnOn','2014-06-01 17:00:00',1,2),(26,'graySockets','LIGHT_EVENT','turnOff','2014-06-01 18:00:00',0,3),(27,'Light','LIGHT_EVENT','turnOn','2014-06-01 19:00:00',1,1),(28,'graySockets','LIGHT_EVENT','turnOn','2014-06-01 20:00:00',1,2),(29,'Light','LIGHT_EVENT','turnOff','2014-06-01 21:00:00',0,3),(30,'graySockets','LIGHT_EVENT','turnOn','2014-07-01 22:00:00',1,4),(31,'Light','LIGHT_EVENT','turnOff','2014-07-01 23:00:00',0,5);
/*!40000 ALTER TABLE `eventlogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'adnan'),(2,'melika'),(3,'snjeza'),(4,'salem'),(5,'enes'),(6,'rijad');
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

-- Dump completed on 2014-05-31 22:59:32
