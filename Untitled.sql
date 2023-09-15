-- MySQL Script generated by MySQL Workbench
-- Thu Sep 14 18:13:12 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema OrderManager
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `OrderManager` ;

-- -----------------------------------------------------
-- Schema OrderManager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OrderManager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `OrderManager` ;

-- -----------------------------------------------------
-- Table `OrderManager`.`Categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderManager`.`Categories` ;

CREATE TABLE IF NOT EXISTS `OrderManager`.`Categories` (
  `CategoryID` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`CategoryID`),
  UNIQUE INDEX `CategoryID_UNIQUE` (`CategoryID` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `OrderManager`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderManager`.`Customer` ;

CREATE TABLE IF NOT EXISTS `OrderManager`.`Customer` (
  `CustomerID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CustomerID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `OrderManager`.`OrderDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderManager`.`OrderDetail` ;

CREATE TABLE IF NOT EXISTS `OrderManager`.`OrderDetail` (
  `OrderDetailID` INT NOT NULL AUTO_INCREMENT,
  `OrderID` INT NOT NULL,
  `ProductID` INT NULL DEFAULT NULL,
  `Quantity` VARCHAR(45) NULL DEFAULT NULL,
  `UnitPrice` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`OrderDetailID`),
  UNIQUE INDEX `OrderDetailID_UNIQUE` (`OrderDetailID` ASC) VISIBLE,
  INDEX `ProductID_idx` (`ProductID` ASC) VISIBLE,
  INDEX `OrderID_idx` (`OrderID` ASC) VISIBLE,
  CONSTRAINT `OrderID`
    FOREIGN KEY (`OrderID`)
    REFERENCES `OrderManager`.`Orders` (`OrderID`),
  CONSTRAINT `ProductID`
    FOREIGN KEY (`ProductID`)
    REFERENCES `OrderManager`.`Products` (`ProductID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `OrderManager`.`Orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderManager`.`Orders` ;

CREATE TABLE IF NOT EXISTS `OrderManager`.`Orders` (
  `OrderID` INT NOT NULL AUTO_INCREMENT,
  `CustomerID` INT NULL DEFAULT NULL,
  `OrderDate` VARCHAR(45) NULL DEFAULT NULL,
  `TotalAmount` INT NULL DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  UNIQUE INDEX `OrderID_UNIQUE` (`OrderID` ASC) VISIBLE,
  INDEX `CustomerID_idx` (`CustomerID` ASC) VISIBLE,
  CONSTRAINT `CustomerID`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `OrderManager`.`Customer` (`CustomerID`),
  CONSTRAINT `FKbhieamq65ke02r8ijfso5tivn`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `OrderManager`.`customer` (`CustomerID`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `OrderManager`.`Products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderManager`.`Products` ;

CREATE TABLE IF NOT EXISTS `OrderManager`.`Products` (
  `ProductID` INT NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(45) NULL DEFAULT NULL,
  `ProductPrice` VARCHAR(45) NULL DEFAULT NULL,
  `StockQuantity` VARCHAR(45) NULL DEFAULT NULL,
  `CategoryID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE INDEX `ProductID_UNIQUE` (`ProductID` ASC) VISIBLE,
  INDEX `CategoryID_idx` (`CategoryID` ASC) VISIBLE,
  CONSTRAINT `CategoryID`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `OrderManager`.`Categories` (`CategoryID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
