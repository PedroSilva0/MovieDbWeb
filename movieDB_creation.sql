CREATE DATABASE `moviedb` /*!40100 DEFAULT CHARACTER SET utf8 */;

use moviedb;

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Avatar` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `movie` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Duration` int(11) NOT NULL,
  `Release_day` int(11) NOT NULL,
  `Release_month` int(11) NOT NULL,
  `Release_year` int(11) NOT NULL,
  `Rating` float NOT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Poster` varchar(255) DEFAULT NULL,
  `Genre` varchar(255) DEFAULT NULL,
  `Synopsys` varchar(255) DEFAULT NULL,
  `Box_office` float NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `staff` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Bio` varchar(255) DEFAULT NULL,
  `Picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `lists` (
  `UserId` int(11) NOT NULL,
  `MovieId` int(11) NOT NULL,
  `list_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserId`,`MovieId`),
  KEY `creates` (`UserId`),
  KEY `FKLists656203` (`MovieId`),
  CONSTRAINT `FKLists656203` FOREIGN KEY (`MovieId`) REFERENCES `movie` (`Id`),
  CONSTRAINT `creates` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ratings` (
  `UserId` int(11) NOT NULL,
  `MovieId` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserId`,`MovieId`),
  KEY `FKRatings736484` (`UserId`),
  KEY `evaluates` (`MovieId`),
  CONSTRAINT `FKRatings736484` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`),
  CONSTRAINT `evaluates` FOREIGN KEY (`MovieId`) REFERENCES `movie` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `review` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MovieId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `Review` varchar(255) DEFAULT NULL,
  `Sound_grade` int(11) NOT NULL,
  `Story_grade` int(11) NOT NULL,
  `Direction_grade` int(11) NOT NULL,
  `Enjoyment_grade` int(11) NOT NULL,
  `Overall_grade` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `reviews` (`UserId`),
  KEY `has` (`MovieId`),
  CONSTRAINT `has` FOREIGN KEY (`MovieId`) REFERENCES `movie` (`Id`),
  CONSTRAINT `reviews` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `movie_staff` (
  `MovieId` int(11) NOT NULL,
  `StaffId` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MovieId`,`StaffId`),
  KEY `FKMovie_Staf787137` (`MovieId`),
  KEY `participates` (`StaffId`),
  CONSTRAINT `FKMovie_Staf787137` FOREIGN KEY (`MovieId`) REFERENCES `movie` (`Id`),
  CONSTRAINT `participates` FOREIGN KEY (`StaffId`) REFERENCES `staff` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
