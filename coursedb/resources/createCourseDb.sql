CREATE SCHEMA `cs532_coursedb_ex` ;

CREATE TABLE `cs532_coursedb_ex`.`courses` (
  `courseid` INT NOT NULL AUTO_INCREMENT,
  `college` VARCHAR(25) NOT NULL,
  `coursenum` SMALLINT UNSIGNED NOT NULL,
  `coursename` VARCHAR(45) NULL,
  `numcredits` TINYINT ZEROFILL UNSIGNED NULL,
  PRIMARY KEY (`courseid`),
  UNIQUE INDEX `courseid_UNIQUE` (`courseid` ASC));
  
  CREATE TABLE `cs532_coursedb_ex`.`courseinstance` (
  `instanceid` INT NOT NULL AUTO_INCREMENT,
  `semester` VARCHAR(25) NOT NULL,
  `year` INT UNSIGNED NOT NULL,
  `courseid` SMALLINT NOT NULL,
  `numstudents` INT UNSIGNED ZEROFILL NULL,
  `day` VARCHAR(10) NULL,
  `time` TIME NULL,
  PRIMARY KEY (`instanceid`),
  UNIQUE INDEX `instanceid_UNIQUE` (`instanceid` ASC));
  

  
