CREATE SCHEMA `busdb` ;

CREATE TABLE `busdb`.`bus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `busid` VARCHAR(5) NOT NULL,
  `drivername` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(12) ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `busid_UNIQUE` (`busid` ASC));
  
  CREATE TABLE `busdb`.`student` (
  `studentid` INT,
  `name`  VARCHAR(20),
  `gender` varchar(8) ,
  PRIMARY KEY (`studentid`),
  ;
  
   CREATE TABLE `busdb`.`application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `studentid` INT REFERENCES `busdb`.`student`,
   `busid` VARCHAR(5) REFERENCES `busdb`.`bus`,
  `description` VARCHAR(20) NOT NULL,
  `carryon` VARCHAR(20),
  `Description` VARCHAR(30),
  PRIMARY KEY (`id`),
  );
  
INSERT INTO `orderdb`.`account` (`acctnum`,`name`,`phone`, `balance`) VALUES ('AB682','Bob Waston','651-321-4532', '150.75');
INSERT INTO `orderdb`.`account` (`acctnum`,`name`,`phone`, `balance`) VALUES ('GA379','Julia Shrde','245-864-2266','45.56');
INSERT INTO `orderdb`.`order` (`cusid`,`date`,`amount`) VALUES ('2','2016-03-22','32.71');
INSERT INTO `orderdb`.`order` (`cusid`,`date`,`amount`) VALUES ('1','2016-01-24','782.19');
INSERT INTO `orderdb`.`product` (`prodnum`,`description`,`price`, `numinstock`) VALUES ('ZX5000','Microwave','259.50','5');
INSERT INTO `orderdb`.`product` (`prodnum`,`description`,`price`, `numinstock`) VALUES ('KR3215','Blender','76.89',21);
INSERT INTO `orderdb`.`product` (`prodnum`,`description`,`price`, `numinstock`) VALUES ('PW2875','Coffee Maker','101.65',3);


select o.amount*p.price as Totalprice
from orderdb.product p,orderdb.order o
where o.id=p.id;