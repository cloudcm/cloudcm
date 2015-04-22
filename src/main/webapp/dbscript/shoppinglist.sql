CREATE DATABASE  IF NOT EXISTS `shoppinglist` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `shoppinglist`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
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

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Description` text,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shareduserlist`
--

DROP TABLE IF EXISTS `SharedUserList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SharedUserList` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserListId` int(11) DEFAULT NULL,
  `SharedByUserId` int(11) DEFAULT NULL,
  `SharedToUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_shareduserlist_userlistid_idx` (`UserListId`),
  KEY `fk_shareduserlist_sharedby_idx` (`SharedByUserId`),
  KEY `fk_shareduserlist_sharedto_idx` (`SharedToUserId`),
  CONSTRAINT `fk_shareduserlist_userlistid` FOREIGN KEY (`UserListId`) REFERENCES `UserList` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_shareduserlist_sharedby` FOREIGN KEY (`SharedByUserId`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_shareduserlist_sharedto` FOREIGN KEY (`SharedToUserId`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shareduserlist`
--

LOCK TABLES `SharedUserList` WRITE;
/*!40000 ALTER TABLE `shareduserlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `shareduserlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Enabled`	tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `User` WRITE;
INSERT INTO `User` (`FirstName`, `LastName`, `Username`, `Password`, `Enabled`) VALUES ('Site', 'Admin', 'admin', '12345', 1);
UNLOCK TABLES;

--
-- Table structure for table `userlist`
--

DROP TABLE IF EXISTS `UserList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserList` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_userid_idx` (`UserId`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`UserId`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlist`
--

LOCK TABLES `UserList` WRITE;
/*!40000 ALTER TABLE `userlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `userlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlistproduct`
--

DROP TABLE IF EXISTS `UserListProduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserListProduct` (
  `Id` int(11) NOT NULL,
  `UserListId` int(11) DEFAULT NULL,
  `ProductId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userlist_id_idx` (`UserListId`),
  KEY `prod_idx` (`ProductId`),
  CONSTRAINT `fk_userlistid` FOREIGN KEY (`UserListId`) REFERENCES `UserList` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_productid` FOREIGN KEY (`ProductId`) REFERENCES `Product` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlistproduct`
--

LOCK TABLES `UserListProduct` WRITE;
/*!40000 ALTER TABLE `userlistproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `userlistproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `UserRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserRole` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `Role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_userrole_userid_idx` (`UserId`),
  CONSTRAINT `fk_userrole_userid` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `UserRole` WRITE;
INSERT INTO `UserRole` (`UserId`, `Role`) VALUES (1, 'ROLE_USER');
INSERT INTO `UserRole` (`UserId`, `Role`) VALUES (1, 'ROLE_ADMIN');
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-22  0:25:04
