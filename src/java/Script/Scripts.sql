DROP DATABASE IF EXISTS DBRESERVEAQUI;

CREATE DATABASE DBRESERVEAQUI;

USE DBRESERVEAQUI;

CREATE TABLE usuario (
	idusuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	login VARCHAR(45) NOT NULL,
	senha VARCHAR(45) NOT NULL,
	email VARCHAR(150) NOT NULL
);

CREATE TABLE filme (
	idfilme INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NULL,
	descricao TEXT NULL,
	foto VARCHAR(100) NULL
);

CREATE TABLE locadora (
	idlocadora INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	cnpj VARCHAR(16) NOT NULL,
	rua VARCHAR(150) NULL,
	numero INT NULL,
	complemento VARCHAR(150) NULL,
	bairro VARCHAR(100) NULL,
	cidade VARCHAR(100) NULL,
	estado CHAR(2) NULL,
	cep CHAR(8) NULL,
	telefonecomercial VARCHAR(15) NULL,
	telefonecontato VARCHAR(15) NULL,
	email VARCHAR(100) NULL,
	site VARCHAR(100) NULL
	
);

CREATE TABLE filmelocadora (
	idfilmelocadora INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idfilme INT NOT NULL,
	idlocadora INT NOT NULL,
	dtcadastro DATE NULL,
	CONSTRAINT fk_fimelocadora_filme FOREIGN KEY (idfilme) REFERENCES filme(idfilme) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT fk_filmelocadora_locadora FOREIGN KEY (idlocadora) REFERENCES locadora (idlocadora) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE reserva (
	idreserva INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idusuario INT NOT NULL,
	idfilmelocadora INT NOT NULL,
	situacao ENUM('Pendente', 'Confirmado', 'Concluido', 'CanceladoUsuario', 'CanceladoLocadora') NOT NULL,
	dtreserva DATETIME NULL,
	dtconfirmada DATETIME NULL,
	dtconcluido DATETIME NULL,
	dtcancelado DATETIME NULL,
	motivo VARCHAR(255) NULL,
	CONSTRAINT fk_reserva_usuario FOREIGN KEY (idusuario) REFERENCES usuario (idusuario) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT fk_reserva_fimelocadora FOREIGN KEY (idfilmelocadora) REFERENCES filmelocadora (idfilmelocadora) ON DELETE NO ACTION ON UPDATE CASCADE
);
