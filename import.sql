-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
-- -----------------------------------------------------
-- Schema bg
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bg
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bg` DEFAULT CHARACTER SET utf8 ;
USE `bg` ;

-- -----------------------------------------------------
-- Table `bg`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bg`.`user` (
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(256) NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `PHONE_NUMBER` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC),
  PRIMARY KEY (`USERNAME`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bg`.`Unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bg`.`unit` (
  `UNIT_ID` INT NOT NULL AUTO_INCREMENT,
  `PRICE` INT NOT NULL,
  `AVERAGE_SCORE` DOUBLE NOT NULL,
  `TITLE` VARCHAR(200) NOT NULL,
  `DESCRIPTION` VARCHAR(200) NOT NULL,
  `REGION` VARCHAR(45) NOT NULL,
  `CANCELLATION_POLICY` VARCHAR(200) NULL,
  PRIMARY KEY (`UNIT_ID`),
  UNIQUE INDEX `RESIDENCE_ID_UNIQUE` (`UNIT_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bg`.`Photos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bg`.`photos` (
  `PHOTO_ID` INT NOT NULL AUTO_INCREMENT,
  `PATH` VARCHAR(45) NOT NULL,
  `UNIT_ID` INT NOT NULL,
  PRIMARY KEY (`PHOTO_ID`),
  UNIQUE INDEX `PHOTO_ID_UNIQUE` (`PHOTO_ID` ASC),
  INDEX `fk_Photos_Residences1_idx` (`UNIT_ID` ASC),
  CONSTRAINT `fk_Photos_Residences1`
    FOREIGN KEY (`UNIT_ID`)
    REFERENCES `bg`.`Unit` (`UNIT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bg`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bg`.`review` (
  `USERNAME` VARCHAR(45) NOT NULL,
  `UNIT_ID` INT NOT NULL,
  `score` INT NOT NULL,
  `comment` VARCHAR(200) NULL,
  PRIMARY KEY (`USERNAME`, `UNIT_ID`),
  INDEX `fk_Review_Unit1_idx` (`UNIT_ID` ASC),
  INDEX `fk_Review_User1_idx` (`USERNAME` ASC),
  CONSTRAINT `fk_USERNAME`
    FOREIGN KEY (`USERNAME`)
    REFERENCES `bg`.`User` (`USERNAME`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UNIT_ID`
    FOREIGN KEY (`UNIT_ID`)
    REFERENCES `bg`.`Unit` (`UNIT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into user(username,name,surname,PASSWORD,email,phone_number)
values ('pk','','','$2a$12$.eNfQVZf1JxUGosbhZMXW.gq1CvD1HWs9CRyxARQ4GxtgF3TjFl/a','','') on duplicate key update username=username;

insert into user(username,name,surname,PASSWORD,email,phone_number)
values ('pk1','','','$2a$12$.eNfQVZf1JxUGosbhZMXW.gq1CvD1HWs9CRyxARQ4GxtgF3TjFl/a','','') on duplicate key update username=username;

insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE)
values ('1',0,'','',120,'paris','one') on duplicate key update unit_id=unit_id;

insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE)
values ('2',0,'','',120,'athens','two') on duplicate key update unit_id=unit_id;

insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE)
values ('3',0,'','',120,'rome','three') on duplicate key update unit_id=unit_id;

insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE)
values ('4',0,'','',90,'athens','four') on duplicate key update unit_id=unit_id;

insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE) values ('5',0,'','',80,'athens','one') on duplicate key update unit_id=unit_id;
insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE) values ('6',0,'','',70,'paris','two') on duplicate key update unit_id=unit_id;
insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE) values ('7',0,'','',80,'rome','four') on duplicate key update unit_id=unit_id;
insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE) values ('8',0,'','',90,'rome','five') on duplicate key update unit_id=unit_id;
insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE) values ('9',0,'','',90,'athens','one') on duplicate key update unit_id=unit_id;
insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE) values ('10',0,'','',100,'paris','one') on duplicate key update unit_id=unit_id;
insert into unit(UNIT_ID,AVERAGE_SCORE,CANCELLATION_POLICY,DESCRIPTION,PRICE,REGION,TITLE) values ('11',0,'','',123,'paris','one') on duplicate key update unit_id=unit_id;
