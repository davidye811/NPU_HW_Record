CREATE SCHEMA `orderdb` ;

CREATE TABLE `orderdb`.`account` (
  `id` INT NOT NULL ,
  `acctnum` VARCHAR(5) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(12) ,
  `balance` DECIMAL(9,2) ZEROFILL NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `acctnum_UNIQUE` (`acctnum` ASC));
  
  CREATE TABLE `orderdb`.`order` (
  `id` INT  REFERENCES `orderdb`.`product`,
  `cusid` REFERENCES `orderdb`.`account`,
  `date` date NOT NULL,
  `amount` DECIMAL(9,2) ZEROFILL NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cusid_UNIQUE` (`cusid` ASC));
  
   CREATE TABLE `orderdb`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `prodnum` VARCHAR(6) NOT NULL,
  `description` VARCHAR(20) NOT AUTO_INCREMENTNULL,
  `price` DECIMAL(9,2) ZEROFILL NULL,
  `numinstock` DECIMAL(9) ZEROFILL NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cusid_UNIQUE` (`prodnum` ASC));
  
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