-- MySQL Script generated by MySQL Workbench
-- Fri Jun  2 11:09:43 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema livro-api
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `livro-api` ;

-- -----------------------------------------------------
-- Schema livro-api
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `livro-api` DEFAULT CHARACTER SET utf8 ;
USE `livro-api` ;

-- -----------------------------------------------------
-- Table `livro-api`.`livro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `livro-api`.`livro` ;

CREATE TABLE IF NOT EXISTS `livro-api`.`livro` (
  `id` VARCHAR(36) NOT NULL,
  `titulo` VARCHAR(200) NULL,
  `autor` VARCHAR(200) NULL,
  `editora` VARCHAR(200) NULL,
  `ano` INT NULL,
  `preco` DECIMAL(5,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
