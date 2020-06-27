CREATE DATABASE FreeTech;
USE FreeTech;
CREATE TABLE `Administrador` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `password` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
); CREATE TABLE `Curso` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `descricao` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `dataCriacao` TIMESTAMP NOT NULL,
    `dataAtualizacao` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
); CREATE TABLE `Aula` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `descricao` TEXT(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `linkVideo` VARCHAR(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `transcricaoVideo` TEXT (1000000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `tempoVideo` SMALLINT unsigned NOT NULL,
    PRIMARY KEY (`id`)
); CREATE TABLE `Exercicio` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `questao` TEXT(6500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaCorreta` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta1` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta2` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta3` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta4` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `explicacao` TEXT(6500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `tempoResposta` INT unsigned NOT NULL,
    `pontos` TINYINT unsigned NOT NULL DEFAULT '1',
    PRIMARY KEY (`id`)
); CREATE TABLE `Usuario` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `nome` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `sobrenome` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `email` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `telefone` VARCHAR(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `dataNascimento` DATE NOT NULL,
    `pontos` SMALLINT unsigned NOT NULL,
    `instrutor` BOOLEAN NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
); CREATE TABLE `CursoInstrutor` (
    `idCurso` INT NOT NULL,
    `idUsuario` INT NOT NULL,
    PRIMARY KEY (`idCurso`, `idUsuario`),
    CONSTRAINT `fk_idCurso` FOREIGN KEY (`idCurso`) REFERENCES `Curso`(`id`),
    CONSTRAINT `fk_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario`(`id`)
); CREATE TABLE `UsuarioCurso` (
    `idUsuario` INT NOT NULL,
    `idCurso` INT NOT NULL,
    `pontos` SMALLINT UNSIGNED NOT NULL,
    `concluido` BOOLEAN NOT NULL DEFAULT '0',
    PRIMARY KEY (`idUsuario`, `idCurso`),
    CONSTRAINT `fk_idUsuarioInscrito` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario`(`id`),
    CONSTRAINT `fk_idCursoInscrito` FOREIGN KEY (`idCurso`) REFERENCES `Curso`(`id`)
);