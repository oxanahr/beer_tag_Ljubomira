-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for beer_tag
CREATE DATABASE IF NOT EXISTS `beer_tag` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `beer_tag`;

-- Dumping structure for table beer_tag.beers
CREATE TABLE IF NOT EXISTS `beers` (
  `beerID` int(11) NOT NULL AUTO_INCREMENT,
  `beer_name` varchar(50) NOT NULL,
  `producerID` int(11) NOT NULL,
  `ABV` double NOT NULL DEFAULT 0,
  `description` text NOT NULL,
  `rating` double DEFAULT 0,
  `picture` text DEFAULT NULL,
  `styleID` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`beerID`),
  UNIQUE KEY `beers_beer_name_uindex` (`beer_name`),
  KEY `beers_styles_styleID_fk` (`styleID`),
  KEY `beers_producers_producerID_fk` (`producerID`),
  CONSTRAINT `beers_producers_producerID_fk` FOREIGN KEY (`producerID`) REFERENCES `producers` (`producerID`),
  CONSTRAINT `beers_styles_styleID_fk` FOREIGN KEY (`styleID`) REFERENCES `styles` (`styleID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.beers_tags
CREATE TABLE IF NOT EXISTS `beers_tags` (
  `beerID` int(11) NOT NULL,
  `tagID` int(11) NOT NULL,
  PRIMARY KEY (`tagID`),
  KEY `beers_tags_beers_beerID_fk` (`beerID`),
  CONSTRAINT `beers_tags_beers_beerID_fk` FOREIGN KEY (`beerID`) REFERENCES `beers` (`beerID`),
  CONSTRAINT `beers_tags_tags_tagID_fk` FOREIGN KEY (`tagID`) REFERENCES `tags` (`tagID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.producers
CREATE TABLE IF NOT EXISTS `producers` (
  `producerID` int(11) NOT NULL AUTO_INCREMENT,
  `brewery` varchar(50) NOT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`producerID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.ratings
CREATE TABLE IF NOT EXISTS `ratings` (
  `ratingID` int(11) NOT NULL AUTO_INCREMENT,
  `beerID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `rating` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`ratingID`),
  KEY `ratings_beers_beerID_fk` (`beerID`),
  KEY `ratings_users_userID_fk` (`userID`),
  CONSTRAINT `ratings_beers_beerID_fk` FOREIGN KEY (`beerID`) REFERENCES `beers` (`beerID`),
  CONSTRAINT `ratings_users_userID_fk` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.styles
CREATE TABLE IF NOT EXISTS `styles` (
  `styleID` int(11) NOT NULL AUTO_INCREMENT,
  `style_name` varchar(25) NOT NULL,
  PRIMARY KEY (`styleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.tags
CREATE TABLE IF NOT EXISTS `tags` (
  `tagID` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) NOT NULL,
  PRIMARY KEY (`tagID`),
  UNIQUE KEY `tags_tag_name_uindex` (`tag_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.types
CREATE TABLE IF NOT EXISTS `types` (
  `typeID` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.users
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `typeID` int(11) NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `users_types_typeID_fk` (`typeID`),
  CONSTRAINT `users_types_typeID_fk` FOREIGN KEY (`typeID`) REFERENCES `types` (`typeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table beer_tag.users_beers
CREATE TABLE IF NOT EXISTS `users_beers` (
  `beerID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `drinkState` tinyint(1) DEFAULT 0,
  KEY `users_beers_beers_beerID_fk` (`beerID`),
  KEY `users_beers_users_userID_fk` (`userID`),
  CONSTRAINT `users_beers_beers_beerID_fk` FOREIGN KEY (`beerID`) REFERENCES `beers` (`beerID`),
  CONSTRAINT `users_beers_users_userID_fk` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
