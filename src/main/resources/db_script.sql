-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=''TRADITIONAL,ALLOW_INVALID_DATES'';

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
CREATE TABLE IF NOT EXISTS `bg`.`User` (
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
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
CREATE TABLE IF NOT EXISTS `bg`.`Unit` (
  `UNIT_ID` INT NOT NULL AUTO_INCREMENT,
  `PRICE` INT NOT NULL,
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
CREATE TABLE IF NOT EXISTS `bg`.`Photos` (
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
CREATE TABLE IF NOT EXISTS `bg`.`Review` (
  `UNIT_ID` INT NOT NULL,
  `REVIEW` VARCHAR(200) NULL,
  `SCORE` INT NULL,
  `USERNAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UNIT_ID`, `USERNAME`),
  INDEX `fk_User_has_Residence_Residence1_idx` (`UNIT_ID` ASC),
  INDEX `fk_Review_User1_idx` (`USERNAME` ASC),
  CONSTRAINT `fk_User_has_Residence_Residence1`
    FOREIGN KEY (`UNIT_ID`)
    REFERENCES `bg`.`Unit` (`UNIT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Review_User1`
    FOREIGN KEY (`USERNAME`)
    REFERENCES `bg`.`User` (`USERNAME`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
