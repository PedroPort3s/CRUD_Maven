-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `id_Categoria` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `taxaDepreciacao` FLOAT NULL,
  `prazoDepreciacao` INT NULL,
  `percValorResidual` FLOAT NULL,
  PRIMARY KEY (`id_Categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Automovel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Automovel` (
  `id` INT NOT NULL,
  `qtdRodas` INT NULL,
  `cor` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  `id_Categoria` INT NOT NULL,
  `quilometragem` DOUBLE NULL,
  `nome` VARCHAR(100) NULL,
  PRIMARY KEY (`id`, `id_Categoria`),
  INDEX `fk_Automovel_Categoria1_idx` (`id_Categoria` ASC) VISIBLE,
  CONSTRAINT `fk_Automovel_Categoria1`
    FOREIGN KEY (`id_Categoria`)
    REFERENCES `mydb`.`Categoria` (`id_Categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Carro` (
  `qtdPortas` INT NULL,
  `id_Aut` INT NOT NULL,
  PRIMARY KEY (`id_Aut`),
  INDEX `fk_Carro_Automovel_idx` (`id_Aut` ASC) VISIBLE,
  CONSTRAINT `fk_Carro_Automovel`
    FOREIGN KEY (`id_Aut`)
    REFERENCES `mydb`.`Automovel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reboque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Reboque` (
  `id_Reboque` INT NOT NULL,
  `quilometragemReboque` DOUBLE NULL,
  `valorReboque` DOUBLE NULL,
  `nomeReboque` VARCHAR(100) NULL,
  PRIMARY KEY (`id_Reboque`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Caminhao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Caminhao` (
  `id_Aut` INT NOT NULL,
  `qtdEixos` INT NULL,
  `id_Reboque` INT NOT NULL,
  PRIMARY KEY (`id_Aut`, `id_Reboque`),
  INDEX `fk_Caminhao_Reboque1_idx` (`id_Reboque` ASC) VISIBLE,
  CONSTRAINT `fk_table1_Automovel1`
    FOREIGN KEY (`id_Aut`)
    REFERENCES `mydb`.`Automovel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Caminhao_Reboque1`
    FOREIGN KEY (`id_Reboque`)
    REFERENCES `mydb`.`Reboque` (`id_Reboque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
