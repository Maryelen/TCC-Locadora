-- MySQL Script generated by MySQL Workbench
-- 10/16/14 20:26:08
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bdReservaLocadora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdReservaLocadora` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bdReservaLocadora` ;

-- -----------------------------------------------------
-- Table `bdReservaLocadora`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdReservaLocadora`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(100) NOT NULL,
  `CPF` VARCHAR(45) NULL,
  `telefoneResidencial` VARCHAR(45) NULL,
  `telefoneCelular` VARCHAR(45) NULL,
  `telefoneRecado` VARCHAR(45) NULL,
  `email` VARCHAR(150) NULL,
  `endereco` VARCHAR(150) NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `login` VARCHAR(150) NULL,
  `senha` VARCHAR(100) NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idCliente_UNIQUE` (`idCliente` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdReservaLocadora`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdReservaLocadora`.`Reserva` (
  `idReserva` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idReserva`, `Cliente_idCliente`),
  UNIQUE INDEX `idReserva_UNIQUE` (`idReserva` ASC),
  INDEX `fk_Reserva_Cliente1_idx` (`Cliente_idCliente` ASC),
  CONSTRAINT `fk_Reserva_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `bdReservaLocadora`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdReservaLocadora`.`Filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdReservaLocadora`.`Filme` (
  `idFilme` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nomeFilme` VARCHAR(75) NOT NULL,
  `anoFilme` INT NOT NULL,
  `generoFilme` VARCHAR(45) NOT NULL,
  `diretorFilme` VARCHAR(75) NULL,
  `codigoFilme` INT UNSIGNED NOT NULL,
  `midiaFilme` VARCHAR(45) NULL,
  `sinopseFilme` VARCHAR(1000) NULL,
  `produtoraFilme` VARCHAR(45) NULL,
  `classificacaoIndicativaFilme` VARCHAR(45) NOT NULL,
  `valorPagoLocadora` DOUBLE NULL,
  `classificacaoValorFilme` VARCHAR(45) NOT NULL,
  `Reserva_idReserva` INT NOT NULL,
  PRIMARY KEY (`idFilme`, `Reserva_idReserva`),
  INDEX `fk_Filme_Reserva_idx` (`Reserva_idReserva` ASC),
  CONSTRAINT `fk_Filme_Reserva`
    FOREIGN KEY (`Reserva_idReserva`)
    REFERENCES `bdReservaLocadora`.`Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
