-- MySQL dump 10.13  Distrib 5.5.17, for Win64 (x86)
--
-- Host: localhost    Database: shoppinglist
-- ------------------------------------------------------
-- Server version	5.5.17

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Description` text,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Samsung Core Mobile',560,'Samsung Core mobile is slim with 2 GB RAM and 6 GB ROM'),(4,'Test',124,'Description:  Description:  Description:  Description:  '),(5,'Product #3',180,'Product #3 description here'),(6,'Product #4',150,'Product #4 description here'),(8,'Product #6',170,'asdfadf adf adfafd'),(13,'New',120.6,'Description Description');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shareduserlist`
--

DROP TABLE IF EXISTS `shareduserlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shareduserlist` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserListId` int(11) DEFAULT NULL,
  `SharedByUserId` int(11) DEFAULT NULL,
  `SharedToUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_shareduserlist_userlistid_idx` (`UserListId`),
  KEY `fk_shareduserlist_sharedby_idx` (`SharedByUserId`),
  KEY `fk_shareduserlist_sharedto_idx` (`SharedToUserId`),
  CONSTRAINT `fk_shareduserlist_sharedby` FOREIGN KEY (`SharedByUserId`) REFERENCES `user` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_shareduserlist_sharedto` FOREIGN KEY (`SharedToUserId`) REFERENCES `user` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_shareduserlist_userlistid` FOREIGN KEY (`UserListId`) REFERENCES `userlist` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shareduserlist`
--

LOCK TABLES `shareduserlist` WRITE;
/*!40000 ALTER TABLE `shareduserlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `shareduserlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Test','User','test','test',1),(6,'New','User','user','newuser',1),(7,'Transaction','Test','transaction','test',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlist`
--

DROP TABLE IF EXISTS `userlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlist` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_userid_idx` (`UserId`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlist`
--

LOCK TABLES `userlist` WRITE;
/*!40000 ALTER TABLE `userlist` DISABLE KEYS */;
INSERT INTO `userlist` VALUES (1,2,'Test User List'),(2,6,'New User List'),(3,7,'Transaction Test List');
/*!40000 ALTER TABLE `userlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlistitem`
--

DROP TABLE IF EXISTS `userlistitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlistitem` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserListId` int(11) DEFAULT NULL,
  `Item` varchar(250) DEFAULT NULL,
  `Purchased` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `userlist_id_idx` (`UserListId`),
  CONSTRAINT `fk_userlistid` FOREIGN KEY (`UserListId`) REFERENCES `userlist` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlistitem`
--

LOCK TABLES `userlistitem` WRITE;
/*!40000 ALTER TABLE `userlistitem` DISABLE KEYS */;
INSERT INTO `userlistitem` VALUES (1,1,'Item1',0),(2,1,'New Item 2',0);
/*!40000 ALTER TABLE `userlistitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `Role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_userrole_userid_idx` (`UserId`),
  CONSTRAINT `fk_userrole_userid` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES (3,2,'ROLE_USER'),(5,6,'ROLE_USER'),(6,7,'ROLE_USER');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-23 23:34:11
